package CommandCheking;

import GameClasses.Game;
import java.util.ArrayList;
import java.util.List;

public class PosisionInRoom {

    private static String oldPossision = "evrywhere";
    private static String newPossision = "center";
    private static String oldRoom = "forest";

    public String possisionInRoom(String[] order, String finaltext) {
        List<String[]> listWithDirections = new ArrayList<>();
        boolean isInList = false;

        newRoomNewPossision(finaltext);
        listWithDirections = fillList(listWithDirections);
        isInList = isInListTheOrder(listWithDirections, order);
        changePlaces(isInList, order);
        finaltext = finalTextIfOrderIsDiretion(listWithDirections, order, finaltext);
        finaltext = checkIfNewPlaceEqualsOldPlace(finaltext, isInList);

        return finaltext;
    }

    private void newRoomNewPossision(String finaltext) {
// TODO otan mpenei se alo domatio na se pigenei sthn antitheth meria poy eisai px apo left right apo panw katw 

        if (!oldRoom.matches(Game.getActiveUser().getRoomYouAre())) {
            oldRoom = Game.getActiveUser().getRoomYouAre();
            Game.getActiveUser().setPossisionInRoom("center");
            newPossision = "center";
        }

    }

    private String checkIfNewPlaceEqualsOldPlace(String finaltext, boolean isInlist) {
        if (isInlist == true) {
            if (oldPossision.equals(newPossision)) {
                finaltext = "You are already there";
                oldPossision = "i dont know its just a bug";
            }
        }
        return finaltext;
    }

    private String finalTextIfOrderIsDiretion(List<String[]> listWithDirections, String[] order, String finaltext) {
        for (int i = 0; i < listWithDirections.size(); i++) {
            if (listWithDirections.get(i)[0].equals(order[0]) && listWithDirections.get(i)[1].equals(order[1])) {
                finaltext = listWithDirections.get(i)[2];
            }
        }

        return finaltext;
    }

    private void changePlaces(boolean isInList, String[] order) {

        if (isInList == true) {
            Game.getActiveUser().setPossisionInRoom(order[1]);
            oldPossision = newPossision;
            newPossision = order[1];
        }

    }

    private Boolean isInListTheOrder(List<String[]> listWithDirections, String[] order) {
        boolean isInList = false;
        for (int i = 0; i < listWithDirections.size(); i++) {
            if (listWithDirections.get(i)[0].equals(order[0]) && listWithDirections.get(i)[1].equals(order[1])) {
                isInList = true;
            }
        }
        return isInList;
    }

    private List fillList(List<String[]> listWithDirections) {

        String[] left = {"move", "left", "You Are In left Side of this area"};
        String[] right = {"move", "right", "You Are In right Side of this area"};
        String[] forward = {"move", "forward", "You Are In Front Side of this area "};
        String[] back = {"move", "back", "You Are In Back Side of this area "};
        String[] center = {"move", "center", "You Are In Center of this area "};

        listWithDirections.add(left);
        listWithDirections.add(right);
        listWithDirections.add(forward);
        listWithDirections.add(back);
        listWithDirections.add(center);

        return listWithDirections;
    }

}

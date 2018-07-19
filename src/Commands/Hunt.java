package Commands;

import CommandCheking.DoCommand;
import GUIControler.UpdateMethods;
import Handlers.Inventory;
import java.util.List;
import GameClasses.Game;
import Storys.MainStory;


public class Hunt implements KeyOrder {

    @Override
    public String exec(String command) {
        String finaltext = null;
           DoCommand doCommand = new DoCommand();
        List<Inventory> listWithInvertory = doCommand.getListWithInvertory();
        boolean haveItemForhunt = false;
        for (String areasCanHunt : MainStory.areasCanHunt) {
            if (Game.getActiveUser().getRoomYouAre().equals(areasCanHunt)) {
                for (int i = 0; i < listWithInvertory.size(); i++) {
                    for (String itemsCanHunt : MainStory.itemsCanHunt) {
                        if (itemsCanHunt.equals(listWithInvertory.get(i).getItem())) {
                            Game.setPiceOfDay(Game.getPiceOfDay() + 12);
                            String zooCauch = zooInArea(areasCanHunt);
                            Inventory inv = new Inventory(Game.getActiveUser().getUserName(), zooCauch);
                            listWithInvertory.add(inv);
                            finaltext = "After a long time I caught a " + zooCauch + ".... i can eat it later ";
                            haveItemForhunt = true;
                            inv = null;
                            break;
                        }
                    }
                }
                break;
            } else {
                finaltext = "You cant Hunt In This Area";
            }
        }
        if (haveItemForhunt == false) {
            finaltext = "You have no items that can you use to hunt";
        }
        doCommand.setListWithInvertory(listWithInvertory);

        return finaltext;
    }

    private String zooInArea(String area) {
        String zoo = "";
        if (area.equals("forest") || area.equals("forestnorth")) {
            zoo = "rabit";
        } else if (area.equals("field")) {
            zoo = "pig";
        } else if (area.equals("lake")) {
            zoo = "duck";
        }
        return zoo;
    }
}

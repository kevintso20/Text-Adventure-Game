package Commands;

import GUIControler.UpdateMethods;
import Storys.InheritanceCommands;
import GameClasses.Game;
import GameClasses.Zork;

public class Sleep implements KeyOrder {

    @Override
    public String exec(String command) {
        String finaltext = "";
        String[][] connectRoomsSubRooms = InheritanceCommands.getConnectRoomsSubRooms();
        UpdateMethods updateMethods = new UpdateMethods();
        if (Game.getIsDayNow() == false) {
            if (Game.getActiveUser().getRoomYouAre().equals("treehousebed") || Game.getActiveUser().getRoomYouAre().equals("castlebed")) {
                finaltext = "Good night Cya next morning.... A new Day a new adventure Lets do it...  ";
                Game.setIsDayNow(true);
                Game.setPiceOfDay(0);
                LightsOnOff.stateOfLighter = 0;
                LightsOnOff.preveusStateOfLighter = 1;
               Game.setCountRounds(Game.getCountRounds() + 15);
                updateMethods.updateHealthPoints(Game.getActiveUser().getCurrentHp() + 15);

            } else {
                finaltext = "You need to find a bed to sleep ";
            }
        } else {
            finaltext = "You Can't sleep now its day!!!";
        }

       return finaltext;
    }
}

package Commands;

import CommandCheking.DoCommand;
import GameClasses.Game;
import Handlers.Inventory;
import java.util.List;

public class Cut implements KeyOrder {

    public static boolean haveCutedTrees = false;

    @Override
    public String exec(String command) {
        String finaltext = "";
        DoCommand doCommand = new DoCommand();
        List<Inventory> listWithInvertory = doCommand.getListWithInvertory();

        if (Game.getActiveUser().getRoomYouAre().equals("lake") || Game.getActiveUser().getRoomYouAre().equals("warehouse")) {
            for (Inventory inventory : listWithInvertory) {
                if (inventory.getItem().equals("axe")) {
                    Game.setPiceOfDay(Game.getPiceOfDay() + 9);
                    finaltext = " after a lot of time i cut some the trees";
                    haveCutedTrees = true;
                    break;
                } else {
                    finaltext = "you have not axe soo you cant cut trees";
                }
            }
        } else {
            finaltext = "you are not in place you can cut trees";
        }
        return finaltext;
    }

}

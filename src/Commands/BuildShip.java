package Commands;

import CommandCheking.DoCommand;
import GameClasses.Game;
import Handlers.Inventory;
import static Commands.Cut.haveCutedTrees;
import java.util.List;

public class BuildShip implements KeyOrder {

    @Override
    public String exec(String command) {
        String finaltext = "";
        DoCommand doCommand = new DoCommand();
        List<Inventory> listWithInvertory = doCommand.getListWithInvertory();

        if (Game.getActiveUser().getRoomYouAre().equals("lake") || Game.getActiveUser().getRoomYouAre().equals("warehouse")) {
            for (Inventory inventory : listWithInvertory) {
                if (haveCutedTrees == true) {
                    if (inventory.getItem().equals("hamer")) {
                        Game.setPiceOfDay(Game.getPiceOfDay() + 15);
                        finaltext = "i finaly build a ship";
                        break;
                    } else {
                        finaltext = "you have not hamer soo you cant build something";
                    }
                } else {
                    finaltext = "you need to cut trees before you build the ship";
                }
            }
        } else {
            finaltext = "you are not in place you can build";
        }

        return finaltext;
    }

}

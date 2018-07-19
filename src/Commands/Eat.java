package Commands;

import CommandCheking.DoCommand;
import GUIControler.UpdateMethods;
import Storys.MainStory;
import java.util.List;
import Handlers.Inventory;

import GameClasses.Game;
import GameClasses.Zork;

public class Eat implements KeyOrder {

    @Override
    public String exec(String command) {

        DoCommand doCommand = new DoCommand();
        String[] commandSplited = command.split(" ");
         List<Inventory> listwithInventory = doCommand.getListWithInvertory();
        
        String finaltext = "dude seriously now you order me to eat " + commandSplited[1] + "?";
        UpdateMethods updateMethods = new UpdateMethods();

        for (String itemsCanEat : MainStory.itemsCanEat) {
            if (commandSplited[1].equals(itemsCanEat)) {
                for (int j = 0; j < listwithInventory.size(); j++) {
                    if (commandSplited[1].equals(listwithInventory.get(j).getItem())) {
                        finaltext = "a very delicius " + listwithInventory.get(j).getItem();
                        updateMethods.updateHealthPoints(Game.getActiveUser().getCurrentHp() + 15);
                        listwithInventory.remove(j);
                        break;
                    } else {
                        finaltext = "you can't eat it if you not have it!!!!";
                    }
                }
            }
        }

        return finaltext;
    }

}

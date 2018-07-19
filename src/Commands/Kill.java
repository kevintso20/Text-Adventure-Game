package Commands;

import CommandCheking.DoCommand;
import GUIControler.UpdateMethods;
import GameClasses.Game;
import Handlers.Inventory;
import Storys.MainStory;
import java.util.List;

public class Kill implements KeyOrder {

    @Override
    public String exec(String command) {
        String finaltext = "You have not any weapon!!!";
           DoCommand doCommand = new DoCommand();
        List<Inventory> listWithInvertory = doCommand.getListWithInvertory();

        if (Game.isStillFighting() == true) {
            for (String itemscanHunt : MainStory.itemsCanHunt) {
                for (Inventory listWithInvertory1 : listWithInvertory) {
                    if (listWithInvertory1.getItem().equals(itemscanHunt)) {

// TODO na kanw to teras na stamataei kai na vgazei to teliko minima :D oti kai kala nikises
                        finaltext = "You kill the monster !!!";
                    }
                }
            }
        } else if (Game.isStillFighting() == false) {
            finaltext = "There isn't any monster here!!!";
        }
        return finaltext;
    }

}

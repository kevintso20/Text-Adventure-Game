package Commands;

import CommandCheking.DoCommand;
import GUIControler.UpdateMethods;
import Handlers.Inventory;
import java.util.List;

public class ShowInventory implements KeyOrder {

    @Override
    public String exec(String command) {
           DoCommand doCommand = new DoCommand();
        List<Inventory> inventoryList = doCommand.getListWithInvertory();
        String finaltext = " ";
            int i = 0;

            if (inventoryList.get(i).getItem().equals(finaltext)) {

                finaltext = "The inventory is empty";
            } else {

                for (i = 0; i < inventoryList.size(); i++) {

                    finaltext = "You have " + (inventoryList.get(i)).getItem() + " in your inventory";
                }
            }

        return finaltext;
    }

}

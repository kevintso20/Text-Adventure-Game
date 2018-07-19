package Commands;

import GameClasses.Game;
import Handlers.Inventory;
import Storys.InheritanceCommands;
import Handlers.Item;
import java.util.List;
import Objects.Order;
import CommandCheking.DoCommand;
import GUIControler.UpdateMethods;

public class Drop implements KeyOrder {

    public String exec(String command) {
        String finaltext = null;
         DoCommand doCommand = new DoCommand();
        String[] commandSplited = command.split(" ");

        List<Inventory> listWithInventorys = doCommand.getListWithInvertory();
        List<Item> listWithItems = doCommand.getListWithItems();
        List<Order> listWithOrders = doCommand.getListWithOrders();

        for (int i = 0; i < listWithItems.size(); i++) {
            if (listWithItems.get(i).getItemName().equals(commandSplited[1])) {
                for (int j = 0; j < listWithInventorys.size(); j++) {
                    if (listWithInventorys.get(j).getItem().equals(commandSplited[1])) {
                        listWithInventorys.remove(j);
                        listWithItems.get(i).setIsTaken(false);

                        Order order = new Order();
                        order.setVerb("take");
                        order.setNoun(commandSplited[1]);
                        order.setRoomName(Game.getActiveUser().getRoomYouAre());
                        order.setSideInRoom(Game.getActiveUser().getPossisionInRoom());
                        order.setInventoryItem("   ");
                        order.setCorrectOrderText(commandSplited[1] + " puted to your invertory");
                        order.setWrongOrderText("take What???");
                        order.setAffectsInventory("import");
                        order.setToDoAfterCorrectOrder(commandSplited[1]);
                        order.setCanBeAppliedEverywhere("yes");

                        finaltext = "You Drop " + commandSplited[1] + " into " + Game.getActiveUser().getRoomYouAre();
                        listWithOrders.add(order);
                        break;
                    } else {
                        finaltext = "You dont have " + commandSplited[1];
                    }
                }
            }
        }

        doCommand.setListWithInvertory(listWithInventorys);
        doCommand.setListWithItems(listWithItems);
        doCommand.setListWithOrders(listWithOrders);

        return finaltext;
    }

}

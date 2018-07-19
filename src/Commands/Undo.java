package Commands;

import CommandCheking.DoCommand;
import GUIControler.UpdateMethods;
import Objects.Order;
import java.util.List;

public class Undo implements KeyOrder {

    @Override
    public String exec(String command) {
           DoCommand doCommand = new DoCommand();
        List<Order> orderListAfterUndo = doCommand.getListWithOrders();
        String finaltext = "kaas";
        UpdateMethods updateMethods = new UpdateMethods();
        DoCommand ordersAfterUndo = new DoCommand();

       

            for (int j = orderListAfterUndo.size(); j > 0; j--) {

                /*orderListAfterUndo.get(j).getNoun();
                      orderListAfterUndo.get(j).getRoomName();
                      orderListAfterUndo.get(j).getSideInRoom();
                      orderListAfterUndo.get(j).getInventoryItem();
                      orderListAfterUndo.get(j).getCorrectOrderText(); 
                      orderListAfterUndo.get(j).getWrongOrderText();
                      orderListAfterUndo.get(j).getToDoAfterCorrectOrder();
                      orderListAfterUndo.get(j).getAffectsInventory();
                      orderListAfterUndo.get(j).getCanBeAppliedEverywhere();*/
                finaltext = "" + orderListAfterUndo.get(j).getVerb();
                finaltext = "" + orderListAfterUndo.get(j).getNoun();
                finaltext = "" + orderListAfterUndo.get(j).getRoomName();
                finaltext = "" + orderListAfterUndo.get(j).getSideInRoom();
                finaltext = "" + orderListAfterUndo.get(j).getInventoryItem();
                finaltext = "" + orderListAfterUndo.get(j).getCorrectOrderText();
                finaltext = "" + orderListAfterUndo.get(j).getWrongOrderText();
                finaltext = "" + orderListAfterUndo.get(j).getToDoAfterCorrectOrder();
                finaltext = "" + orderListAfterUndo.get(j).getAffectsInventory();
                finaltext = "" + orderListAfterUndo.get(j).getCanBeAppliedEverywhere();

                orderListAfterUndo.remove(j);
                doCommand.setListWithOrders(orderListAfterUndo);

                break;

            }
        return finaltext;

    }
    //TODO: oti leei h leksi tha kanei undo thn entolh poy ekaens
}

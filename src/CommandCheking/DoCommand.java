package CommandCheking;

import Handlers.Inventory;
import Objects.Order;
import Handlers.Item;
import GameClasses.Game;
import java.util.ArrayList;
import java.util.List;
import Storys.MainStory;
import Commands.Drop;
import GUIControler.UpdateMethods;

public class DoCommand {

    //   Id Antikimenoy || Onoma || Onoma Domatioy Poy Anikei  
    private  static List<Item> listWithItems = new ArrayList<>();
    //   Rima || Ousiastiko || Onoma Domatioy || Item Invertory|| Swsth Entolh  text || Lathos Entolh text || Energeia Swsth Epilogh Text
    private static List<Order> listWithOrders = new ArrayList<>();
    //   user || itemHundler 
    private static List<Inventory> listWithInvertory = new ArrayList<>();

    private  static Boolean iWantToCallit = true;
    public Inventory itemFromGodMode = new Inventory();
    MainStory storyfile = new MainStory();
    PosisionInRoom possisionOfPlayerInRoom = new PosisionInRoom();
    Item itemHundler = new Item();   
    Inventory controlInventory = new Inventory();  
    NotFound orderNotFoundCheckIf = new NotFound();
    Drop drop = new Drop();

    public void findTheCommand(String[] orders) {
        UpdateMethods updateMethods = new UpdateMethods();
        String finaltext = "duno";
        finaltext = possisionOfPlayerInRoom.possisionInRoom(orders, finaltext);
        if (iWantToCallit == true) {
            listWithOrders = storyfile.makeTheStory(listWithOrders, iWantToCallit);
            listWithItems = itemHundler.getItemsFromOrder(listWithOrders, listWithItems, iWantToCallit);
            Inventory inv3 = new Inventory(Game.getActiveUser().getUserName(), "");
            listWithInvertory.add(inv3);
            iWantToCallit = false;
        }

        if (orders.length == 2) {
            for (int i = 0; i < getListWithOrders().size(); i++) {
                if (getListWithOrders().get(i).getVerb().equals(orders[0]) && getListWithOrders().get(i).getNoun().equals(orders[1]) && getListWithOrders().get(i).getRoomName().equals(Game.getActiveUser().getRoomYouAre())) {
                    if (getListWithOrders().get(i).getCanBeAppliedEverywhere().equals("yes")) {
                        finaltext = getListWithOrders().get(i).getCorrectOrderText();
                        finaltext = runTheCommand(getListWithOrders().get(i).getAffectsInventory(), Game.getActiveUser().getUserName(), getListWithOrders().get(i).getToDoAfterCorrectOrder(), finaltext, getListWithOrders().get(i).getInventoryItem(), i);
                        break;
                    } else {
                        if (getListWithOrders().get(i).getSideInRoom().matches(Game.getActiveUser().getPossisionInRoom())) {
                            finaltext = getListWithOrders().get(i).getCorrectOrderText();
                            finaltext = runTheCommand(getListWithOrders().get(i).getAffectsInventory(), Game.getActiveUser().getUserName(), getListWithOrders().get(i).getToDoAfterCorrectOrder(), finaltext, getListWithOrders().get(i).getInventoryItem(), i);
                            break;
                        } else {
                            finaltext = "You cannot do that from that side";
                        }
                    }
                }
            }

        }
        if (finaltext.matches("duno")) {
            finaltext = orderNotFoundCheckIf.ifnotFoundComand(orders, finaltext);
            finaltext = orderNotFoundCheckIf.ifOrderNotFoundReturnPossOfVerb(listWithOrders, orders[0], finaltext);
        }

        updateMethods.updateFinalText(finaltext);
    }

    private String runTheCommand(String AffectsInventory, String userName, String todoafterOrder, String finaltext, String neededItem, int posOfOrder) {
        Inventory inv = new Inventory();
        inv.setUser(userName);
        inv.setItem(todoafterOrder);
        Item item;
        boolean isInInvertory = false;
        if (AffectsInventory.matches("import")) {
            item = itemHundler.giveNameReturnObject(todoafterOrder,getListWithItems());
            if (item.isIsTaken() == false) {
                listWithInvertory.add(inv);
                getListWithItems().remove(item.getItemID());
                item.setIsTaken(true);
                Item newItem = new Item(item.getItemID(), item.getItemName(), item.getRoomNameItBelongs(), true);
                getListWithItems().add(newItem);
                item = null;
            } else {
                finaltext = "you have take this item before";
            }
        } else if (AffectsInventory.matches("delete")) {
            isInInvertory = controlInventory.CheckIfiIsInInvertory(getListWithInvertory(), neededItem);
            if (isInInvertory == true) {
                listWithInvertory.remove(Inventory.possisionOfItemInInvertory);
                Game.getActiveUser().setRoomYouAre(todoafterOrder);
                deleteOldOrderMakeNew(posOfOrder);
            } else {
                finaltext = "you not have this item";
            }
        } else if (AffectsInventory.matches("nothing")) {
            Game.getActiveUser().setRoomYouAre(todoafterOrder);
        }
        return finaltext;
    }

    private void deleteOldOrderMakeNew(int possisionOforder) {
        Order newOrder = new Order();
        newOrder = listWithOrders.get(possisionOforder);
        newOrder.setAffectsInventory("nothing");
        newOrder.setInventoryItem("   ");
        listWithOrders.add(newOrder);

    }

    public static List<Item> getListWithItems() {
        return listWithItems;
    }

    public static void setListWithItems(List<Item> listWithItems) {
        DoCommand.listWithItems = listWithItems;
    }

    public static List<Order> getListWithOrders() {
        return listWithOrders;
    }

    public static void setListWithOrders(List<Order> listWithOrders) {
        DoCommand.listWithOrders = listWithOrders;
    }

    public  List<Inventory> getListWithInvertory() {
        return listWithInvertory;
    }

    public static void setListWithInvertory(List<Inventory> listWithInvertory) {
        DoCommand.listWithInvertory = listWithInvertory;
    }

    

}

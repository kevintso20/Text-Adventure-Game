/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Objects.Order;
import java.util.List;

public class Item {

    public static int timesCaled = 0;
    int itemID;
    String itemName;
    String roomNameItBelongs;
    boolean isTaken;

    public List insertItem(List<Item> list, Item e) {
        list.add(e);
        return list;
    }

    public List deleteItemFromEverywhere(List<Item> list, Item e) {
        int i = 0;
        for (i = 0; i < list.size(); i++) {
            if (String.valueOf(list.get(i).getItemID()).equals(String.valueOf(e.getItemID()))) {
                list.remove(i);
            }
        }
        return list;
    }

    public List editItem(List<Item> list, Item e) {
        int i = 0;
        for (i = 0; i < list.size(); i++) {
            if (String.valueOf(list.get(i).getItemID()).equals(String.valueOf(e.getItemID()))) {
                list.set(i, e);
            }
        }
        return list;
    }

    public Item returnItemFromId(List<Item> list, int id) {
        Item returningItem = new Item();
        int i = 0;
        for (i = 0; i < list.size(); i++) {
            if (String.valueOf(list.get(i).getItemID()).equals(String.valueOf(id))) {
                returningItem.setItemID(list.get(i).getItemID());
                returningItem.setRoomNameItBelongs(list.get(i).getRoomNameItBelongs());
                returningItem.setItemName(list.get(i).getItemName());
            }
        }
        return returningItem;
    }

    public List DeleteItemFromThisRoom(List<Item> list, String roomName, String itemName) {
        int i = 0;
        for (i = 0; i < list.size(); i++) {
            if (String.valueOf(list.get(i).getRoomNameItBelongs()).equals(String.valueOf(roomName)) && list.get(i).getItemName().matches(itemName)) {
                list.remove(i);
            }
        }
        return list;
    }

    public List getItemsFromOrder(List<Order> listWithOrders, List<Item> listWithItems, boolean iWantToCallIt) {
        if (iWantToCallIt == true) {
            int itemId = 0;
            for (int i = 0; i < listWithOrders.size(); i++) {
                if (listWithOrders.get(i).getVerb().matches("take")) {
                    
                    Item newItem = new Item();
                    itemId++;
                    newItem.setItemID(itemId);
                    newItem.setItemName(listWithOrders.get(i).getToDoAfterCorrectOrder());
                    newItem.setRoomNameItBelongs(listWithOrders.get(i).getRoomName());
                    listWithItems.add(newItem);
                    newItem = null;
                }
            }
        }
        return listWithItems;
    }

    public Item giveNameReturnObject(String itemName, List<Item> list) {
        Item item = new Item();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getItemName().equals(itemName)) {
                item.setItemID(list.get(i).getItemID());
                item.setItemName(list.get(i).getItemName());
                item.setRoomNameItBelongs(list.get(i).getRoomNameItBelongs());
                item.setIsTaken(list.get(i).isIsTaken());
                break;
            }
        }
        return item;
    }

    public Item() {

    }

    public Item(int itemID, String itemName, String roomNameItBelongs, boolean isTaken) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.roomNameItBelongs = roomNameItBelongs;
        this.isTaken = isTaken;
    }

    public boolean isIsTaken() {
        return isTaken;
    }

    public void setIsTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getRoomNameItBelongs() {
        return roomNameItBelongs;
    }

    public void setRoomNameItBelongs(String roomNameItBelongs) {
        this.roomNameItBelongs = roomNameItBelongs;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import CommandCheking.DoCommand;
import java.io.Serializable;
import java.util.List;

public class Inventory implements Serializable {

    String user;
    String item;

    public static int possisionOfItemInInvertory = -1;

    public String[] returnAllItemsFromUser(List<Inventory> inventoryList, String User) {

        int count = 0;
        int i = 0;

        for (i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).getUser().equals(User)) {
                count = count + 1;
            }
        }

        String[] items = new String[count];
        int counterForItems = 0;
        for (i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).getUser().equals(User)) {
                items[counterForItems] = inventoryList.get(i).getItem();
                counterForItems++;
            }
        }
        return items;
    }

    public List deleteItemFromUser(List<Inventory> inventoryList, Inventory item) {
        int i = 0;
        for (i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).getUser().equals(item.getUser()) && inventoryList.get(i).getItem().equals(item.getItem())) {
                inventoryList.remove(item);
            }
        }
        return inventoryList;
    }

    public String returnUserFromItem(List<Inventory> inventoryList, String item) {
        String user = null;
        int i = 0;
        for (i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).getUser().equals(item)) {
                user = inventoryList.get(i).getUser();
            }
        }
        return user;
    }

    public Boolean CheckIfiIsInInvertory(List<Inventory> listWithInvertory, String neededItem) {
        Boolean iHaveNeededItem = false;             
        for (int i = 0; i < listWithInvertory.size(); i++) {
            if (listWithInvertory.get(i).getItem().equals(neededItem)) {
                iHaveNeededItem = true;
                possisionOfItemInInvertory = i;
                break;
            }
        }
        return iHaveNeededItem;
    }

    public Inventory() {
    }

    public Inventory(String user, String item) {
        this.user = user;
        this.item = item;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}

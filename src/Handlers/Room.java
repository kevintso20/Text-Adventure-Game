/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Objects.Order;
import Handlers.Item;
import java.util.List;

/**
 *
 * @author Joyce
 */
public class Room {
    
    int roomID;
    String roomName;
    String itemNamesItContains;
    
     public List deleteRoom(List<Room> list, Room room) {
        int i = 0;
        for (i = 0; i < list.size(); i++) {
            if (String.valueOf(list.get(i).getRoomID()).equals(String.valueOf(room.getRoomID()))) {
                list.remove(i);
            }
        }
        return list;
    }
     public List editRoom(List<Room> list, Room room) {
        int i = 0;
        for (i = 0; i < list.size(); i++) {
            if (String.valueOf(list.get(i).getRoomID()).equals(String.valueOf(room.getRoomID()))) {
                list.set(i, room);
            }
        }
        return list;

    }

    public Room returnRoomID(List<Room> list, int id) {
        Room returningRoom = new Room();
        int i = 0;
        for (i = 0; i < list.size(); i++) {
            if (String.valueOf(list.get(i).getRoomID()).equals(String.valueOf(id))) {
                returningRoom.setRoomID(list.get(i).getRoomID());
                returningRoom.setRoomName(list.get(i).getRoomName());
                returningRoom.setItemNamesItContains(list.get(i).getItemNamesItContains());
            }
        }
        return returningRoom;

    }

    public Room returnRoomWithString(List<Room> list, String name) {
        Room returningRoom = new Room();
        int i = 0;
        for (i = 0; i < list.size(); i++) {
            if (String.valueOf(list.get(i).getRoomName()).equals(String.valueOf(name))) {
                returningRoom.setRoomID(list.get(i).getRoomID());
                returningRoom.setRoomName(list.get(i).getRoomName());
                returningRoom.setItemNamesItContains(list.get(i).getItemNamesItContains());
            }
        }
        return returningRoom;

    }

    public List getRoomsFromOrder(List<Order> listWithOrders, List<Room> listWithRooms, List<Item> listWithItems, boolean iWantToCallIt) {

        if (iWantToCallIt == true) {
            int count = -100;
            int counterForRooms = listWithOrders.size();
            String[] roomsRepeted = new String[counterForRooms];

            for (int i = 0; i < listWithOrders.size(); i++) {
                roomsRepeted[i] = listWithOrders.get(i).getRoomName();
            }

            for (String roomsRepeted1 : roomsRepeted) {
                count = 0;
                String foundTheRoom = roomsRepeted1;
                for (int j = 0; j < roomsRepeted.length; j++) {
                    if (foundTheRoom.equals(roomsRepeted[j])) {
                        count++;
                    }

                    if (count == 2) {
                        roomsRepeted[j] = "";
                        count = 0;
                    }
                }
            }

            count = 0;
            for (String roomsRepeted1 : roomsRepeted) {
                if (!"".equals(roomsRepeted1)) {
                    count++;
                }
            }

            String[] rooms = new String[count];
            int roomsCount = 0;
            for (String roomsRepeted1 : roomsRepeted) {
                if (!"".equals(roomsRepeted1)) {
                    rooms[roomsCount] = roomsRepeted1;
                    roomsCount++;
                }
            }

            int counterForIdRooms = 0;
            for (String room1 : rooms) {
                boolean isRoomInListWithItems = false;
                for (int j = 0; j < listWithItems.size(); j++) {
                    if (listWithItems.get(j).getRoomNameItBelongs().equals(room1)) {
                        Room room = new Room();
                        room.setRoomID(counterForIdRooms);
                        room.setItemNamesItContains(listWithItems.get(j).getItemName());
                        room.setRoomName(listWithItems.get(j).getRoomNameItBelongs());
                        listWithRooms.add(room);
                        counterForIdRooms++;
                        room = null;
                        isRoomInListWithItems = true;
                    }
                }
                if (isRoomInListWithItems == false) {
                    Room room = new Room();
                    room.setRoomID(counterForIdRooms);
                    room.setRoomName(room1);
                    room.setItemNamesItContains("");
                    listWithRooms.add(room);
                    counterForIdRooms++;
                    room = null;
                }
            }
        }
        return listWithRooms;
    }
    
    public Room(int roomID, String roomName, String itemNamesItContains) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.itemNamesItContains = itemNamesItContains;
    }

    public Room() {
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getItemNamesItContains() {
        return itemNamesItContains;
    }

    public void setItemNamesItContains(String itemNamesItContains) {
        this.itemNamesItContains = itemNamesItContains;
    }
}

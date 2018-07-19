package Storys;

import Objects.Order;
import java.util.List;

public class InheritanceCommands {

    public static String[] rooms;
    public static String[][] connectRoomsSubRooms;

    public List insert(List<Order> listWithOrders) {

        String[] subrooms = subrooms(listWithOrders, rooms);
        String[] cutedSubRooms = deleteGarbagesFromString(subrooms);
        String[] arraysCombined = addArrayStrings(cutedSubRooms, rooms);

        String[] subRoomsTimeTwo = subrooms(listWithOrders, arraysCombined);
        String[] cutedSubRoomsTimeTwo = deleteGarbagesFromString(subRoomsTimeTwo);
        String[] arraysCombinedTimeTwo = addArrayStrings(cutedSubRoomsTimeTwo, cutedSubRooms);

        String[] nullrooms = nullNotRooms(listWithOrders, arraysCombinedTimeTwo);
        String[] finalSubRooms = deleteGarbagesFromString(nullrooms);

        connectRoomsSubRooms = findSubRoomsInRooms(listWithOrders, rooms);
        listWithOrders = transferAbilitysInSubRooms(listWithOrders, connectRoomsSubRooms);

        String[] secondLevelRooms = findSecondLevelSubRooms(cutedSubRoomsTimeTwo, finalSubRooms);
        String[][] connectRoomsSubRoomsLevel2 = findPapaSecondLevelSubRooms(listWithOrders, secondLevelRooms);

        listWithOrders = transferAbilitysInSubRooms(listWithOrders, connectRoomsSubRoomsLevel2);

        return listWithOrders;
    }

    private String[] findSecondLevelSubRooms(String[] cutedSubRoomsTimeTwo, String[] finalSubRooms) {
        String[] subRooms = new String[500];
        int count = 0;
        for (String finalSubRoom : finalSubRooms) {
            for (String cutedSubRoomsTimeTwo1 : cutedSubRoomsTimeTwo) {
                if (cutedSubRoomsTimeTwo1.equals(finalSubRoom)) {
                    subRooms[count] = cutedSubRoomsTimeTwo1;
                    count++;
                }
            }
        }
        String[] subRoomsCuted = deleteGarbagesFromString(subRooms);

        return subRoomsCuted;
    }

    private String[][] findPapaSecondLevelSubRooms(List<Order> listWithOrders, String[] secondLevelRooms) {
        String[] SubRooms = new String[500];
        String[] SubRoomsDeeper = new String[500];
        boolean isLvl2 = false;
        int count = 0;
        for (int i = 0; i < listWithOrders.size(); i++) {
            isLvl2 = false;
            for (String secondLevelRoom : secondLevelRooms) {
                if (listWithOrders.get(i).getToDoAfterCorrectOrder().equals(secondLevelRoom)) {
                    isLvl2 = true;
                }
            }
            if (isLvl2) {
                SubRooms[count] = listWithOrders.get(i).getRoomName();
                SubRoomsDeeper[count] = listWithOrders.get(i).getToDoAfterCorrectOrder();
                count++;
            }
        }
        String[] SubRoomsCuted = deleteGarbagesFromString(SubRooms);
        String[] SubRoomsDeeperCuted = deleteGarbagesFromString(SubRoomsDeeper);

        String[][] connectRoomsSubRoomsLevel2 = new String[count][2];
        for (int i = 0; i < count; i++) {
            connectRoomsSubRoomsLevel2[i][0] = SubRoomsCuted[i];
            connectRoomsSubRoomsLevel2[i][1] = SubRoomsDeeperCuted[i];
        }
        return connectRoomsSubRoomsLevel2;
    }

    private List transferAbilitysInSubRooms(List<Order> listWithOrders, String[][] connectRoomsSubRooms) {
        boolean transferAbilitys = false;
        for (int k = 0; k < listWithOrders.size(); k++) {
            for (String[] connectRoomsSubRoom : connectRoomsSubRooms) {
                if (listWithOrders.get(k).getRoomName().equals(connectRoomsSubRoom[0])) {
                    if (!listWithOrders.get(k).getToDoAfterCorrectOrder().equals(connectRoomsSubRoom[1])) {
                        Order order = new Order();
                        order.setVerb(listWithOrders.get(k).getVerb());
                        order.setNoun(listWithOrders.get(k).getNoun());
                        order.setRoomName(connectRoomsSubRoom[1]);
                        order.setSideInRoom(listWithOrders.get(k).getSideInRoom());
                        order.setInventoryItem(listWithOrders.get(k).getInventoryItem());
                        order.setCorrectOrderText(listWithOrders.get(k).getCorrectOrderText());
                        order.setWrongOrderText(listWithOrders.get(k).getWrongOrderText());
                        order.setToDoAfterCorrectOrder(listWithOrders.get(k).getToDoAfterCorrectOrder());
                        order.setAffectsInventory(listWithOrders.get(k).getAffectsInventory());
                        order.setCanBeAppliedEverywhere(listWithOrders.get(k).getCanBeAppliedEverywhere());
                        listWithOrders.add(order);
                        order = null;
                    }
                }
            }
        }

        return listWithOrders;
    }

    private String[][] findSubRoomsInRooms(List<Order> listWithOrders, String[] rooms) {
        String[] roomsExtended = new String[500];
        String[] subRoomsExtended = new String[500];
        int count = 0;
        boolean isRoom = false;
        for (int i = 0; i < listWithOrders.size(); i++) {
            for (String room : rooms) {
                if (listWithOrders.get(i).getRoomName().equals(room)) {
                    if (!listWithOrders.get(i).getRoomName().equals(listWithOrders.get(i).getToDoAfterCorrectOrder())) {
                        if (!listWithOrders.get(i).getAffectsInventory().equals("import")) {
                            isRoom = false;
                            for (String room1 : rooms) {
                                if (listWithOrders.get(i).getToDoAfterCorrectOrder().equals(room1)) {
                                    isRoom = true;
                                }
                            }
                            for (String itemsCanHunt : MainStory.itemsCanHunt) {
                                if (listWithOrders.get(i).getToDoAfterCorrectOrder().equals(itemsCanHunt)) {
                                    isRoom = true;
                                }
                            }

                            if (isRoom == false) {
                                roomsExtended[count] = listWithOrders.get(i).getRoomName();
                                subRoomsExtended[count] = listWithOrders.get(i).getToDoAfterCorrectOrder();
                                count++;
                            }
                        }
                    }
                }
            }
        }
        String[][] connectRoomsSubRooms = new String[count][2];
        for (int i = 0; i < count; i++) {
            connectRoomsSubRooms[i][0] = roomsExtended[i];
            connectRoomsSubRooms[i][1] = subRoomsExtended[i];
        }
        return connectRoomsSubRooms;
    }

    private String[] nullNotRooms(List<Order> listWithOrders, String[] arrayString) {
        boolean isRoom = false;
        for (int j = 0; j < arrayString.length; j++) {
            isRoom = false;
            for (int i = 0; i < listWithOrders.size(); i++) {
                if (listWithOrders.get(i).getRoomName().equals(arrayString[j])) {
                    isRoom = true;
                }
            }
            if (isRoom == false) {
                arrayString[j] = null;
            }
        }

        return arrayString;
    }

    private String[] addArrayStrings(String[] arrayOne, String[] arrayTwo) {

        String[] arraysCombined = new String[arrayOne.length + arrayTwo.length];

        int count = 0;

        for (String arrayOne1 : arrayOne) {
            arraysCombined[count] = arrayOne1;
            count++;
        }

        for (String arrayTwo1 : arrayTwo) {
            arraysCombined[count] = arrayTwo1;
            count++;
        }
        return arraysCombined;

    }

    public String[] deleteGarbagesFromString(String[] arrayString) {
        int count = 0;
        for (String arrayString1 : arrayString) {
            if (arrayString1 != null) {
                count++;
            }
        }

        String[] pureString = new String[count];
        count = 0;
        for (String arrayString1 : arrayString) {
            if (arrayString1 == null) {
            } else {
                pureString[count] = arrayString1;
                count++;
            }
        }

        return pureString;

    }

    private String[] subrooms(List<Order> listWithOrders, String[] rooms) {
        String[] subRooms = new String[500];
        int count = 0;
        boolean isSubRoom = false;
        for (int i = 0; i < listWithOrders.size(); i++) {
            for (String room : rooms) {
                if (listWithOrders.get(i).getRoomName().equals(room)) {
                    if (!listWithOrders.get(i).getRoomName().equals(listWithOrders.get(i).getToDoAfterCorrectOrder())) {
                        isSubRoom = false;
                        for (String room1 : rooms) {
                            if (listWithOrders.get(i).getToDoAfterCorrectOrder().equals(room1)) {
                                isSubRoom = true;
                                break;
                            }
                        }
                        if (isSubRoom == false) {
                            subRooms[count] = listWithOrders.get(i).getToDoAfterCorrectOrder();
                            count++;
                        }
                    }
                }
            }
        }
        return subRooms;
    }

    public static String[][] getConnectRoomsSubRooms() {
        return connectRoomsSubRooms;
    }
}

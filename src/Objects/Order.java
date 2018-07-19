package Objects;

public class Order {

    String verb;
    String noun;
    String roomName;
    String sideInRoom;
    String inventoryItem;
    String wrongOrderText;
    String correctOrderText;
    String toDoAfterCorrectOrder;
    String AffectsInventory; 
    String CanBeAppliedEverywhere;

    public Order() {
    }

    public Order(String verb, String noun, String roomName, String sideInRoom, String inventoryItem, String wrongOrderText, String correctOrderText, String toDoAfterCorrectOrder, String AffectsInventory, String CanBeAppliedEverywhere) {
        this.verb = verb;
        this.noun = noun;
        this.roomName = roomName;
        this.sideInRoom = sideInRoom;
        this.inventoryItem = inventoryItem;
        this.wrongOrderText = wrongOrderText;
        this.correctOrderText = correctOrderText;
        this.toDoAfterCorrectOrder = toDoAfterCorrectOrder;
        this.AffectsInventory = AffectsInventory;
        this.CanBeAppliedEverywhere = CanBeAppliedEverywhere;
    }
       
    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getNoun() {
        return noun;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getSideInRoom() {
        return sideInRoom;
    }

    public void setSideInRoom(String sideInRoom) {
        this.sideInRoom = sideInRoom;
    }

    public String getCorrectOrderText() {
        return correctOrderText;
    }

    public void setCorrectOrderText(String correctOrderText) {
        this.correctOrderText = correctOrderText;
    }

    public String getWrongOrderText() {
        return wrongOrderText;
    }

    public void setWrongOrderText(String wrongOrderText) {
        this.wrongOrderText = wrongOrderText;
    }

    public String getToDoAfterCorrectOrder() {
        return toDoAfterCorrectOrder;
    }

    public void setToDoAfterCorrectOrder(String toDoAfterCorrectOrder) {
        this.toDoAfterCorrectOrder = toDoAfterCorrectOrder;
    }

    public String getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(String inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    public String getAffectsInventory() {
        return AffectsInventory;
    }

    public void setAffectsInventory(String SetAffectsInventory) {
        this.AffectsInventory = SetAffectsInventory;
    }

    public String getCanBeAppliedEverywhere() {
        return CanBeAppliedEverywhere;
    }

    public void setCanBeAppliedEverywhere(String CanBeAppliedEverywhere) {
        this.CanBeAppliedEverywhere = CanBeAppliedEverywhere;
    }

    
    
}

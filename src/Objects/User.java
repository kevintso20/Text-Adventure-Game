package Objects;

public class User {

    String userName;
    String roomYouAre;
    String possisionInRoom;
    int currentHp;

    public User() {
    }

    public User(String userName, String roomYouAre, String possisionInRoom, int currentHp) {
        this.userName = userName;
        this.roomYouAre = roomYouAre;
        this.possisionInRoom = possisionInRoom;
        this.currentHp = currentHp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoomYouAre() {
        return roomYouAre;
    }

    public void setRoomYouAre(String roomYouAre) {
        this.roomYouAre = roomYouAre;
    }

    public String getPossisionInRoom() {
        return possisionInRoom;
    }

    public void setPossisionInRoom(String possisionInRoom) {
        this.possisionInRoom = possisionInRoom;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }
    

}

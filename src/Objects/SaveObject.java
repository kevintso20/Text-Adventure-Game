package Objects;

import java.io.Serializable;
import java.util.List;

public class SaveObject implements Serializable {

    String userName;
    String roomYouAre;
    String possisionInRoom;
    int countRounds;
    int currentHealth;
    int secondsPassed;
    int piceOfDay;
    boolean stillFighting;
    boolean isStillInGodMode;
    boolean isDayNow;
    String[] items;

    public SaveObject() {
    }

    public SaveObject(String userName, String roomYouAre, String possisionInRoom, int countRounds, int currentHealth, int secondsPassed, int piceOfDay, boolean stillFighting, boolean isStillInGodMode, Boolean isDayNow, String[] items) {
        this.userName = userName;
        this.roomYouAre = roomYouAre;
        this.possisionInRoom = possisionInRoom;
        this.countRounds = countRounds;
        this.currentHealth = currentHealth;
        this.secondsPassed = secondsPassed;
        this.piceOfDay = piceOfDay;
        this.stillFighting = stillFighting;
        this.isStillInGodMode = isStillInGodMode;
        this.isDayNow = isDayNow;
        this.items = items;
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

    public int getCountRounds() {
        return countRounds;
    }

    public void setCountRounds(int countRounds) {
        this.countRounds = countRounds;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getSecondsPassed() {
        return secondsPassed;
    }

    public void setSecondsPassed(int secondsPassed) {
        this.secondsPassed = secondsPassed;
    }

    public int getPiceOfDay() {
        return piceOfDay;
    }

    public void setPiceOfDay(int piceOfDay) {
        this.piceOfDay = piceOfDay;
    }

    public boolean isStillFighting() {
        return stillFighting;
    }

    public void setStillFighting(boolean stillFighting) {
        this.stillFighting = stillFighting;
    }

    public boolean isIsStillInGodMode() {
        return isStillInGodMode;
    }

    public void setIsStillInGodMode(boolean isStillInGodMode) {
        this.isStillInGodMode = isStillInGodMode;
    }

    public Boolean getIsDayNow() {
        return isDayNow;
    }

    public void setIsDayNow(Boolean isDayNow) {
        this.isDayNow = isDayNow;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

}

package Commands;

import CommandCheking.DoCommand;
import GameClasses.GodMode;
import GameClasses.Zork;
import GameClasses.Game;
import Handlers.Inventory;
import Objects.SaveObject;
import GUIControler.UpdateMethods;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Restore implements KeyOrder {

    @Override
    public String exec(String command) {
        List<Inventory> listWithInvertory = new ArrayList<>();
        UpdateMethods updateMethods = new UpdateMethods();
        GodMode godMode = new GodMode();
        String[] invertoryItems;
        String finaltext = null;

        File f = new File("Saves/" + Game.getActiveUser().getUserName() + ".txt");

        if (f.exists()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                SaveObject saveObject = (SaveObject) ois.readObject();

                Game.getActiveUser().setUserName(saveObject.getUserName());
                Game.getActiveUser().setRoomYouAre(saveObject.getRoomYouAre());
                Game.getActiveUser().setPossisionInRoom(saveObject.getPossisionInRoom());
                Game.setCountRounds(saveObject.getCountRounds());
                updateMethods.updateHealthPoints(saveObject.getCurrentHealth());
                Zork.secondsPassed = saveObject.getSecondsPassed();
                Game.piceOfDay = saveObject.getPiceOfDay();
                Game.setStillFighting(saveObject.isStillFighting());
                GodMode.isStillInGodMode = saveObject.isIsStillInGodMode();
                Game.isDayNow = saveObject.getIsDayNow();
                invertoryItems = saveObject.getItems();

                for (String invertoryItem : invertoryItems) {
                    Inventory inv = new Inventory();
                    inv.setUser(saveObject.getUserName());
                    inv.setItem(invertoryItem);
                    listWithInvertory.add(inv);
                    inv = null;
                }
                DoCommand doCommand = new DoCommand();
                doCommand.setListWithInvertory(listWithInvertory);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Restore.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Restore.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateMethods.updateFinalText("You can play now from last save");
            finaltext = "You can play now from last save";
        } else {
            updateMethods.updateFinalText("Save not found");
            finaltext = "Save not found";

        }

        return finaltext;
    }

}

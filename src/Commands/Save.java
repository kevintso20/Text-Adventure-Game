package Commands;

import CommandCheking.DoCommand;
import GUIControler.IGUI;
import GameClasses.Game;
import Objects.SaveObject;
import GUIControler.UpdateMethods;
import GameClasses.Zork;
import GameClasses.GodMode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Handlers.Inventory;
import java.util.ArrayList;
import Storys.InheritanceCommands;
// implements .IGUI

public class Save implements KeyOrder {

    //ArrayList<IGUI> igui = new ArrayList<>();
    public Save() {

        // igui = Storage.getIgui();
        //   igui.add(this);
        //  Storage.setIgui(igui);
    }

    @Override
    public String exec(String command) {
        InheritanceCommands ic = new InheritanceCommands();
        GodMode godMode = new GodMode();
           DoCommand doCommand = new DoCommand();
        List<Inventory> listWithInvertory = new ArrayList<>();
        listWithInvertory = doCommand.getListWithInvertory();
        String[] items = new String[100];

        for (int i = 0; i < listWithInvertory.size(); i++) {
            items[i] = listWithInvertory.get(i).getItem();
        }

        String[] invertoryItems = ic.deleteGarbagesFromString(items);

        SaveObject saveObject = new SaveObject();

        saveObject.setUserName(Game.getActiveUser().getUserName());
        saveObject.setRoomYouAre(Game.getActiveUser().getRoomYouAre());
        saveObject.setPossisionInRoom(Game.getActiveUser().getPossisionInRoom());
        saveObject.setCountRounds(Game.getCountRounds());
        saveObject.setCurrentHealth(Game.getActiveUser().getCurrentHp());
        saveObject.setSecondsPassed(Zork.secondsPassed);
        saveObject.setPiceOfDay(Game.piceOfDay);
        saveObject.setStillFighting(Game.isStillFighting());
        saveObject.setIsStillInGodMode(GodMode.isStillInGodMode);
        saveObject.setIsDayNow(Game.isDayNow);
        saveObject.setItems(invertoryItems);

        File f = new File("Saves/" + Game.getActiveUser().getUserName() + ".txt");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(saveObject);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Game Saved!";
    }

}

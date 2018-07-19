package GameClasses;

import CommandCheking.DoCommand;
import java.util.HashMap;
import Handlers.Item;
import Commands.BuildShip;
import Commands.Cut;
import Commands.Diagnose;
import Commands.Drop;
import Commands.Eat;
import Commands.Exit;
import Commands.FindAnimal;
import Commands.Help;
import Commands.Hunt;
import Commands.KeyOrder;
import Commands.Kill;
import Commands.KillAnimals;
import Commands.LightsOnOff;
import Commands.Pause;
import Commands.Restart;
import Commands.Restore;
import Commands.Save;
import Commands.Say;
import Commands.ShowInventory;
import Commands.Sleep;
import Commands.Undo;
import GUIControler.UpdateMethods;
import Storys.MainStory;
import java.util.List;

public class Actions {

    public void CheckIfIsKeyWord(String command) {

        HashMap<String, KeyOrder> hashMap = new HashMap<>();

        hashMap = fillHashmap(hashMap);

        if (hashMap.containsKey(command)) {
            String finaltext;
            finaltext = hashMap.get(command).exec(command);
            UpdateMethods um = new UpdateMethods();
            um.updateFinalText(finaltext);
        }

    }

    private HashMap fillHashmap(HashMap<String, KeyOrder> hashMap) {

        KeyOrder exit = new Exit();
        KeyOrder help = new Help();
        KeyOrder lights = new LightsOnOff();
        KeyOrder onOff = new GodMode();
        KeyOrder pause = new Pause();
        KeyOrder drop = new Drop();
        KeyOrder restart = new Restart();
        KeyOrder save = new Save();
        KeyOrder restore = new Restore();
        KeyOrder sleep = new Sleep();
        KeyOrder hunt = new Hunt();
        KeyOrder eat = new Eat();
        KeyOrder cut = new Cut();
        KeyOrder build = new BuildShip();
        KeyOrder kill = new Kill();
        KeyOrder findAnimal = new FindAnimal();
        KeyOrder killAnimal = new KillAnimals();
        KeyOrder showInventory = new ShowInventory();
        KeyOrder say = new Say();
        KeyOrder undo = new Undo();
        KeyOrder diagnose = new Diagnose();

        hashMap.put("exit", exit);
        hashMap.put("help", help);
        hashMap.put("turn on torch", lights);
        hashMap.put("turn off torch", lights);
        hashMap.put("god mode on", onOff);
        hashMap.put("god mode off", onOff);
        hashMap.put("pause", pause);
        hashMap.put("restart", restart);
        hashMap.put("save", save);
        hashMap.put("restore", restore);
        hashMap.put("sleep", sleep);
        hashMap.put("hunt", hunt);
        hashMap.put("cut trees", cut);
        hashMap.put("build ship", build);
        hashMap.put("kill monster", kill);
        hashMap.put("find animal", findAnimal);
        hashMap.put("kill it", killAnimal);
        hashMap.put("show inventory", showInventory);
        hashMap.put("hello", say);
        hashMap.put("hi", say);
        hashMap.put("fine", say);
        hashMap.put("good", say);
        hashMap.put("how are you", say);
        hashMap.put("you", say);
        hashMap.put("thanks", say);
        hashMap.put("thank you", say);
        hashMap.put("bye", say);
        hashMap.put("goodbye", say);
        hashMap.put("undo", undo);
        hashMap.put("diagnose", diagnose);

        List<Item> listWithItems;
        DoCommand doCommand = new DoCommand();
        listWithItems = doCommand.getListWithItems();

        for (int i = 0; i < listWithItems.size(); i++) {
            hashMap.put("drop " + listWithItems.get(i).getItemName(), drop);
            hashMap.put("eat " + listWithItems.get(i).getItemName(), eat);
        }

        for (String itemsCanEat : MainStory.itemsCanEat) {
            hashMap.put("eat " + itemsCanEat, eat);
        }
       
        return hashMap;
    }

}

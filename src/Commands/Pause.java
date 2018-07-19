package Commands;

import GUIControler.UpdateMethods;
import GameClasses.Game;
import GameClasses.Zork;

public class Pause implements KeyOrder {

    public String exec(String command) {
       
        Game.setIsPause(true);
        return "game is paused";
    }

}

package Commands;

import GUIControler.UpdateMethods;
import GameClasses.GameOver;
import GameClasses.Zork;

public class Restart implements KeyOrder {

    @Override
    public String exec(String command) {

        GameOver gameOver = new GameOver();

        gameOver.gameOverState("Game Successful Restarted");
        return "Game Successful Restarted";
    }

}

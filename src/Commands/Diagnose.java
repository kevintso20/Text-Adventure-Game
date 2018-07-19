package Commands;

import GUIControler.UpdateMethods;
import GameClasses.Zork;
import GameClasses.Game;
/**
 *
 * @author Joyce
 */
public class Diagnose implements KeyOrder {

    @Override
    public String exec(String command) {
        String finaltext = " ";
            if (Game.getActiveUser().getCurrentHp() >= 50) {

                finaltext = "Your life is " + Game.getActiveUser().getCurrentHp() + " you can eat something to increase your health!";
            } else if (Game.getActiveUser().getCurrentHp() <= 20 && Game.getActiveUser().getCurrentHp() > 50) {
                finaltext = "Your life is at risk! You have " +Game.getActiveUser().getCurrentHp() + "!";
            } else {
                finaltext = "Your life is in danger.... Eat something!!! You have " + Game.getActiveUser().getCurrentHp() + " You're dying!";
            }
        
        return finaltext;
    }
}

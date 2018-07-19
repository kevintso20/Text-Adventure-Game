package Commands;

import CommandCheking.DoCommand;
import GUIControler.UpdateMethods;
import GameClasses.Game;
import Objects.Order;
import java.util.List;

public class Say implements KeyOrder {

    @Override
    public String exec(String command) {
           DoCommand doCommand = new DoCommand();
        List<Order> orderList = doCommand.getListWithOrders();
        String finaltext = "Hi";

        if (command.matches("hello") || command.matches("hi")) {
            finaltext = "Hello " + Game.getActiveUser().getUserName() + "! How are you?";

        }
        if (command.matches("fine") || command.matches("good")) {
            finaltext = "I'm glad to here you are fine! ";
        }

        if (command.matches("how are you") || command.matches("you")) {
            finaltext = "I feel lonely the most time! Finally you came here and i have someone to talk!";
        }

        if (command.matches("thanks") || command.matches("thank you")) {
            finaltext = "Your welcome!";
        }

        if (command.matches("bye") || command.matches("goodbye")) {
            finaltext = "Goodbye my friend! Good luck!";
        }

        return finaltext;

    }
}

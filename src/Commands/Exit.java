package Commands;

import GUIControler.UpdateMethods;

public class Exit implements KeyOrder {

    public String exec(String command) {
        String finaltext = "exit";
        if (command.matches("exit")) {
            finaltext = "byeeeee";
            System.exit(0);           
        }
       return finaltext;
    }  
  
}

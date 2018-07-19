package Commands;

import GUIControler.UpdateMethods;
import GameClasses.Zork;

public class Help implements KeyOrder {

    public String exec(String command) {
        String finaltext = null;
        HelpForm form = new HelpForm();
        form.setVisible(true);
        form.setDefaultCloseOperation(HelpForm.DO_NOTHING_ON_CLOSE);
        finaltext = "Watch The Form :D";
       
       return finaltext;
    }
}

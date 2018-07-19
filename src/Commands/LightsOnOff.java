package Commands;

import GUIControler.UpdateMethods;
import java.awt.Image;
import javax.swing.ImageIcon;

public class LightsOnOff implements KeyOrder {

    public static int stateOfLighter = 0;
    public static int preveusStateOfLighter = 1;

    public String[] getURLImagesOfLighter() {
        String[] imageLighter = new String[2];
        imageLighter[0] = "/Images/Lights/torchon.png";
        imageLighter[1] = "/Images/Lights/torchoff.jpg";
        return imageLighter;
    }

    public Image setTheImageOnLighter(boolean isDay) {
        String[] imageLighter = getURLImagesOfLighter();

        if (isDay == true) {
            ImageIcon SortByIcon = new ImageIcon(getClass().getResource(imageLighter[1]));
            Image image = SortByIcon.getImage().getScaledInstance(150, 150, 150);

            return image;
        } else if (isDay == false) {
            ImageIcon SortByIcon = new ImageIcon(getClass().getResource(imageLighter[0]));
            Image image = SortByIcon.getImage().getScaledInstance(150, 150, 150);

            return image;
        }

        return null;
    }

    public void changeStatusOnLighter() {
        Image image = null;

        switch (stateOfLighter) {
            case 1:
                image = setTheImageOnLighter(false);
                break;
            case 0:
                image = setTheImageOnLighter(true);
                break;
            default:
                image = setTheImageOnLighter(true);
                break;
        }
        UpdateMethods updateMethods = new UpdateMethods();
        updateMethods.updateLightsImage(image);

    }

    public String exec(String command) {
        Image image = null;
        String finaltext = null;
        if (command.equals("turn on torch")) {
            if (stateOfLighter == 0) {
                finaltext = "torch On!!!";
                stateOfLighter = 1;
            } else if (stateOfLighter == 1) {
                finaltext = "Torch its alredy on";
            }
        } else if (command.equals("turn off torch")) {
            if (stateOfLighter == 1) {
                stateOfLighter = 0;
                finaltext = "torch Off!!!";
            } else if (stateOfLighter == 0) {
                finaltext = "I Cannot Do That!!! the torch its alredy off";
            }
        }
        changeStatusOnLighter();
        return finaltext;
    }

    public Image changeStatusOnLighterByclick() {
        Image image = null;

        if (stateOfLighter == 0) {
            image = setTheImageOnLighter(false);
            stateOfLighter = 1;
        } else if (stateOfLighter == 1) {
            image = setTheImageOnLighter(true);
            stateOfLighter = 0;
        }

        return image;
    }
}

package Handlers;

import GUIControler.UpdateMethods;
import GameClasses.Game;
import java.awt.Image;
import javax.swing.ImageIcon;
import GameClasses.GodMode;

public class GodModeImage {

    private String[] getURLImagesOfGodMode() {
        String[] imageGodMode = new String[3];
        imageGodMode[0] = "/Images/GodMode/GodModeOn.png";
        imageGodMode[1] = "/Images/GodMode/GodModeOff.png";
        imageGodMode[2] = "/Images/GodMode/GodModeOnNight.png";
        return imageGodMode;
    }

    public Image setTheImageOnGodMode() {
        String[] imageGodMode = getURLImagesOfGodMode();
        GodMode godMode = new GodMode();
        UpdateMethods updateMethods = new UpdateMethods();

        if (GodMode.isStillInGodMode == true) {
            if (Game.getIsDayNow() == true) {
                ImageIcon SortByIcon = new ImageIcon(getClass().getResource(imageGodMode[0]));
                Image image = SortByIcon.getImage().getScaledInstance(150, 150, 150);
                updateMethods.updateGodModeImage(image);
                return image;
            } else if (Game.getIsDayNow() == false) {
                ImageIcon SortByIcon = new ImageIcon(getClass().getResource(imageGodMode[2]));
                Image image = SortByIcon.getImage().getScaledInstance(150, 150, 150);
                updateMethods.updateGodModeImage(image);
                return image;
            }

        } else if (GodMode.isStillInGodMode == false) {
            ImageIcon SortByIcon = new ImageIcon(getClass().getResource(imageGodMode[1]));
            Image image = SortByIcon.getImage().getScaledInstance(150, 150, 150);
            updateMethods.updateGodModeImage(image);
            return image;
        }

        return null;
    }

}

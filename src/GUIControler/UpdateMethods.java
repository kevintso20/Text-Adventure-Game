package GUIControler;

import Handlers.GodModeImage;
import Handlers.TimeOfDayImage;
import Commands.LightsOnOff;
import java.awt.Image;
import java.util.ArrayList;

public class UpdateMethods {

    private static ArrayList<IGUI> igui = new ArrayList<>();

    public void updateFinalText(String message) {
        TimeOfDayImage imageHundlerTimeOfDay = new TimeOfDayImage();
        for (IGUI iguii : igui) {
            iguii.ReceivedFinalText(message);
            iguii.ReceivedTimeOfDayImage(imageHundlerTimeOfDay.setTheImageDayOrNight());
        }
    }

    public void updateHealthPoints(int amtHealth) {
        String health = String.valueOf(amtHealth);
        for (IGUI iguii : igui) {
            iguii.ReceivedHealthPoints(health);
        }
    }

    public void updateGodModeImage(Image image) {
        for (IGUI iguii : igui) {
            iguii.ReceivedGodModeImage(image);
        }
    }

    public void updateLightsImage(Image image) {
        for (IGUI iguii : igui) {
            iguii.ReceivedLightsImage(image);
        }
    }

    public void updateMonsterMove(String health) {
        for (IGUI iguii : igui) {
            iguii.ReceivedMonsterNextMove(health);
        }

    }

    public void updateMoves(int amtMoves) {
        String moves = String.valueOf(amtMoves);

        for (IGUI iguii : igui) {
            iguii.ReceivedMoves(moves);
        }
    }

    public void updateMonsterGif(Image image) {
        for (IGUI iguii : igui) {
            iguii.ReceivedMonsterGif(image);
        }
    }

    public void updateTimer(String time) {
        for (IGUI iguii : igui) {
            iguii.ReceivedTimerOfGame(time);
        }
    }

    public void updateTimeOfDayImage(Image image) {
        for (IGUI iguii : igui) {
            iguii.ReceivedTimeOfDayImage(image);
        }
    }

    public void InitialState(String text) {
        GodModeImage imageHundlerForGodMode = new GodModeImage();
        TimeOfDayImage imageHundlerTimeOfDay = new TimeOfDayImage();
        LightsOnOff imagesHundlerLighter = new LightsOnOff();
        for (IGUI iguii : igui) {
            iguii.ReceivedFinalText(text);
            iguii.ReceivedHealthPoints("100");
            iguii.ReceivedMonsterNextMove("");
            iguii.ReceivedMoves("0");
            iguii.ReceivedGodModeImage(imageHundlerForGodMode.setTheImageOnGodMode());
            iguii.ReceivedLightsImage(imagesHundlerLighter.setTheImageOnLighter(true));
            iguii.ReceivedTimeOfDayImage(imageHundlerTimeOfDay.spesificImageDayOrNight(0));
        }

    }

    public static ArrayList<IGUI> getIgui() {
        return igui;
    }

    public static void setIgui(ArrayList<IGUI> igui) {
        UpdateMethods.igui = igui;
    }

}

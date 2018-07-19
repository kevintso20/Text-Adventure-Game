package Handlers;

import GameClasses.Game;
import java.awt.Image;
import javax.swing.ImageIcon;


public class TimeOfDayImage {

    private static int previusPhoto = 0;

    public Image setTheImageDayOrNight() {

        String[] imagesDayOrNight = getURLImagesOfDayNight();

        ImageIcon SortByIcon = new ImageIcon(getClass().getResource(imagesDayOrNight[selectPossOfImage(imagesDayOrNight)]));
        Image image = SortByIcon.getImage().getScaledInstance(150, 150, 150);

        return image;

    }

    private int selectPossOfImage(String[] imagesDayOrNight) {
        boolean flag = false;
        int day = Game.getHowPicesIsDay() / 4;
        int night = Game.getHowPicesIsDay() / 3;

        Integer[] arrayDay = new Integer[5];
        Integer[] arrayNight = new Integer[4];

        for (int i = 0; i <= 4; i++) {
            arrayDay[i] = (day + 1) * i;
        }

        for (int i = 0; i <= 3; i++) {
            arrayNight[i] = night * i + Game.getHowPicesIsDay();
        }

        if (Game.getPiceOfDay() < Game.getHowPicesIsDay()) {
            for (int i = 0; i < arrayDay.length; i++) {
                if (Game.getPiceOfDay() == arrayDay[i]) {
                    flag = true;
                    previusPhoto = i;
                    return i;
                }
            }
        }

        if (Game.getPiceOfDay() >= Game.getHowPicesIsDay()) {
            for (int i = 4; i < arrayNight.length + 3; i++) {
                if (Game.getPiceOfDay() == arrayNight[i - 4]) {
                    flag = true;
                    previusPhoto = i;
                    return i;
                }
            }
        }

        if (flag == false) {
            return previusPhoto;
        }
        return -1;
    }

    private String[] getURLImagesOfDayNight() {
        String[] imagesDayOrNight = new String[7];
        imagesDayOrNight[0] = "/Images/DayOrNight/11AM.jpg";
        imagesDayOrNight[1] = "/Images/DayOrNight/1PM.jpg";
        imagesDayOrNight[2] = "/Images/DayOrNight/3PM.jpg";
        imagesDayOrNight[3] = "/Images/DayOrNight/7PM.jpg";
        imagesDayOrNight[4] = "/Images/DayOrNight/1AM.jpg";
        imagesDayOrNight[5] = "/Images/DayOrNight/3AM.jpg";
        imagesDayOrNight[6] = "/Images/DayOrNight/7AM.jpg";

        return imagesDayOrNight;

    }

    public Image spesificImageDayOrNight(int possision) {

        String[] imagesDayOrNight = getURLImagesOfDayNight();

        ImageIcon SortByIcon = new ImageIcon(getClass().getResource(imagesDayOrNight[possision]));
        Image image = SortByIcon.getImage().getScaledInstance(150, 150, 150);
        return image;
    }
}

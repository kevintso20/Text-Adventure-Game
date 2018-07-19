package GUIControler;

import java.awt.Image;

public interface IGUI {

    void ReceivedFinalText(String finalText);
    void ReceivedHealthPoints(String amtHealth);
    void ReceivedMonsterNextMove(String move);
    void ReceivedMoves(String moves);
    void ReceivedGodModeImage(Image image);
    void ReceivedLightsImage(Image image);
    void ReceivedTimeOfDayImage(Image image);
    void ReceivedMonsterGif(Image image);
    void ReceivedTimerOfGame(String time);
    
}

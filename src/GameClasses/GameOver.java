package GameClasses;

import CommandCheking.DoCommand;
import GUIControler.UpdateMethods;
import Commands.LightsOnOff;
import Handlers.Inventory;
import static MonsterFight.AfterHiting.story;
import java.util.ArrayList;
import java.util.List;


public class GameOver {

    public void gameOverState(String finalText) {
        List<Inventory> listWithInvertory = new ArrayList<>();
        StartingForm sf = new StartingForm();
        UpdateMethods updateMethods = new UpdateMethods();
        DoCommand doCommand = new DoCommand();

        listWithInvertory = doCommand.getListWithInvertory();
        listWithInvertory.clear();
        Inventory inv3 = new Inventory(Game.getActiveUser().getUserName(), "");
        listWithInvertory.add(inv3);
        DoCommand.setListWithInvertory(listWithInvertory);

        if (story.equals("aloneinforest")) {
            Game.getActiveUser().setRoomYouAre("forest");
        } else if (story.equals("homeversion")) {
            Game.getActiveUser().setRoomYouAre("kitchen");
        }

        switch (StartingForm.getGrupDifficulity().getSelection().getActionCommand()) {
            case "easy":
                sf.easy();
                break;
            case "medium":
                sf.midium();
                break;
            case "hard":
                sf.hard();
                break;
            default:
                break;
        }

        Game.setPiceOfDay(0);
        Game.setCountRounds(0);
        LightsOnOff.stateOfLighter = 0;
        updateMethods.InitialState(finalText);
        Game.setStillFighting(false);

        updateMethods.updateMonsterMove(" ");

    }

}

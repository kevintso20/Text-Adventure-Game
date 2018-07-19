package MonsterFight;

import GUIControler.UpdateMethods;
import GameClasses.Game;
import Objects.OrderToMonster;
import java.util.ArrayList;
import java.util.List;
import GameClasses.GodMode;
import GameClasses.Zork;
import Storys.Fight;

public class FightMonster {

    public static List<OrderToMonster> listWithOrderToMonster = new ArrayList<>();
    private static String previuesMove = "";
    private static String timesSeeTheMonser = "0";
    private static int preveusMoveDecreaseHealth;
    private static boolean iWantToCallit = true;

    public void Fight(String[] orders) {
        UpdateMethods updateMethods = new UpdateMethods();
        AfterHiting afterHiting = new AfterHiting();
        GodMode godMode = new GodMode();
        Fight fightFile = new Fight();

        listWithOrderToMonster = fightFile.makeFight(listWithOrderToMonster, iWantToCallit);
        godMode.gotoGodModeEvenIfHeFight(orders);
        iWantToCallit = false;
        Game.setStillFighting(true);

        if (GodMode.isStillInGodMode == true) {
            godMode.GodMode(orders);
        } else if (GodMode.isStillInGodMode == false) {

            int preveusHealthPoints = Game.getActiveUser().getCurrentHp();

            boolean dodgeIt;

            if (timesSeeTheMonser.matches("0")) {
                int random = (int) (Math.random() * listWithOrderToMonster.size() + 0);
                updateMethods.updateFinalText("Ohhh There is A monster!!!You Need To Fight For Your Life!!!");
                updateMethods.updateMonsterMove(listWithOrderToMonster.get(random).getMove());

                previuesMove = listWithOrderToMonster.get(random).getMove();
                preveusMoveDecreaseHealth = listWithOrderToMonster.get(random).getHealthDecrease();
                timesSeeTheMonser = "1";

            } else if (timesSeeTheMonser.matches("1")) {
                int random = (int) (Math.random() * listWithOrderToMonster.size() + 0);

                dodgeIt = afterHiting.heDodgeIt(orders);
                afterHiting.fillTheObjectIfDodgeItOrNo(dodgeIt, preveusHealthPoints, random);

                previuesMove = listWithOrderToMonster.get(random).getMove();
                preveusMoveDecreaseHealth = listWithOrderToMonster.get(random).getHealthDecrease();
            }
        }
        afterHiting.endAttackFromMonsterHits();
    }

    public static String getPreviuesMove() {
        return previuesMove;
    }

    public static void setPreviuesMove(String previuesMove) {
        FightMonster.previuesMove = previuesMove;
    }

    public static String getTimesSeeTheMonser() {
        return timesSeeTheMonser;
    }

    public static void setTimesSeeTheMonser(String timesSeeTheMonser) {
        FightMonster.timesSeeTheMonser = timesSeeTheMonser;
    }

    public static int getPreveusMoveDecreaseHealth() {
        return preveusMoveDecreaseHealth;
    }

    public static void setPreveusMoveDecreaseHealth(int preveusMoveDecreaseHealth) {
        FightMonster.preveusMoveDecreaseHealth = preveusMoveDecreaseHealth;
    }

    
}

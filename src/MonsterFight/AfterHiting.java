package MonsterFight;


import GUIControler.UpdateMethods;
import GameClasses.Zork;
import GameClasses.Game;
import GameClasses.GameOver;

public class AfterHiting {

    private static int monsterStrikes = 0;
    private static final int STRIKESIWANT = 3;
    public static String story = "";
    UpdateMethods updateMethods = new UpdateMethods();
 
    private void setStatsToZero() {
        GameOver gameOver = new GameOver();
        Game.setStillFighting(false);
        updateMethods.updateMonsterMove("");
        gameOver.gameOverState("you die from monster");
    }

    public void fillTheObjectIfDodgeItOrNo(boolean dodgeIt, int preveusHealthPoints, int random) {
        int currentHealthPoints = 0;

        if (dodgeIt == true) {
            updateMethods.updateFinalText("You Dodge it");
            updateMethods.updateHealthPoints(Game.getActiveUser().getCurrentHp());
            Game.setStillFighting(true);
            updateMethods.updateMonsterMove(FightMonster.listWithOrderToMonster.get(random).getMove());
        } else {
            currentHealthPoints = Game.getActiveUser().getCurrentHp() - FightMonster.getPreveusMoveDecreaseHealth();
            if (currentHealthPoints < 1) {
                setStatsToZero();
            } else {
                updateMethods.updateFinalText("Come On Dude Do Something You Are Getting Hurt!!!");
                updateMethods.updateHealthPoints(currentHealthPoints);
                Game.setStillFighting(true);
                updateMethods.updateMonsterMove(FightMonster.listWithOrderToMonster.get(random).getMove());
            }
        }
    }

    public boolean heDodgeIt(String[] orders) {
        boolean dodgeIt = false;
        String comand = fusionVerbAndNoun(orders);
        for (int i = 0; i < FightMonster.listWithOrderToMonster.size(); i++) {
            if (comand.equals(FightMonster.listWithOrderToMonster.get(i).getOrder()) && FightMonster.getPreviuesMove().equals(FightMonster.listWithOrderToMonster.get(i).getMove())) {
                dodgeIt = true;
            }
        }
        return dodgeIt;
    }

    public void endAttackFromMonsterHits() {
        monsterStrikes++;
        if (monsterStrikes > STRIKESIWANT && Game.isStillFighting() == true) {
            Game.setStillFighting(false);
            updateMethods.updateFinalText("keep playning!!!");
            updateMethods.updateMonsterMove("Monster Run Away");
            monsterStrikes = 0;
            FightMonster.setTimesSeeTheMonser("0");
        }
    }

    private String fusionVerbAndNoun(String[] orders) {
        String comand = " is null";
        switch (orders.length) {
            case 1:
                comand = orders[0];
                break;
            case 2:
                comand = orders[0] + " " + orders[1];
                break;
            case 3:
                comand = orders[0] + " " + orders[1] + " " + orders[2];
                break;
            default:
                break;
        }

        return comand;
    }

    public static int getMonsterStrikes() {
        return monsterStrikes;
    }

    public static void setMonsterStrikes(int monsterStrikes) {
        AfterHiting.monsterStrikes = monsterStrikes;
    }
}

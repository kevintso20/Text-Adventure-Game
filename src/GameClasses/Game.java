package GameClasses;

import CommandCheking.DoCommand;
import Commands.LightsOnOff;
import GUIControler.UpdateMethods;
import MonsterFight.FightMonster;
import MonsterFight.MonsterOthers;
import Objects.User;

public class Game {

    private static User activeUser = new User("name", "place", "possision",100);
    private static int maximumMoves = 150;
    private static int countRounds = 0;
    private static boolean isPause = false;
    private static int HowPicesIsDay;
    public static Boolean isDayNow = true;
    public static int piceOfDay = 0;
    private static boolean canKillMonster = false;
    private static boolean stillFighting = false;

    Actions keyWordsOrders = new Actions();

    public void choiceTheState(String command) {
        GameOver gameOver = new GameOver();
        UpdateMethods updateMethods = new UpdateMethods();
        if (hasReachedMaximumMoves()) {
            piceOfDay++;
            if (isDay()) {
                MonsterOthers.PERSENTAGEMONSTERAPEARS = 100;
                if (isCorrectTheStatusOfTorch()) {
                    State(command);
                }
            } else if (!isDay()) {
                MonsterOthers.PERSENTAGEMONSTERAPEARS = 9;
                if (isCorrectTheStatusOfTorch()) {
                    State(command);
                }
            }
        } else {
            gameOver.gameOverState("Game Over You Did More Than " + Game.getCountRounds() + "Moves");
        }

        keyWordsOrders.CheckIfIsKeyWord(command);
        setCountRounds(getCountRounds() + 1);
        setIsPause(false);
        updateMethods.updateMoves(getCountRounds());
    }

    private void State(String command) {
        MonsterOthers findOrDodgeFunctions = new MonsterOthers();
        FightMonster fightMonster = new FightMonster();
        GodMode godMode = new GodMode();
        boolean findMonster = findOrDodgeFunctions.randomFindMonster();
        if (GodMode.isStillInGodMode == true) {
            godMode.GodMode(command.split(" "));
        } else if (findMonster == true || stillFighting == true) {
            fightMonster.Fight(command.split(" "));
            findMonster = false;
        } else {
            DoCommand doCommand = new DoCommand();
            doCommand.findTheCommand(command.split(" "));
            stillFighting = false;
        }
    }

    public boolean isCorrectTheStatusOfTorch() {
        UpdateMethods updateMethods = new UpdateMethods();
        if (isDayNow == true) {
            if (LightsOnOff.stateOfLighter == 1 && GodMode.isStillInGodMode == false) {
                updateMethods.updateFinalText("Turn Off The Torch!!!");
                updateMethods.updateHealthPoints(getActiveUser().getCurrentHp());
                return false;
            } else {
                return true;
            }
        } else {
            if (LightsOnOff.stateOfLighter == 0 && GodMode.isStillInGodMode == false) {
                updateMethods.updateFinalText("You Cant See Trun On Torch!!!");
                updateMethods.updateHealthPoints(getActiveUser().getCurrentHp());
                return false;
            } else {
                return true;
            }
        }
    }

    public boolean isDay() {
        if (piceOfDay <= HowPicesIsDay) {
            isDayNow = true;
            return true;
        } else if (piceOfDay <= HowPicesIsDay * 2 && piceOfDay > HowPicesIsDay) {
            isDayNow = false;
            return false;
        } else {
            piceOfDay = 0;
            return true;
        }
    }

    public static User getActiveUser() {
        return activeUser;
    }

    public static boolean isIsPause() {
        return isPause;
    }

    public static void setIsPause(boolean isPause) {
        Game.isPause = isPause;
    }

    public static int getMaximumMoves() {
        return maximumMoves;
    }

    public static void setMaximumMoves(int maximumMoves) {
        Game.maximumMoves = maximumMoves;
    }

    public static boolean hasReachedMaximumMoves() {

        return (countRounds < getMaximumMoves());
    }

    public static int getCountRounds() {
        return countRounds;
    }

    public static void setCountRounds(int countRounds) {
        Game.countRounds = countRounds;
    }

    public static int getHowPicesIsDay() {
        return Game.HowPicesIsDay;
    }

    public static void setHowPicesIsDay(int HowPicesIsDay) {
        Game.HowPicesIsDay = HowPicesIsDay;
    }

    public static void setIsDayNow(Boolean isDayNow) {
        Game.isDayNow = isDayNow;
    }

    public static Boolean getIsDayNow() {
        return Game.isDayNow;
    }

    public static int getPiceOfDay() {
        return Game.piceOfDay;
    }

    public static void setPiceOfDay(int piceOfDay) {
        Game.piceOfDay = piceOfDay;
    }

    public static boolean isCanKillMonster() {
        return Game.canKillMonster;
    }

    public static void setStillFighting(boolean stillFighting) {
        Game.stillFighting = stillFighting;
    }

    public static void setCanKillMonster(boolean canKillMonster) {
        Game.canKillMonster = canKillMonster;
    }

    public static boolean isStillFighting() {
        return Game.stillFighting;
    }
}

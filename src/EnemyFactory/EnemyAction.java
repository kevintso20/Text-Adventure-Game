package EnemyFactory;

import Commands.FindAnimal;

public class EnemyAction {

    private static int animalTimes = 0;
    private static String CurrentenemyName = "";

    public String bringEnemy(String enemyName) {
        EnemyFactory factory = new EnemyFactory();
        Enemy theEnemy = null;
        String finaltext = null;

        if (FindAnimal.isFound() == true) {
            theEnemy = factory.makeEnemy(enemyName);
            CurrentenemyName = enemyName;

            finaltext = doStuffEnemy(theEnemy);
        } else {
            return "There isn't any animal here";
        }
        return finaltext;
    }

    private String doStuffEnemy(Enemy enemy) {

        return enemy.displayEnemy();

    }

    public static String getCurrentenemyName() {
        return CurrentenemyName;
    }

    public static void setCurrentenemyName(String CurrentenemyName) {
        EnemyAction.CurrentenemyName = CurrentenemyName;
    }
}

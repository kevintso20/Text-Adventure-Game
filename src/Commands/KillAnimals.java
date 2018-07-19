package Commands;

import EnemyFactory.Enemy;
import EnemyFactory.EnemyFactory;
import EnemyFactory.EnemyAction;
import GUIControler.UpdateMethods;
import GameClasses.Game;
import GameClasses.Zork;

public class KillAnimals implements KeyOrder {

    @Override
    public String exec(String command) {
        EnemyFactory factory = new EnemyFactory();
        Enemy enemy = null;
        FindAnimal findAnimal = new FindAnimal();
        String finaltext = null;
        UpdateMethods updateMethods = new UpdateMethods();
        enemy = factory.makeEnemy(EnemyAction.getCurrentenemyName());

        if (enemy != null) {
            if (FindAnimal.isFound() == true) {
                FindAnimal.setFound(false);
                finaltext = "You kill the " + enemy.getName() + " but " + enemy.enemyRessist();
                updateMethods.updateHealthPoints((int) (Game.getActiveUser().getCurrentHp() - enemy.getAntDamage()));
            } else {
                finaltext = "There isn't any animal here";
            }
        } else {
            finaltext = "There isn't any animal here";
        }
        return finaltext;
    }

}

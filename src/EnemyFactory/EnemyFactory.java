package EnemyFactory;

public class EnemyFactory {

    public Enemy makeEnemy(String enemyType) {

        Enemy newEnemy = null;

        if (enemyType.equals("bear")) {
            return new EnemyBear();
        } else if (enemyType.equals("wolf")) {
            return new EnemyWolf();
        }else if (enemyType.equals("pig")) {
            return new EnemyPig();
        }else if (enemyType.equals("duck")) {
            return new EnemyDuck();
        } else {
            return null;
        }
    }

}

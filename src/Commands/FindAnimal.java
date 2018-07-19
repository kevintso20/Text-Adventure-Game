package Commands;

import EnemyFactory.EnemyAction;
import GUIControler.UpdateMethods;
import java.util.HashMap;

public class FindAnimal implements KeyOrder {

    private static boolean found = false;

    @Override
    public String exec(String command) {
        EnemyAction enemyTesting = new EnemyAction();

       return enemyTesting.bringEnemy(FoundedAnimal());

    }

    private String FoundedAnimal() {
        HashMap<Integer, String> hashmap = new HashMap<>();

        String finaltext = null;
        hashmap.put(0, "wolf");
        hashmap.put(1, "bear");
        hashmap.put(2, "pig");
        hashmap.put(3, "duck");

        int random = (int) (Math.random() * hashmap.size() + 0);

        if (hashmap.containsKey(random)) {
            finaltext = hashmap.get(random);
            found = true;
        }
        return finaltext;
    }

    public static boolean isFound() {
        return found;
    }

    public static void setFound(boolean found) {
        FindAnimal.found = found;
    }

}

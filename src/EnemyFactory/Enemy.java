package EnemyFactory;

public abstract class Enemy {

    private String name;
    private int antDamage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAntDamage() {
        return antDamage;
    }

    public void setAntDamage(int antDamage) {
        this.antDamage = antDamage;
    }

    public String enemyApears() {
        return "An enemy Apears";
    }

    public String displayEnemy() {
        return "I found a " + getName();
    }

    public String enemyRessist() {
        return getName() + " attack and did " + getAntDamage() + " damage";
    }

}

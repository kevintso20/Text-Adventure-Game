
package Objects;


public class OrderToMonster {
   
    String order;
    String move;
    int healthDecrease;

    public OrderToMonster() {
    }

    public OrderToMonster(String order, String move, int healthDecrease) {
        this.order = order;
        this.move = move;
        this.healthDecrease = healthDecrease;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public int getHealthDecrease() {
        return healthDecrease;
    }

    public void setHealthDecrease(int healthDecrease) {
        this.healthDecrease = healthDecrease;
    }
    
    
    
}

package Storys;

import Objects.OrderToMonster;
import static MonsterFight.FightMonster.listWithOrderToMonster;
import java.util.List;

public class Fight {

    public List makeFight(List<OrderToMonster> listWithOrderToMonster, boolean iWantToCallit) {
        if (iWantToCallit == true) {

            OrderToMonster orderToMonster1 = new OrderToMonster("cover", "Laser", 10);
            OrderToMonster orderToMonster2 = new OrderToMonster("skif", "Invisible Punch", 12);
            OrderToMonster orderToMonster3 = new OrderToMonster("close eys", "Hypnosis", 15);
            OrderToMonster orderToMonster4 = new OrderToMonster("step back", "Mega bomb", 17);
            OrderToMonster orderToMonster5 = new OrderToMonster("step back", "Energy Cage", 22);
            OrderToMonster orderToMonster6 = new OrderToMonster("jump", "Energy Circle", 13);
            OrderToMonster orderToMonster7 = new OrderToMonster("side step", "Bite", 7);

            listWithOrderToMonster.add(orderToMonster1);
            listWithOrderToMonster.add(orderToMonster2);
            listWithOrderToMonster.add(orderToMonster3);
            listWithOrderToMonster.add(orderToMonster4);
            listWithOrderToMonster.add(orderToMonster5);
            listWithOrderToMonster.add(orderToMonster6);
            listWithOrderToMonster.add(orderToMonster7);

        }
        return listWithOrderToMonster;
    }
}

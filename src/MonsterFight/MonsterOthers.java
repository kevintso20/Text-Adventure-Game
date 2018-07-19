package MonsterFight;

import GameClasses.Zork;

import java.net.URL;

import javax.swing.ImageIcon;

public class MonsterOthers {

    public static int PERSENTAGEMONSTERAPEARS = 10000;

    public ImageIcon setImageOfMonsterMove(String monsterNextMove) {
        monsterNextMove = monsterNextMove.toLowerCase();

        URL url = Zork.class.getResource("/Images/MonsterMoves/" + monsterNextMove + ".gif");

        ImageIcon imageIcon = new ImageIcon(url);

        return imageIcon;
    }

    public Boolean randomFindMonster() {
        Boolean fight = false;
        int random = (int) (Math.random() * PERSENTAGEMONSTERAPEARS + 1);

        if (random == 1) {
            fight = true;
        }
        return fight;
    }

    private String[] getURLImagesMonsterMoves() {
        String[] MonsterMoves = new String[9];
        MonsterMoves[0] = "/Images/MonsterMoves/bite.gif";
        MonsterMoves[1] = "/Images/MonsterMoves/scream.gif";
        MonsterMoves[2] = "/Images/MonsterMoves/punch.gif";
        MonsterMoves[3] = "/Images/MonsterMoves/iron tail.gif";
        MonsterMoves[4] = "/Images/MonsterMoves/toxic gass.gif";
        MonsterMoves[5] = "/Images/MonsterMoves/stab.gif";
        MonsterMoves[6] = "/Images/MonsterMoves/scratch.gif";
        MonsterMoves[7] = "/Images/MonsterMoves/searching.gif";
        MonsterMoves[8] = "/Images/MonsterMoves/stadytime.gif";

        return MonsterMoves;

    }

    public ImageIcon spesificImageMonsterLabel(int possision) {

        String[] MonsterMoves = getURLImagesMonsterMoves();

        URL url = Zork.class.getResource(MonsterMoves[possision]);
        ImageIcon imageIcon = new ImageIcon(url);

        return imageIcon;
    }

}

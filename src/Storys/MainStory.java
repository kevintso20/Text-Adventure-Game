package Storys;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Objects.Order;

public class MainStory {

    public static String[] itemsCanHunt;
    public static String[] itemsCanEat;
    public static String[] areasCanHunt;
    public static String selectedStory = "null";

    public List makeTheStory(List<Order> listWithOrders, Boolean iWantToCallIT) {
        InheritanceCommands initial = new InheritanceCommands();
        if (iWantToCallIT == true) {
            List<String> line = getText();
            listWithOrders = parser(line, listWithOrders);
            listWithOrders = initial.insert(listWithOrders);
        }
        return listWithOrders;
    }

    private List<String> getText() {

        List<String> lines = new ArrayList<>();

        Path currentRelativePath = Paths.get("");
        String pathOfWorkingDirectory = currentRelativePath.toAbsolutePath().toString();

        try {
            BufferedReader br = new BufferedReader(new FileReader(pathOfWorkingDirectory + "\\" + selectedStory + ".txt"));
            String line = br.readLine();
            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainStory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainStory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lines;
    }

    private List parser(List<String> line, List<Order> listWithOrders) {
        String lineFromList = null;
        String[] lineFromListSplited;

        for (int i = 0; i < line.size(); i++) {
            if (i == 1) {
                lineFromList = line.get(i);
                lineFromListSplited = lineFromList.split("/");
                lineFromListSplited = trimTheArrayString(lineFromListSplited, i);
                InheritanceCommands.rooms = lineFromListSplited;
            } else if (i == 3) {
                lineFromList = line.get(i);
                lineFromListSplited = lineFromList.split("/");
                lineFromListSplited = trimTheArrayString(lineFromListSplited, i);
                itemsCanHunt = lineFromListSplited;
            } else if (i == 5) {
                lineFromList = line.get(i);
                lineFromListSplited = lineFromList.split("/");
                lineFromListSplited = trimTheArrayString(lineFromListSplited, i);
                itemsCanEat = lineFromListSplited;
            } else if (i == 7) {
                lineFromList = line.get(i);
                lineFromListSplited = lineFromList.split("/");
                lineFromListSplited = trimTheArrayString(lineFromListSplited, i);
                areasCanHunt = lineFromListSplited;
            } else if (i >= 10) {
                lineFromList = line.get(i);
                lineFromListSplited = lineFromList.split("/");
                lineFromListSplited = trimTheArrayString(lineFromListSplited, i);
                listWithOrders = inputOrderIntoList(listWithOrders, lineFromListSplited);
            }
            lineFromList = null;
        }

        return listWithOrders;

    }

    private String[] trimTheArrayString(String[] lineFromListSplited, int i) {

        if (i == 1) {
            lineFromListSplited[0] = lineFromListSplited[0].trim();
        } else if (i == 3) {
            lineFromListSplited[0] = lineFromListSplited[0].trim();
        } else if (i == 5) {
            lineFromListSplited[0] = lineFromListSplited[0].trim();
        } else if (i == 7) {
            lineFromListSplited[0] = lineFromListSplited[0].trim();
        } else if (i >= 10) {
            lineFromListSplited[0] = lineFromListSplited[0].trim();
            lineFromListSplited[1] = lineFromListSplited[1].trim();
            lineFromListSplited[2] = lineFromListSplited[2].trim();
            lineFromListSplited[3] = lineFromListSplited[3].trim();
            lineFromListSplited[4] = lineFromListSplited[4].trim();
            lineFromListSplited[5] = lineFromListSplited[5].trim();
            lineFromListSplited[6] = lineFromListSplited[6].trim();
            lineFromListSplited[7] = lineFromListSplited[7].trim();
            lineFromListSplited[8] = lineFromListSplited[8].trim();
            lineFromListSplited[9] = lineFromListSplited[9].trim();
        }

        return lineFromListSplited;
    }

    private List inputOrderIntoList(List<Order> listWithOrders, String[] lineFromListSplited) {

        Order comand = new Order();

        comand.setVerb(lineFromListSplited[0]);
        comand.setNoun(lineFromListSplited[1]);
        comand.setRoomName(lineFromListSplited[2]);
        comand.setSideInRoom(lineFromListSplited[3]);
        comand.setInventoryItem(lineFromListSplited[4]);
        comand.setCorrectOrderText(lineFromListSplited[5]);
        comand.setWrongOrderText(lineFromListSplited[6]);
        comand.setToDoAfterCorrectOrder(lineFromListSplited[7]);
        comand.setAffectsInventory(lineFromListSplited[8]);
        comand.setCanBeAppliedEverywhere(lineFromListSplited[9]);

        listWithOrders.add(comand);
        comand = null;

        return listWithOrders;
    }


}

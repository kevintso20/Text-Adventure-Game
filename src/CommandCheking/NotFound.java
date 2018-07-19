package CommandCheking;

import Objects.Order;
import java.util.List;

public class NotFound {

    public String ifnotFoundComand(String[] order, String finaltext) {

        finaltext = checkIfOrderIsBullShit(finaltext, finaltext);
        finaltext = checkIfOrderIsEmpty(order[0], finaltext);
        finaltext = checkIfOrderIsOnePice(order, finaltext);
        finaltext = checkIfOrderIsTreePices(order, finaltext);

        return finaltext;
    }

    private String checkIfOrderIsEmpty(String comand0, String returningString1) {
        boolean flag = false;
        if (comand0.length() == 0) {
            comand0 = "Type Something!!!!";
            flag = true;
        }
        if (flag == false) {
            return returningString1;
        }
        return comand0;
    }

    private String checkIfOrderIsTreePices(String[] order, String returningString1) {
        String finaltext = returningString1;
        int length = order.length;
        int PicesOrderHaveSplit = 2;
        if (length > PicesOrderHaveSplit) {
            if (order[length - 1].length() != 0) {
                finaltext = "Syntax Error!!!! Type Verb Noun Next Time!!!";
            }
        }
        return finaltext;
    }

    private String checkIfOrderIsOnePice(String[] order, String returningString1) {
        String finaltext = returningString1;

        if (order.length == 1) {
            if (order[order.length - 1].length() != 0) {
                boolean flag = false;
                flag = checkIfIsInAceptedOrder(order[0]);
                if (flag == true) {
                    finaltext = "You Forget To Type Noun";
                } else {
                    finaltext = "Syntax Error!!!Type Correct Verb";
                }
            }
        }
        return finaltext;
    }

    private String checkIfOrderIsBullShit(String comand, String returningString1) {
        boolean flag = false;
        flag = checkIfIsInAceptedOrder(comand);
        if (flag == false) {
            returningString1 = "Stop Typing Bullshits!!! Type Verb  Noun!!! ";
            return returningString1;
        }
        return returningString1;
    }

    public String ifOrderNotFoundReturnPossOfVerb(List<Order> listWithOrders, String Verb, String finaltext) {

        for (int i = 0; i < listWithOrders.size(); i++) {
            if (listWithOrders.get(i).getVerb().equals(Verb)) {
                finaltext = listWithOrders.get(i).getWrongOrderText();
                break;
            }
        }
        return finaltext;
    }

    public Boolean checkIfIsInAceptedOrder(String comand) {
        boolean flag = false;
        String[] inputIntoInvertory = {"get", "take", "grab"};
        String[] deleteFromInvertory = {"unlock", "use", "put", "active"};
        String[] moves = {"see", "close", "open", "look", "go", "move", "do"};

        int j = 0;
        int countFromInput = inputIntoInvertory.length;
        int countFromDelete = deleteFromInvertory.length;
        int countmoves = moves.length;

        for (j = 0; j < countFromInput; j++) {
            if (comand.equals(inputIntoInvertory[j])) {
                flag = true;
                break;
            }
        }

        for (j = 0; j < countFromDelete; j++) {
            if (comand.equals(deleteFromInvertory[j])) {
                flag = true;
                break;
            }
        }

        for (j = 0; j < countmoves; j++) {
            if (comand.equals(moves[j])) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}

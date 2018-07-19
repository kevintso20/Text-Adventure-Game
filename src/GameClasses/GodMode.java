package GameClasses;

import CommandCheking.DoCommand;
import GUIControler.UpdateMethods;
import Handlers.GodModeImage;
import Handlers.Inventory;
import java.util.List;
import Handlers.Item;
import java.util.ArrayList;
import Objects.Order;
import Storys.InheritanceCommands;
import Storys.MainStory;

public class GodMode implements Commands.KeyOrder {

    public static boolean canAcsessGodModeAgain = true;
    public static boolean isStillInGodMode = false;
    public static String HaveOpenGodModeByOrder = "duno";
    private static List<Item> listitems = new ArrayList<>();
    private static List<Order> listorders = new ArrayList<>();
    private static boolean iWantToCallit = true;
    private static boolean usedSkillOfTeleport = false;
    private static boolean usedSkillOfTakingItem = false;
    private static boolean usedSkillOfRuning = false;
    private static String ifThisAbilityHaveUsedShowCorrectText = "duno";
    private static String finaltext = "empty";
    Item handleItem = new Item();
    InheritanceCommands initial = new InheritanceCommands();

    public void GodMode(String[] orders) {
        UpdateMethods updateMethods = new UpdateMethods();

        if (canAcsessGodModeAgain == true) {

            SwicherMode();

            abilityOneTeleportToRoom(orders);
            abilityTwoTakeItem(orders);
            abilityToRunFromMonster(orders);

        } else if (canAcsessGodModeAgain == false) {
            isStillInGodMode = false;
            updateMethods.updateFinalText("You Cant Use God Mode Again!!!!");
        }

    }

    private void abilityTwoTakeItem(String[] orders) {
        boolean isExistingThisItem = false;
        MainStory storyfile = new MainStory();
        Inventory inventory = new Inventory();
        DoCommand doCommand = new DoCommand();
        List<Inventory> listwithInventory = doCommand.getListWithInvertory();

        if (orders[0].matches("give") && orders[1].matches("me")) {

            if (usedSkillOfTakingItem == false) {

                listorders = storyfile.makeTheStory(listorders, iWantToCallit);
                listitems = handleItem.getItemsFromOrder(listorders, listitems, iWantToCallit);
                iWantToCallit = false;

                for (Item listitem : listitems) {
                    if (orders[2].matches(listitem.getItemName())) {
                        finaltext = "Now You Have " + listitem.getItemName();
                        inventory.setItem(listitem.getItemName());
                        inventory.setUser(Game.getActiveUser().getUserName());
                        listwithInventory.add(inventory);
                        isExistingThisItem = true;
                        usedSkillOfTakingItem = true;
                        inventory = null;
                    }
                }
                if (isExistingThisItem == false) {
                    finaltext = "This Item Dossent Exists In Game ";
                }

            }
            ifThisAbilityHaveUsedShowCorrectText = "take item";
        }
        DoCommand.setListWithInvertory(listwithInventory);
        
        UpdateMethods updateMethods = new UpdateMethods();
        updateMethods.updateFinalText(finaltext);
    }

    private void abilityOneTeleportToRoom(String[] orders) {
        if (orders[0].matches("goto")) {
            if (usedSkillOfTeleport == false) {
                String roomPartOfOrder = "";
                String existThisRoom = "no";
                if (orders.length == 3) {
                    roomPartOfOrder = orders[1] + " " + orders[2];
                } else if (orders.length == 2) {
                    roomPartOfOrder = orders[1];
                }

                for (String room : InheritanceCommands.rooms) {
                    if (roomPartOfOrder.matches(room)) {
                        if (orders.length == 3) {

                            Game.getActiveUser().setRoomYouAre(roomPartOfOrder);
                            finaltext = "You Teleported Into " + roomPartOfOrder;
                            existThisRoom = "yes";
                            usedSkillOfTeleport = true;

                            break;

                        } else if (orders.length == 2) {
                            Game.getActiveUser().setRoomYouAre(roomPartOfOrder);
                            finaltext = "You Teleported Into " + roomPartOfOrder;
                            existThisRoom = "yes";
                            usedSkillOfTeleport = true;
                            break;
                        }
                    }
                }
                if ("no".equals(existThisRoom)) {
                    finaltext = "This Room Dossent Exists";
                }

            }
            ifThisAbilityHaveUsedShowCorrectText = "teleport";
        }
        UpdateMethods updateMethods = new UpdateMethods();
        updateMethods.updateFinalText(finaltext);
    }

    private void SwicherMode() {
        if (usedSkillOfTakingItem == true && usedSkillOfTeleport == true && usedSkillOfRuning == true && "duno".equals(HaveOpenGodModeByOrder)) {
            finaltext = "You Use All Your Abilitys You Are Not God Any More";
            isStillInGodMode = false;
            canAcsessGodModeAgain = false;
        }

        switch (ifThisAbilityHaveUsedShowCorrectText) {
            case "take item":
                finaltext = "You Already Used Use This Ability";
                break;
            case "teleport":
                finaltext = "You Already Used Skill Of Teleport";
                break;
            case "run":
                finaltext = "You cant run now";
                break;
        }

        ifThisAbilityHaveUsedShowCorrectText = "duno";
        HaveOpenGodModeByOrder = "duno";

        UpdateMethods updateMethods = new UpdateMethods();
        updateMethods.updateFinalText(finaltext);
    }

    public String exec(String command) {

        if (command.equals("god mode on")) {
            if (isStillInGodMode == false) {
                HaveOpenGodModeByOrder = "yes";
                isStillInGodMode = true;
                finaltext = "You Enter God Mode!!!";
            } else {
                // finaltext = "You cant open god mode Becouse It's alerdy open";
            }
        } else if (command.equals("god mode off")) {
            if (isStillInGodMode == true) {
                HaveOpenGodModeByOrder = "no";
                isStillInGodMode = false;
                finaltext = "You Close God Mode!!!";
            } else {
                finaltext = "You cant close god mode Becouse It's alerdy close";
            }
        }
        UpdateMethods updateMethods = new UpdateMethods();
        GodModeImage gmi = new GodModeImage();
        updateMethods.updateGodModeImage(gmi.setTheImageOnGodMode());
        updateMethods.updateFinalText(finaltext);
        return finaltext;
    }

    public void gotoGodModeEvenIfHeFight(String[] orders) {
        if (orders[0].matches("god") && orders[1].matches("mode") && orders[2].matches("on") && isStillInGodMode == false) {
            HaveOpenGodModeByOrder = "yes";
            isStillInGodMode = true;
        }
    }

    private void abilityToRunFromMonster(String[] orders) {
        UpdateMethods updateMethods = new UpdateMethods();
        if (Game.isStillFighting() == true) {
            if (usedSkillOfRuning == false) {
                if (orders[0].matches("scares") && orders[1].matches("the") && orders[2].matches("monster")) {
                    finaltext = "The monster scared and left";
                    usedSkillOfRuning = true;

                    Game.setStillFighting(false);
                    updateMethods.updateMonsterMove("");
                    ifThisAbilityHaveUsedShowCorrectText = "run";
                }
            }
        }

        updateMethods.updateFinalText(finaltext);
    }
}

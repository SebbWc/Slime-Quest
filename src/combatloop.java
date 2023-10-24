//This class contains the combat loop and inventory options.

import java.util.Scanner;

public class combatloop {

    public static void playerchoicemenu() {

        //This is our method for prompting the user what they want to do in combat.
        System.out.println();
        System.out.println("Enter an action: ");
        System.out.println("A for basic attack.");
        System.out.println("B for special attack.");
        System.out.println("C to pass.");
        System.out.println("D to use access inventory");
    }

    public static int GreatAxedamagecalulator(player Jim, char playerchoice) {
        //This is the method for calculating damage and deciding which attack to do.
        //B represents a special attack that is unique to each weapon.
        if (playerchoice == 'B') {
            return Jim.strength + (2 * Jim.currstamina); //We do a special attack, if not than a regular attack.
        } else {
            return 4 + Jim.strength;
        }
    }

    public static int LongSworddamagecalculator(int strength, int dexterity, char playchoice){ //is it better if this takes just Jim? or variables of Jim?
        if (playchoice == 'B') {
            return strength * dexterity;
        } else
            return  2 + dexterity;

    }

    public static int FistDamageCalculator(int strength, int dexterity, char playerchoice) {
        if (playerchoice == 'B') {
            return 1 + strength + dexterity;
        } else
            return 4;
    }

    public static void inventorymenuoptions(player Jim) {

        //prompts user for inventory action after displaying inventory menus
        System.out.println("Key: f = fists, H = healthpotion, G = greataxe, L = longsword.");
        System.out.println("Weapon currently equipped: " + Jim.weapon);
        System.out.println("Inventory: " + Jim.inventory[0] + " , " + Jim.inventory[1] + " , " + Jim.inventory[2] + " , " + Jim.inventory[3]);
        System.out.println("A to use/equip inventory slot 1.");
        System.out.println("B for inventory slot 2.");
        System.out.println("C for inventory slot 3.");
        System.out.println("D for inventory slot 4.");
        System.out.println("Enter an action: ");

    }

    public static void inventorymenu(player Jim, char choice) {
        //This is our method for deciding which object we will interact with in our inventory.
        switch (choice) {
            case 'A':inventoryaction(Jim, 0);
                break;
            case 'B': inventoryaction(Jim, 1);
                break;
            case 'C':inventoryaction(Jim, 2);
                break;
            case 'D':inventoryaction(Jim, 3);
                break;
        }
    }

    public static void inventoryaction(player Jim, int inventoryslot) {
        //This is our method for deciding what will happen with the object we interacted with.
        if (Jim.inventory[inventoryslot] == 'H') { //using health pot
            System.out.println("You used a health potion and have full health.");
            Jim.currhealth = Jim.maxhealth;
            System.out.println("Your health: " + Jim.currhealth);
            Jim.inventory[inventoryslot] = 'f';
        } else if (Jim.inventory[inventoryslot] == 'G') { //equipping greataxe
            System.out.println("You equipped a GreatAxe.");
            Jim.inventory[inventoryslot] = Jim.weapon;
            Jim.weapon = 'G';
        } else if (Jim.inventory[inventoryslot] == 'L') { //equipping longsword
            System.out.println("You equipped a longsword.");
            Jim.inventory[inventoryslot] = Jim.weapon;
            Jim.weapon = 'L';
        } else if (Jim.inventory[inventoryslot] == 'f'){ //unequipping gear, using fists
            System.out.println("You unequipped your weapon.");
            Jim.inventory[inventoryslot] = Jim.weapon;
            Jim.weapon = 'f';
        }
    }

    public static void endofroundreport (player Jim, slime Blueslime){
        //This is a report that plays so you know what the situation is.
        if (Jim.currhealth > 0){
            System.out.println("Your health: " + Jim.currhealth + "   Your stamina: " + Jim.currstamina + "   Stamina regen: " + Jim.currstaminaregen);
        } else if (Jim.currhealth <= 0){
            System.out.println("You are dead.");
        }
        if (Blueslime.health > 0) {
            System.out.println("Blue slime health:  " + Blueslime.health + "     Blue slime stamina: " + Blueslime.currstamina);
        } else if (Blueslime.health <= 0){
            System.out.println("The slime is dead.");
        }
    }


    public static void PlayerDamageResolver (player Jim, char playerchoice, slime BlueSlime) {

        //this method is the final calculation for damage, and displays damage done.
        if (playerchoice == 'A') {
            if (Jim.weapon == 'f') {
                System.out.println("You strike for " + FistDamageCalculator(Jim.strength, Jim.dexterity, playerchoice) + " damage and lost 2 stamina.");
                BlueSlime.health = BlueSlime.health - FistDamageCalculator(Jim.strength, Jim.dexterity, playerchoice);
                Jim.currstamina = Jim.currstamina - 2;
            } else if (Jim.weapon == 'G'){
                System.out.println("You strike for " + GreatAxedamagecalulator(Jim, playerchoice) + " damage, and lost 5 stamina.");
                BlueSlime.health = BlueSlime.health - GreatAxedamagecalulator(Jim, playerchoice);
                Jim.currstamina = Jim.currstamina - 5;
            } else if (Jim.weapon == 'L'){
                System.out.println("You strike for " + LongSworddamagecalculator(Jim.strength, Jim.dexterity, playerchoice) + " damage, and lost 5 stamina.");
                BlueSlime.health = BlueSlime.health - LongSworddamagecalculator(Jim.strength, Jim.dexterity, playerchoice);
                Jim.currstamina = Jim.currstamina - 4;
            }
            //Special attack.
        } else if (playerchoice =='B') {
            if (Jim.weapon == 'f') {
                System.out.println("You strike for " + FistDamageCalculator(Jim.strength, Jim.dexterity, playerchoice) + " damage and lose 4 stamina.");
                BlueSlime.health = BlueSlime.health - FistDamageCalculator(Jim.strength, Jim.dexterity, playerchoice);
                Jim.currstamina = Jim.currstamina - 4;
            } else if (Jim.weapon == 'G'){
                System.out.println("You strike for " + GreatAxedamagecalulator(Jim, playerchoice) + " damage and lose all your stamina.");
                BlueSlime.health = BlueSlime.health - GreatAxedamagecalulator(Jim, playerchoice);
                Jim.currstamina = 0;
            } else if (Jim.weapon == 'L'){
                System.out.println("You strike for " + LongSworddamagecalculator(Jim.strength, Jim.dexterity, playerchoice) + " damage, and lost 5 stamina.");
                BlueSlime.health = BlueSlime.health - LongSworddamagecalculator(Jim.strength, Jim.dexterity, playerchoice);
                Jim.currstamina = Jim.currstamina - 6;
            }
        }
    }

    public static void EnemyTurn (player Jim, slime BlueSlime) {

        //This is the enemies turn.
        if (BlueSlime.health > 0) {
            if (BlueSlime.currstamina == 0){
                System.out.println("The Slime is too tired to do anything.");
            } else if (BlueSlime.health>5) {
                System.out.println("Blue slime slobbers on you for 3 damage.");
                Jim.currhealth = Jim.currhealth-3;
                BlueSlime.currstamina = BlueSlime.currstamina-2;
            }    else {
                System.out.println("Blue slime explodes for 6 damage.");
                Jim.currhealth = Jim.currhealth -6;
                BlueSlime.health = 0;
            }
        }
    }


    public static void combat(player Jim, Scanner input){

        //This is the main combat loop.

        //initializing variables
        char playerchoice;
        boolean combat = true;

        //enemy generation, again could have changed around stats with a randomizer if I wanted too!
        slime BlueSlime = new slime();

        //initial report for combat.
        endofroundreport(Jim,BlueSlime);
        while (combat)  //will trigger if someone dies.
        {
            //player menu here so they know what sort of action they want to do
            playerchoicemenu();
            playerchoice = input.next().charAt(0);
            //We enter a switch statement depending on the choice given
            switch (playerchoice) {
                case 'A':
                case 'B':
                    PlayerDamageResolver (Jim, playerchoice, BlueSlime); //attack from A and B
                    break;
                case 'C':
                    //Necessary for managing stamina.
                    System.out.println("You passed.");
                    break;
                case 'D':
                    inventorymenuoptions(Jim);
                    playerchoice = input.next().charAt(0);
                    inventorymenu(Jim, playerchoice);
                    break;
                default:
                    //This occurs when you have failed to enter a proper key. Similar to passing.
                    System.out.println("Nothing happens.");
            }

            //stamina regeneration at the end of the round
            if (Jim.currstamina + Jim.staminaregen > Jim.maxstamina){
                Jim.currstamina = Jim.maxstamina; //this is to prevent stamina from regenerating over maxstamina
            } else if (Jim.currstamina < Jim.maxstamina) {
                Jim.currstamina += Jim.staminaregen;
            }

            //enemy turn
            EnemyTurn(Jim, BlueSlime);

            endofroundreport(Jim, BlueSlime); //check if combat continues
            if (BlueSlime.health <= 0 || Jim.currhealth <= 0){
                combat = false;
            }
        }

        //results if won
        if (BlueSlime.health <= 0) {
            System.out.println("You've won the battle! You've gotten stronger from the experience.");
            Jim.strength = Jim.strength + 1;
            Jim.dexterity = Jim.dexterity + 1;
            Jim.maxhealth = Jim.maxhealth + 2;
            Jim.currhealth = Jim.currhealth +2;
            Jim.currentlocation = 'x'; //To display a dead slime
        }

    }

}

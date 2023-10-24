//This class has all map related features. By the way, I was seriously afraid about how I would program this part until I saw you can pass a scanner as an argument during our lecture! (:

import java.util.Scanner;

public class Map {

    //This method displays map.
    public static void DisplayMap(char[][] Board){
        for (int row = 0; row < Board.length; row++)
        {
            for (int j = 0; j < Board[row].length; j++){
                System.out.print("[" + Board[row][j] + "] ");

            }
            System.out.println();
        }
        System.out.println("D = Doorway, a-q = Different rooms, X = monsters, S = shrines, K = king, step on him to win! Missing spaces are walls.");
    }

    public static void ExamineRoom(player Jim,Scanner ExamineRoominput){

        //The char responsible for yes or no prompts when interacting.
        char YesOrNo;

        switch (Jim.currentlocation) {
            case 'a':
                System.out.println("you've examined!");
                break;
            case 'b':
                System.out.println("This is a small 3x4 room with only one door, a killed slime and a health potion.");
                break;
            case 'c':
                System.out.println("This is a medium 3x5 room with an exit across from the entrance. As well as a slime in the middle of the room!");
                break;
            case 'd':
                System.out.println("This is a shrine room(3x3) with an exit on the south side of the map. Shrines heal me and can only be used once.");
                break;
            case 'e':
                System.out.println("This is a medium 3x5 room with 2 exits on the south side and south western side of the room. A slime is blocking the south western side of the room.");
                break;
            case 'f':
                System.out.println("This is a shrine room with only one door.");
                break;
            case 'o':
                System.out.println("This is a large 5x4 room with an exit across from the entrance, and a killed slime.");
                break;
            case 'q':
                System.out.println("This is a small 3x4 room with an exit on the north and north western side of the room. A slime is blocking the north exit.");
                break;
            case 'i':
                System.out.println("This is a shrine room with an exit to east.");
                break;
            case 'j':
                System.out.println("This is a tiny 2x2 room with only one entrance, with a health potion.");
                break;
            case 'k':
                System.out.println("This is a small 2x3 room with exits on the north and southern sides, and a slime was blocking this room.");
                break;
            case 'p':
                System.out.println("This is a shrine room, with only one entrance.");
                break;
            case 'm':
                System.out.println("A small 3x3 room with a crown in the middle. The crown is mushing a foot sized puddle of a slime. I should step on him!");
                break;
            case 'n':
                System.out.println("This is a hallway.");
                break;
            case 'D':
                System.out.println("You are in a doorway.");
                break;
            case 'x':
                System.out.println("A slime corpse.");
                break;
            case 'L':
                System.out.println("A longsword! Would you like to pick it up?");
                System.out.println("Yes = A, No = B");
                //if yes, add it to inventory, check for the nearest f slot, then stop the for loop
                YesOrNo = ExamineRoominput.next().charAt(0);
                if (YesOrNo == 'A') {
                    for (int i = 0; i <= 3; i++){
                        if (Jim.inventory[i] == 'f') {
                            Jim.inventory[i] = 'L';
                            i = 3;
                        }
                    }
                    System.out.println("You picked up a longsword!");
                    Jim.currentlocation = 'a'; //we have this so that the play will leave a walkable space after picking up the item.
                }
                break;
            case 'G':
                System.out.println("A greataxe! Would you like to pick it up?");
                System.out.println("Yes = A, No = B");
                //if yes, add it to inventory (check for the nearest f slot, then stop the for loop
                YesOrNo = ExamineRoominput.next().charAt(0);
                if (YesOrNo == 'A') {
                    for (int i = 0; i <= 3; i++){
                        if (Jim.inventory[i] == 'f') {
                            Jim.inventory[i] = 'G';
                            i = 3;
                        }
                    }
                    System.out.println("You picked up a greataxe!");
                    Jim.currentlocation = 'a';
                }
                break;
            case 'S':
                System.out.println("You used a shrine, you are now fully healed.");
                Jim.currhealth = Jim.maxhealth;
                Jim.currstamina = Jim.maxstamina;
                Jim.currentlocation = 's';
                break;
            case 's':
                System.out.println("A shrine that has already been used.");
                break;
            case 'H':
                System.out.println("A health potion! Would you like to add it to your inventory?");
                System.out.println("Yes = A, No = B");
                //if yes, add it to inventory (check for the nearest f slot, then stop the for loop
                YesOrNo = ExamineRoominput.next().charAt(0);
                if (YesOrNo == 'A') {
                    for (int i = 0; i <= 3; i++){
                        if (Jim.inventory[i] == 'f') {
                            Jim.inventory[i] = 'H';
                            i = 3;
                        }
                    }
                    System.out.println("You picked up a health potion!");
                    Jim.currentlocation = 'h';
                }
            case 'h':
                System.out.println("There was a health potion here.");
                break;
        }
    }

    public static void initializemap(char[][] Map) {

        //There might be a better way to do this but I am not really sure how to do that. But this wasn't that bad.
        for (int row = 0; row < Map.length; row++) {
            for (int column = 0; column < Map[row].length; column++) {
                //' ' will represent a wall.
                Map[row][column] = ' ';
            }
        }

        //Room1
        for (int row = 1; row <= 5; row++) {

            for (int column = 1; column <= 2; column++) {
                Map[row][column] = 'a';
            }
        }

        //Room2
        for (int row = 1; row <= 3; row++) {

            for (int column = 4; column <= 7; column++) {
                Map[row][column] = 'b';
            }
        }

        //Hallway
        for (int column = 4; column <= 8; column++)
            Map[5][column] = 'n';

        //Room3
        for (int row = 1; row <= 5; row++) {

            for (int column = 10; column <= 12; column++) {
                Map[row][column] = 'c';
            }
        }

        //Room5
        for (int row = 4; row <= 6; row++) {

            for (int column = 14; column <= 16; column++) {
                Map[row][column] = 'd';
            }
        }

        //Room12
        for (int row = 8; row <= 12; row++) {

            for (int column = 14; column <= 16; column++) {
                Map[row][column] = 'e';
            }
        }

        //Room18
        for (int row = 14; row <= 16; row++) {

            for (int column = 14; column <= 16; column++) {
                Map[row][column] = 'f';
            }
        }

        //Room14
        for (int row = 10; row <= 14; row++) {

            for (int column = 9; column <= 12; column++) {
                Map[row][column] = 'o';
            }
        }

        //Room13
        for (int row = 11; row <= 14; row++) {

            for (int column = 5; column <= 7; column++) {
                Map[row][column] = 'q';
            }
        }

        //Room17
        for (int row = 7; row <= 9; row++) {

            for (int column = 5; column <= 7; column++) {
                Map[row][column] = 'i';
            }
        }

        //Room9
        for (int row = 7; row <= 8; row++) {

            for (int column = 9; column <= 10; column++) {
                Map[row][column] = 'j';
            }
        }

        //Room11
        for (int row = 11; row <= 12; row++) {

            for (int column = 1; column <= 3; column++) {
                Map[row][column] = 'k';
            }
        }

        //Room16
        for (int row = 14; row <= 16; row++) {

            for (int column = 1; column <= 3; column++) {
                Map[row][column] = 'p';
            }
        }

        //Room7
        for (int row = 7; row <= 9; row++) {

            for (int column = 1; column <= 3; column++) {
                Map[row][column] = 'm';
            }
        }

        //Doors
        Map[5][3] = 'D';
        Map[4][4] = 'D';
        Map[5][9] = 'D';
        Map[5][13] = 'D';
        Map[7][15] = 'D';
        Map[13][15] = 'D';
        Map[12][13] = 'D';
        Map[13][8] = 'D';
        Map[10][6] = 'D';
        Map[8][8] = 'D';
        Map[13][2] = 'D';
        Map[10][2] = 'D';
        Map[11][4] = 'D';

        //shrine spawns
        Map[5][15] = 'S';
        Map[15][15] = 'S';
        Map[15][2] = 'S';
        Map[15][2] = 'S';
        Map[8][6] = 'S';

        //item spawns
        Map[1][1] = 'L'; //longsword
        Map[1][2] = 'G'; //greataxe
        Map[2][6] = 'H'; //health potions
        Map[7][9] = 'H';

        //monster spawns
        Map[3][4] = 'X';
        Map[3][11] = 'X';
        Map[12][14] = 'X';
        Map[12][12] = 'X';
        Map[11][6] = 'X';
        Map[11][3] = 'X';

        //king spawner
        Map[8][2] = 'K';

        //testing beating the game
        //Map[2][2] = 'K';

    }

    //the method that will move the character
    public static void MovingCharacter (char Movement, char[][] Map, int times, player Jim) {

        char temp;

        if (Movement == 'N') {
            for (int i = 1; i <= times; i++){

                if (Map[Jim.row-1][Jim.column]!= ' '){ //This line of code checks if the move is legal.
                    temp = Map[Jim.row-1][Jim.column];  //Save space we move to into a temp.
                    Map[Jim.row-1][Jim.column] = Map[Jim.row][Jim.column]; //Move.
                    Map[Jim.row][Jim.column] = Jim.currentlocation; //Reload previous location.
                    Jim.currentlocation = temp; //Save current location as temp for next movement.
                    Jim.row = Jim.row - 1; //Decrement for next move.

                    if (Jim.currentlocation == 'X' || Jim.currentlocation == 'K') { //this line of code stops the player when battle will occur or they stepped on the king.
                        i = times;
                    }

                }
            }
        } else if (Movement == 'S') {

            for (int i = 1; i <= times; i++){
                if (Map[Jim.row+1][Jim.column]!= ' '){

                    temp = Map[Jim.row+1][Jim.column];
                    Map[Jim.row+1][Jim.column] = Map[Jim.row][Jim.column];
                    Map[Jim.row][Jim.column] = Jim.currentlocation;
                    Jim.currentlocation = temp;
                    Jim.row = Jim.row + 1;

                    if (Jim.currentlocation == 'X' || Jim.currentlocation == 'K') {
                        i = times;
                    }

                }
            }

        } else if (Movement == 'E') {

            for (int i = 1; i <= times; i++){
                if (Map[Jim.row][Jim.column+1]!= ' '){
                    temp = Map[Jim.row][Jim.column+1];
                    Map[Jim.row][Jim.column+1] = Map[Jim.row][Jim.column];
                    Map[Jim.row][Jim.column] = Jim.currentlocation;
                    Jim.currentlocation = temp;
                    Jim.column++;

                    if (Jim.currentlocation == 'X' || Jim.currentlocation == 'K') {
                        i = times;
                    }

                }
            }

        } else if (Movement == 'W'){

            for (int i = 1; i <= times; i++){
                if (Map[Jim.row][Jim.column-1]!= ' '){
                    temp = Map[Jim.row][Jim.column-1];
                    Map[Jim.row][Jim.column-1] = Map[Jim.row][Jim.column];
                    Map[Jim.row][Jim.column] = Jim.currentlocation;
                    Jim.currentlocation = temp;
                    Jim.column--;

                    if (Jim.currentlocation == 'X' || Jim.currentlocation == 'K') {
                        i = times;
                    }

                }
            }
        }
    }

    public static void MapGreeting() {
        //map greeting message
        System.out.println("Choose an option:");
        System.out.println("Move = A, Display Map = M, Interact/Examine = X, Access inventory = B, Player Report = C");

    }

    public static void MovementDialogue() {
        //movement dialogue message
        System.out.println("Which direction would you like to go?");
        System.out.println("North = N, East = E, South = S, West = W");

    }

    public static void MapInventoryMenu(player Jim, Scanner equip) {

        //similar to inventory during battle method.
        combatloop.inventorymenuoptions(Jim);
        char choice = equip.next().charAt(0);
        combatloop.inventorymenu(Jim,choice);

    }

    public static void playerreport(player Jim) {

        //a way to check your stats.
        System.out.println("You have " + Jim.strength + " strength.");
        System.out.println("You have " + Jim.dexterity + " dexterity.");
        System.out.println("You have " + Jim.vitality + " vitality.");
        System.out.println("You have " + Jim.speed + " speed.");
        System.out.println("You have " + Jim.currhealth + "/" + Jim.maxhealth + " health.");
        System.out.println("You have " + Jim.currstamina + "/" + Jim.maxstamina + " stamina with " + Jim.staminaregen + " stamina regen.");
        System.out.println("Key: f = fists, H = healthpotion, G = greataxe, L = longsword.");
        System.out.println("Weapon currently equipped: " + Jim.weapon);
        System.out.println("Inventory: " + Jim.inventory[0] + " , " + Jim.inventory[1] + " , " + Jim.inventory[2] + " , " + Jim.inventory[3]); //I wrote this out once and copy and pasted it whenever I used it again, I do know a for loop would be cleaner.
        System.out.println();

    }

}

//our game driver class

import java.util.Scanner;

public class GameDriver {


    public static void main(String[] args) {

        //scanner for input
        Scanner input = new Scanner(System.in);

        //creating player
        player Jim = new player();
        //variables for movement
        int times;
        char Movement;

        //setting up map
        char[][] GameMap = new char[18][18];
        Map.initializemap(GameMap);

        //Player spawn
        GameMap[2][1] = 'P';

        //Use to end program.
        boolean map = true;

        //Greeting message, sorry by the way maybe I have been playing to much morrowind but I really don't mind walls of text in my games to read.
        System.out.println("Just an initial note:");
        System.out.println("You have to stand on something to interact with it. (but X's are slimes and combat will start once enter their space)");
        System.out.println("Blank spaces are walls. Capital lettered spaces are intractable. Lower case letters you can only examine.");
        System.out.println("You win by stepping on the king! [K]");
        System.out.println();
        System.out.println("Game Plot: The king slime has split into many pieces, you should go finish him so he doesn't cause anymore trouble!");

        //Initial map display.
        Map.DisplayMap(GameMap);

        while (map){

            //enter combat loop if on a slime
            if (Jim.currentlocation == 'X') {
                System.out.println("You encountered a blue slime!");
                System.out.println();
                combatloop.combat(Jim, input);
                if (Jim.currhealth == 0) {
                    System.out.println("Game over!");
                    map = false;
                }
            } else {

                //if there is no combat, we display a menu on what the character wants to do.
                Map.MapGreeting();
                Movement = input.next().charAt(0);
                if (Movement == 'A') {
                    //if movement, we move!
                    Map.MovementDialogue();
                    Movement = input.next().charAt(0);
                    System.out.println("How many times?");
                    times = input.nextInt(); //this many times.
                    Map.MovingCharacter(Movement, GameMap, times, Jim);
                } else if (Movement == 'M') { //or display map
                    Map.DisplayMap(GameMap);
                } else if (Movement == 'X') { //or examine/interact
                    Map.ExamineRoom(Jim, input);
                } else if (Movement == 'B') { //or access inventory
                    Map.MapInventoryMenu(Jim, input);
                } else if (Movement == 'C') { //or combat report
                    Map.playerreport(Jim);
                }
            }
            if (Jim.currentlocation == 'K'){ //if we step on the king, the game is over!
                System.out.println("You won the game!");
                map = false;
            }
        }
        input.close(); //closing scanner
    }
}


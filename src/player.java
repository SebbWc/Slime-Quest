//This class could have benefited with the use of a constructor, but we used the same initialization layout as the milestone.

public class player {

    //The player starts with no equipment.
    //Base stats, these will upgrade through combat.
    int strength = 5, dexterity = 2, vitality = 3, speed = 2;
    int health = 10, stamina = 5;

    //The player starts with no equipment.
    char[] inventory = {'f', 'f', 'f', 'f'};
    char weapon = 'f';

    //initializing values.
    int maxhealth = health + strength + vitality * 3;
    int maxstamina = stamina + (vitality * 3);
    int currstaminaregen = speed + vitality;
    int currhealth = maxhealth;
    int currstamina = maxstamina;
    int staminaregen = speed + vitality;

    //for use of map
    char currentlocation = 'a';
    //player spawn
    int row = 2, column = 1;

}


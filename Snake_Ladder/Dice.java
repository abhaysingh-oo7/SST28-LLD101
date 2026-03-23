package Snake_Ladder;

import java.util.Random;

public class Dice {
    
    static int roll(){
        Random rand = new Random();
        int number = rand.nextInt(6) + 1;

        return number;
    }
}

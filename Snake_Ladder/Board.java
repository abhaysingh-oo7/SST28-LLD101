package Snake_Ladder;

import java.util.HashMap;

public class Board {
    int size = 10;
    HashMap<Integer, Integer> snakes = new HashMap<>();
    HashMap<Integer, Integer> ladders = new HashMap<>();

    Board(){
        snakes.put(88,13);
        snakes.put(98,23);
        snakes.put(67,33);
        snakes.put(72,23);
        snakes.put(40,8);

        ladders.put(9, 50);
        ladders.put(19, 29);
        ladders.put(21, 89);
        ladders.put(28, 77);
        ladders.put(54, 95);
    }
}

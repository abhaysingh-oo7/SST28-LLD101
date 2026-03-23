package Snake_Ladder;

import java.util.LinkedList;
import java.util.Queue;

public class GameFactory {
    static Queue<Player>players = new LinkedList<>();
    static Level level;


    static Game createGame(int numberOfPlayers, String difficulty){
        
        for(int i=1; i<=numberOfPlayers; i++){
            String id = "p"+i;
            players.add(new Player(id));
        }
        if(difficulty == "Easy"){
            level = new easyLevel();
        }
        else if (difficulty == "Hard"){
            level = new hardLevel();
        }
        return new Game(level, players, new Board());
    }
    
}

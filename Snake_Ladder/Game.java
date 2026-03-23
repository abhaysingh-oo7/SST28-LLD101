package Snake_Ladder;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    Queue<Player> players;
    Level level;
    Board board;

    Game(Level level, Queue<Player>players, Board board){
        this.level = level;
        this.players = players;
        this.board = board;
    }

    void makeMove(){
        Player p = players.poll();
        int boundry = board.size * board.size;
        level.move(p, boundry);

        
        if(board.snakes.containsKey(p.currPosition)){
            p.currPosition = board.snakes.get(p.currPosition);
            System.out.println(p.name + " has eaten by snake -- new position of " +p.name +" : "+ p.currPosition);
        }
        else if(board.ladders.containsKey(p.currPosition)){
            System.out.println(p.name + " has climbed ladder -- new position of " +p.name +" : "+ p.currPosition);

            p.currPosition = board.ladders.get(p.currPosition);
            
        }
        
        if(p.currPosition == boundry){
            System.out.println(p.name+" has won");
        } else players.add(p);

    }
    
}

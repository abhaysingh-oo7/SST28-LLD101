package Snake_Ladder;

public class Main {
    public static void main(String[] args) {
        Game game = GameFactory.createGame(4, "Easy");

        while(game.players.size()>1){
            game.makeMove();
        }
        System.out.println((game.players.poll().name) + " is last");
    }
}

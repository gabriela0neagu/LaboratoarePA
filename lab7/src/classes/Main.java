package classes;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        Game game = new Game();
        game.setValueK(3);
        game.setValueN(10);
        game.setValueM(100);
        Board board = new Board(game.valueN, game.ValueM);

        System.out.println("Start Game");
        game.startGame(board);
    }


}

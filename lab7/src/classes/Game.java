package classes;

import static java.lang.Thread.sleep;

public class Game {
    public int valueK, valueN, ValueM;

    public void setValueK(int valueK) {
        this.valueK = valueK;

    }

    public void setValueM(int valueM) {
        ValueM = valueM;
    }

    public void setValueN(int valueN) {
        this.valueN = valueN;
    }

    public void startGame(Board board)
    {
        var player1 = new Player("player1", board);
        var player2 = new Player("player2", board);

        player1.givenValueK=valueK;
        player2.givenValueK=valueK;

        Thread thread1= new Thread(player1);
        thread1.start();
        Thread thread2 = new Thread(player2);
        thread2.start();

        try
        {
            thread1.join();
            thread2.join();
        }
        catch(Exception e)
        {
            System.out.println("Interrupted");
        }
    }
}

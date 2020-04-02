package classes;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Player implements Runnable {

    ArrayList<Token> playersTokens = new ArrayList<Token>();
    volatile Board board;
    int points = 0;
    public int givenValueK;
    String name;
    int n;

    Player(String name, Board board) {
        this.name = name;
        this.board = board;
        n = board.tokens.size();
        System.out.println("Player " + name + " is in!");
    }

    @Override
    public synchronized void run() {
        while (board.tokens.size() !=0 && givenValueK != longestAp(playersTokens)) {
            System.out.println("game board " + board);
            try {
                extractToken(board);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( name+" :My tokens= " + playersTokens + "\n");
        }
        if(board.tokens.size()==0)
        {
            points=longestAp(playersTokens);
            System.out.println("End of game");
            System.out.println("Player " + name + " has: " + points + " points");
        }
        else
        if(longestAp(playersTokens)==givenValueK)
        {
            points=n;
            System.out.println("End of game");
            System.out.println("Player " + name + " has: " + points + " points");
        }
    }

    public void extractToken(Board board) throws InterruptedException {
        int tokenId = new Random().nextInt(board.tokens.size());
        playersTokens.add(board.tokens.get(tokenId));
        board.tokens.remove(tokenId);
        sleep(200);
    }

    public int longestAp(ArrayList<Token> tokens)
    {
        int len = tokens.size();
        int max = 1;
        int[][] dp = new int[len][len];
        if(tokens==null)
            return 0;
       else {
            for (int i = 0; i < len; i++)
            {
                dp[i][i] = 1;
                for (int j = i + 1; j < len; j++) {
                    dp[i][j] = 2;
                    int difference = tokens.get(j).value - tokens.get(i).value;
                    // this loop is checking is there any element with the same distance
                    for (int k = i - 1; k >= 0; k--) {
                        if (tokens.get(i).value - tokens.get(k).value == difference) {
                            dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                            break;
                        }
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
            return max;
        }

    }

}

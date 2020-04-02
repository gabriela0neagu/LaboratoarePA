package classes;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    public int givenNumberN;
    public ArrayList<Token> tokens = new ArrayList<Token>();

    Board(int n, int m) {
        givenNumberN = n;
        for (int i = 0; i < givenNumberN; i++) {
            Token token = new Token();
            boolean ok = true;
            int randomValue;
            do {
                randomValue = new Random().nextInt(m) + 1;
                for (int j = 0; j < i; j++) {
                    if (tokens.get(j).value == randomValue) {
                        ok = false;
                        break;
                    }
                }
            } while (ok == false);
            token.value = randomValue;
            tokens.add(token);
        }
    }

    @Override
    public String toString() {
        return "Board{" + tokens + '}';
    }
}

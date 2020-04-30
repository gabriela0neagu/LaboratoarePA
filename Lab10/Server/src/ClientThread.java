import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class ClientThread extends Thread {
    private Socket socket;
    private final GameServer server;
    private boolean gameIsRunning = true;

    public ClientThread(GameServer server, Socket socket) {
        this.server = server;
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream());
            String commands;
            String textForClient;

            while (server.isRunning && gameIsRunning) {
                commands = input.readLine();
                textForClient = execute(commands);
                output.println(textForClient);
                output.flush();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private String execute(String commands) throws IOException {
        String clientInfo = null;
        String textForClient = null;
        String playerName = null;
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        switch (commands) {
            case "createUser":
                clientInfo = input.readLine();
                playerName = clientInfo;
                System.out.println("Player name is: " + playerName);
                textForClient = "Your game started now. Try other commands.";
                return textForClient;

            case "quit":
                textForClient = "Too bad, you left the game";
                this.gameIsRunning = false;
                System.out.println("A client left.");
                return textForClient;
            default:
                textForClient = "This is not a valid command yet";
                break;
        }
        return textForClient;
    }

}

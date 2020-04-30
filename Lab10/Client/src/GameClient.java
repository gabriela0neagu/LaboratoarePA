import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GameClient {
    private final static String SERVER_ADDRESS = "127.0.0.1";
    private final static int PORT = 8100;
    private Socket socket;
    boolean gameIsRunning = true;
    BufferedReader input;
    PrintWriter output;
    String responseFromClient;

    public void sendRequestToServer(String command) throws IOException {
        switch (command) {
            case "createUser":
                output.println(command);
                output.flush();
                System.out.println("Enter the name you want to have in the game:");
                command = this.readFromKeyboard();
                output.println(command);
                output.flush();
                responseFromClient = input.readLine();
                System.out.println(responseFromClient);
                break;
            case "quit":
                output.println(command);
                output.flush();
                responseFromClient = input.readLine();
                System.out.println(responseFromClient);
                socket.close();
                gameIsRunning = false;
                break;
            default:
                System.out.println("This is not an available command yet!");
        }
    }

    private String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


    public static void main(String[] args) throws IOException {
        GameClient client = new GameClient();
        client.socket = new Socket(SERVER_ADDRESS, PORT);
        client.input = new BufferedReader(new InputStreamReader(client.socket.getInputStream()));
        client.output = new PrintWriter(client.socket.getOutputStream());
        System.out.println("Hi! The game started! please follow the commands:");
        System.out.println("createUser: if you want an username during the game.");
        System.out.println("quit: if you want to give up.");
        while (client.gameIsRunning) {
            String command = client.readFromKeyboard();
            if (command.equalsIgnoreCase("exit")) {
                break;
            } else {
                client.sendRequestToServer(command);
            }
        }
    }
}

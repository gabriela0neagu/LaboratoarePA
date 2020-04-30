import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    public boolean isRunning = false;
    private boolean isStopped = false;

    public void startServer(){
        try {
            serverSocket = new ServerSocket(PORT);
            isRunning = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void waitForClients() throws IOException, InterruptedException {
        while(this.isRunning){
            System.out.println("Waiting for clients at port " + PORT);
            Socket socket;
            socket = serverSocket.accept();
            System.out.println("A new client has connected");
            ClientThread client = new ClientThread(this, socket);
            client.start();
            if(isStopped){
                client.join();
            }
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        GameServer server = new GameServer();
        server.startServer();
        server.waitForClients();
        try {
            server.serverSocket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

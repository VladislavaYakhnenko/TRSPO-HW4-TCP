import client.ClientRunner;
import client.TcpClient;
import server.ServerRunner;
import server.TcpServer;

public class Main {
    public static void main(String[] args) {
        TcpServer server = new TcpServer();
        TcpClient client = new TcpClient();

        Thread serverThread = new Thread(new ServerRunner(server));
        Thread clientThread = new Thread(new ClientRunner(client, server));

        serverThread.start();
        clientThread.start();

        try {
            clientThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}

package client;

import server.TcpServer;

public class ClientRunner implements Runnable {
    private final TcpServer server;
    private final TcpClient client;

    public ClientRunner(TcpClient client, TcpServer server) {
        this.client = client;
        this.server = server;
    }

    @Override
    public void run() {
        client.startClient();
        server.stopServer();
    }
}
package server;

public class ServerRunner implements Runnable {
    private final TcpServer server;

    public ServerRunner(TcpServer server) {
        this.server = server;
    }

    @Override
    public void run() {
        server.startServer();
    }
}
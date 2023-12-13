package edu.hw8.Task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {
    private final ServerSocket server;
    private final ExecutorService threadPool;
    public static final int MILLISECS_TILL_SERVER_AUTO_CLOSES = 1_000;

    public Server(int port, int poolSize) {
        try {
            server = new ServerSocket(port);
            server.setSoTimeout(MILLISECS_TILL_SERVER_AUTO_CLOSES);
        } catch (IOException e) {
            throw new RuntimeException("Server couldn't create a socket on this port");
        }
        threadPool = Executors.newFixedThreadPool(poolSize);
    }

    @Override
    public void run() {
        Handler handler = null;
        try {
            while (true) {
                handler = new Handler(server.accept());
                threadPool.execute(handler);
            }
        } catch (Exception e) {
            threadPool.shutdown();
        }
        try {
            if (handler != null) {
                handler.close();
            }
            server.close();
        } catch (Exception e) {
            throw new RuntimeException("Server hasn't been able to close");
        }
        threadPool.shutdown();
    }
}

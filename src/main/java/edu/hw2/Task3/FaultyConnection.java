package edu.hw2.Task3;

import java.util.Random;

public class FaultyConnection implements Connection {
    @Override
    public void execute(String command) {
        Random rnd = new Random();
        int r = rnd.nextInt();
        if (r % 2 == 1) {
            throw new ConnectionException();
        }
    }

    @Override
    public void close() {
    }
}

package edu.hw2.Task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        Random random = new Random();
        int r = random.nextInt();
        if (r % 2 == 1) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}

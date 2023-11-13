package edu.hw2.Task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager = new FaultyConnectionManager();
    private final int maxAttempts = 5;

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        for (int i = 0; i < maxAttempts; i++) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                break;
            } catch (ConnectionException e) {
                if (i == maxAttempts - 1) {
                    throw new ConnectionException();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

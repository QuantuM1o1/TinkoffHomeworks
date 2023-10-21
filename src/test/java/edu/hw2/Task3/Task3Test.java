package edu.hw2.Task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class Task3Test {
    @Test
    @DisplayName("Проверка DefaultConnectionManager на выкидывание ошибок")
    void defaultConnectionManagerThrows() {
        // given
        ConnectionManager manager = new DefaultConnectionManager();
        String someCommand = "1";

        // when
        Throwable thrown = catchThrowable(() -> {
            for (int i = 0; i < 20; i++) {
                Connection connection = manager.getConnection();
                for (int j = 0; j < 20; j++) {
                    connection.execute(someCommand);
                }
            }
        });

        // then
        assertThat(thrown).isInstanceOf(ConnectionException.class);
    }

    @Test
    @DisplayName("Проверка DefaultConnectionManager на вывод класса")
    void defaultConnectionManagerGetClass() {
        // given
        ConnectionManager[] managers = new DefaultConnectionManager[20];
        Connection[] connections = new Connection[20];

        // when
        for (int i = 0; i < 20; i++) {
            managers[i] = new DefaultConnectionManager();
            connections[i] = managers[i].getConnection();
        }

        // then
        assertThat(connections).hasAtLeastOneElementOfType(FaultyConnection.class).hasAtLeastOneElementOfType(StableConnection.class);
    }

    @Test
    @DisplayName("Проверка FaultyConnection на выкидывание ошибок")
    void faultyConnectionThrows() {
        // given
        FaultyConnection faultyConnection = new FaultyConnection();
        String someCommand = "1";

        // when
        Throwable thrown = catchThrowable(() -> {
            for (int i = 0; i < 20; i++) {
                faultyConnection.execute(someCommand);
            }
        });

        // then
        assertThat(thrown).isInstanceOf(ConnectionException.class);
    }

    @Test
    @DisplayName("Проверка FaultyConnectionManager на выдачу класса")
    void faultyConnectionManagerReturnClass() {
        // given
        ConnectionManager[] managers = new FaultyConnectionManager[20];
        Connection[] connections = new Connection[20];

        // when
        for (int i = 0; i < 20; i++) {
            managers[i] = new FaultyConnectionManager();
            connections[i] = managers[i].getConnection();
        }

        // then
        assertThat(connections).hasOnlyElementsOfType(FaultyConnection.class);
    }

    @Test
    @DisplayName("Проверка PopularCommandExecutor на выдачу ошибок")
    void popularCommandExecutorThrows() {
        // given
        PopularCommandExecutor executor = new PopularCommandExecutor();

        // when
        Throwable thrown = catchThrowable(() -> {
            for (int i = 0; i < 10000; i++) {
                executor.updatePackages();
            }
        });

        // then
        assertThat(thrown).isInstanceOf(ConnectionException.class);
    }
}

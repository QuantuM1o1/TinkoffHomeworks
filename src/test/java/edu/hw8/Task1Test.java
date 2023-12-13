package edu.hw8;

import edu.hw8.Task1.Client;
import edu.hw8.Task1.Server;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.shouldHaveThrown;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {
    @Test
    @DisplayName("Проверяем работу сервера")
    void serverAccessibility() {
        // given
        List<String> test = new ArrayList<>();
        test.add("личности");
        test.add("оскорбления");
        test.add("глупый");
        test.add("интеллект");
        int port = 18080;
        int numberOfThreads = 4;

        // when
        Set<String> answer = new HashSet<>();
        Random random = new Random();
        Server server = new Server(port, numberOfThreads);
        List<Thread> clientList = Stream.generate(() -> new Thread(() -> {
            int number = Math.abs(random.nextInt() % 4);
            Client client = new Client(port);
            String message = client.sendMessage(test.get(number));
            answer.add(message);
        }))
            .limit(100)
            .toList();
        Thread serverThread = new Thread(server);
        serverThread.start();
        clientList.forEach(Thread::start);
        clientList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        try {
            serverThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // then
        assertTrue(answer.contains("Не переходи на личности там, где их нет"));
        assertTrue(answer.contains("Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами"));
        assertTrue(answer.contains("А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма"));
        assertTrue(answer.contains("Чем ниже интеллект, тем громче оскорбления"));
        assertThat(answer.size()).isEqualTo(4);
    }
}

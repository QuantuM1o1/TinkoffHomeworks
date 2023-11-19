package edu.hw6;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {
    @Test
    @DisplayName("Занятые порты")
    void hackerNewsLength() {
        // given
        try (ServerSocket serverSocket = new ServerSocket(1112)) {
            serverSocket.getChannel();
            List<Integer> answer = Task6.scanPorts();
            assertTrue(answer.contains(1112));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

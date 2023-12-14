package edu.hw10;

import edu.hw10.Task2.CacheProxy;
import edu.hw10.Task2.FibCalculator;
import edu.hw10.Task2.FibCalculatorImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {
    @Test
    @DisplayName("Проверка сохранения в файл")
    void saveToFile() {
        // given
        FibCalculator c = new FibCalculatorImpl();
        FibCalculator proxy = CacheProxy.create(c, FibCalculator.class);
        Map<String, String> map = new HashMap<>();

        // when
        long answer1 = proxy.fib(5);
        long answer2 = proxy.fib(7);
        long answer3 = proxy.fib(10);

        Path path = Paths.get("src/main/resources/hw10/123.txt");
        if (Files.exists(path)) {
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] split = line.split(":");
                    String key = split[0];
                    String result = split[1];
                    map.put(key, result);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // then
        assertThat(answer1).isEqualTo(5);
        assertThat(answer2).isEqualTo(13);
        assertThat(answer3).isEqualTo(55);
        assertTrue(map.containsValue("5"));
        assertTrue(map.containsValue("13"));
        assertTrue(map.containsValue("55"));
    }
}

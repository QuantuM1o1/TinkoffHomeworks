package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import edu.hw6.Task2.Task2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @AfterEach
    public void tearDown() {
        try {
            Files.delete(Paths.get("src/main/resources/hw6/Task2/Tinkoff Bank Biggest Secret — копия.txt"));
            Files.delete(Paths.get("src/main/resources/hw6/Task2/Tinkoff Bank Biggest Secret — копия (2).txt"));
            Files.delete(Paths.get("src/main/resources/hw6/Task2/Tinkoff Bank Biggest Secret — копия (3).txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Создание нескольких копий")
    void firstCopy() {
        // given
        String path = "src/main/resources/hw6/Task2/Tinkoff Bank Biggest Secret.txt";
        Path test = Paths.get(path);

        // when
        Path answer = Task2.cloneFile(test);

        // then
        assertThat(answer.toString()).isEqualTo("Tinkoff Bank Biggest Secret — копия.txt");
        answer = Task2.cloneFile(test);
        assertThat(answer.toString()).isEqualTo("Tinkoff Bank Biggest Secret — копия (2).txt");
        answer = Task2.cloneFile(test);
        assertThat(answer.toString()).isEqualTo("Tinkoff Bank Biggest Secret — копия (3).txt");
    }
}

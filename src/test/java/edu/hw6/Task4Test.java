package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Написать текст в файл")
    void writeToFile() {
        // given
        String path = "src/main/resources/hw6/Task4/Task4.txt";
        Path test = Paths.get(path);

        // when
        Task4.streams(test);

        // then
        try {
            assertThat(Files.readString(test)).isEqualTo("Programming is learned by writing programs. ― Brian Kernighan");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

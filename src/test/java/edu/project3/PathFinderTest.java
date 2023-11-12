package edu.project3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PathFinderTest {
    @Test
    @DisplayName("Поиск пути к файлам с *")
    void pathToFileWithAsterisk() {
        // given
        String test = "src/main/resources/project3/*";

        // when
        List<Path> answer = PathFinder.findPath(test);

        // then
        assertThat(answer.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("Поиск пути к файлам с **")
    void pathToFileWithDoubleAsterisk() {
        // given
        String test = "src/**/logs.txt";

        // when
        List<Path> answer = PathFinder.findPath(test);

        // then
        assertThat(answer.size()).isEqualTo(1);
        assertTrue(answer.getFirst().endsWith("logs.txt"));
        assertThat(answer.getFirst().getNameCount()).isEqualTo(5);
        assertThat(answer.getFirst().toString()).isEqualTo("src\\main\\resources\\project3\\logs.txt");
    }

    @Test
    @DisplayName("Поиск пути к файлам")
    void pathToFile() {
        // given
        String test = "src/main/resources/project3/logs.txt";

        // when
        List<Path> answer = PathFinder.findPath(test);

        // then
        assertThat(answer.size()).isEqualTo(1);
        assertTrue(answer.getFirst().endsWith("logs.txt"));
        assertThat(answer.getFirst().getNameCount()).isEqualTo(5);
        assertThat(answer.getFirst().toString()).isEqualTo("src\\main\\resources\\project3\\logs.txt");
    }
}

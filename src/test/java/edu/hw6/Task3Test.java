package edu.hw6;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task3.AbstractFilter.EXECUTABLE;
import static edu.hw6.Task3.AbstractFilter.globMatches;
import static edu.hw6.Task3.AbstractFilter.HIDDEN;
import static edu.hw6.Task3.AbstractFilter.largerThan;
import static edu.hw6.Task3.AbstractFilter.lessThan;
import static edu.hw6.Task3.AbstractFilter.magicNumber;
import static edu.hw6.Task3.AbstractFilter.READABLE;
import static edu.hw6.Task3.AbstractFilter.regexContains;
import static edu.hw6.Task3.AbstractFilter.REGULAR_FILE;
import static edu.hw6.Task3.AbstractFilter.sizeIs;
import static edu.hw6.Task3.AbstractFilter.WRITABLE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Найти png")
    void pngFilter() {
        // given
        String path = "src/main/resources/hw6/Task3";
        Path test = Paths.get(path);

        // when
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(READABLE)
            .and(largerThan(100_000))
            .and(magicNumber(0x89, 'P', 'N', 'G'))
            .and(globMatches("*.png"))
            .and(regexContains("[-]"));
        final String[] answer = new String[1];

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(test, filter)) {
            entries.forEach(entry -> answer[0] = entry.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // then
        assertThat(answer[0]).isEqualTo("src\\main\\resources\\hw6\\Task3\\arkham_knights-wallpaper_2_by_phil_cho_dgghxc0.png");
    }

    @Test
    @DisplayName("Найти скрытый текстовый")
    void txtHidden() {
        // given
        String path = "src/main/resources/hw6/Task3";
        Path test = Paths.get(path);

        // when
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(READABLE)
            .and(WRITABLE)
            .and(HIDDEN)
            .and(lessThan(10))
            .and(globMatches("*.txt"))
            .and(regexContains("[1]"));
        final String[] answer = new String[1];

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(test, filter)) {
            entries.forEach(entry -> answer[0] = entry.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // then
        assertThat(answer[0]).isEqualTo("src\\main\\resources\\hw6\\Task3\\123.txt");
    }

    @Test
    @DisplayName("Найти исполняемый файл")
    void exeWithExactSize() {
        // given
        String path = "src/main/resources/hw6/Task3";
        Path test = Paths.get(path);

        // when
        DirectoryStream.Filter<Path> filter = REGULAR_FILE
            .and(READABLE)
            .and(EXECUTABLE)
            .and(sizeIs(27_648))
            .and(magicNumber('M', 'Z'))
            .and(globMatches("*.exe"))
            .and(regexContains("[Tac]"));
        final String[] answer = new String[1];

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(test, filter)) {
            entries.forEach(entry -> answer[0] = entry.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // then
        assertThat(answer[0]).isEqualTo("src\\main\\resources\\hw6\\Task3\\TicTacToe.exe");
    }
}

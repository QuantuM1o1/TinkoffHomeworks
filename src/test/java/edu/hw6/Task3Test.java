package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw6.Task3.AbstractFilterImpl.globMatches;
import static edu.hw6.Task3.AbstractFilterImpl.largerThan;
import static edu.hw6.Task3.AbstractFilterImpl.lessThan;
import static edu.hw6.Task3.AbstractFilterImpl.magicNumber;
import static edu.hw6.Task3.AbstractFilterImpl.readable;
import static edu.hw6.Task3.AbstractFilterImpl.regexContains;
import static edu.hw6.Task3.AbstractFilterImpl.regularFile;
import static edu.hw6.Task3.AbstractFilterImpl.writable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Найти png")
    void pngFilter() {
        // given
        String path = "src/main/resources/hw6/Task3";
        Path test = Paths.get(path);

        // when
        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable)
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
        assertThat(answer[0]).isEqualTo("src" + File.separator + "main" + File.separator + "resources" + File.separator + "hw6" + File.separator + "Task3" + File.separator + "arkham_knights-wallpaper_2_by_phil_cho_dgghxc0.png");
    }

    @Test
    @DisplayName("Найти скрытый текстовый")
    void txtHidden() {
        // given
        String path = "src/main/resources/hw6/Task3";
        Path test = Paths.get(path);

        // when
        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable)
            .and(writable)
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
        assertThat(answer[0]).isEqualTo("src" + File.separator + "main" + File.separator + "resources" + File.separator + "hw6" + File.separator + "Task3" + File.separator + "123.txt");
    }

    @Test
    @DisplayName("Найти исполняемый файл")
    void exeFinder() {
        // given
        String path = "src/main/resources/hw6/Task3";
        Path test = Paths.get(path);

        // when
        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable)
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
        assertThat(answer[0]).isEqualTo("src" + File.separator + "main" + File.separator + "resources" + File.separator + "hw6" + File.separator + "Task3" + File.separator + "TicTacToe.exe");
    }
}

package edu.project3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LogReaderTest {
    @Test
    @DisplayName("Чтение из файла")
    void readFromFile() {
        // given
        Path test = Paths.get("src/main/resources/project3/logs.txt");

        // when
        List<Log> answer = LogReader.read(test);

        // then
        assertThat(answer.size()).isEqualTo(21);
        assertThat(answer.getFirst().address()).isEqualTo("20.38.50.37");
        assertThat(answer.getFirst().requestAddress()).isEqualTo("/instruction%20set%20web-enabled%20internet%20solution.php");
        assertThat(answer.getLast().address()).isEqualTo("130.220.210.145");
        assertThat(answer.getLast().requestAddress()).isEqualTo("/analyzing%20Multi-lateral.svg");
    }

    @Test
    @DisplayName("Чтение с URL")
    void readFromURL() {
        // given
        URI test = URI.create("https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs");

        // when
        List<Log> answer = LogReader.read(test);

        // then
        assertThat(answer.size()).isEqualTo(51462);
        assertThat(answer.getFirst().address()).isEqualTo("93.180.71.3");
        assertThat(answer.getFirst().requestAddress()).isEqualTo("/downloads/product_1");
        assertThat(answer.getLast().address()).isEqualTo("79.136.114.202");
        assertThat(answer.getLast().requestAddress()).isEqualTo("/downloads/product_1");
    }
}

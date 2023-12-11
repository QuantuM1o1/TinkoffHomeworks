package edu.project3;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatAnalyserTest {
    @Test
    @DisplayName("Средний размер ответа")
    void averageAnswerSize() {
        // given
        List<Log> test = new ArrayList<>();
        test.add(new Log(
            "20.38.50.37",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/emulation.gif",
            200,
            2642,
            "-",
            "Opera/10.33"
        ));
        test.add(new Log(
            "130.220.210.145",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/emulation.gif",
            200,
            1731,
            "-",
            "Opera/10.33"
        ));
        test.add(new Log(
            "121.8.89.31",
            "-",
            OffsetDateTime.MIN,
            "HEAD",
            "/analyzing%20Multi-lateral.svg",
            404,
            1552,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "80.91.33.133",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            302,
            2174,
            "-",
            "Opera/10.46"
        ));

        // when
        double answer = StatAnalyser.averageAnswerSize(test);

        // then
        assertThat(answer).isEqualTo(2024.75d);
    }

    @Test
    @DisplayName("Самые частые ссылки")
    void mostLinks() {
        // given
        List<Log> test = new ArrayList<>();
        test.add(new Log(
            "20.38.50.37",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/emulation.gif",
            200,
            2642,
            "-",
            "Opera/10.33"
        ));
        test.add(new Log(
            "130.220.210.145",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/emulation.gif",
            200,
            1731,
            "-",
            "Opera/10.33"
        ));
        test.add(new Log(
            "121.8.89.31",
            "-",
            OffsetDateTime.MIN,
            "HEAD",
            "/analyzing%20Multi-lateral.svg",
            404,
            1552,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "80.91.33.133",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_1",
            302,
            2174,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "210.245.80.75",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_1",
            302,
            2174,
            "-",
            "Debian APT-HTTP/1.3 "
        ));
        test.add(new Log(
            "129.67.27.148",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_1",
            304,
            2174,
            "-",
            "Debian APT-HTTP/1.3 "
        ));
        test.add(new Log(
            "54.251.142.26",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            304,
            2174,
            "-",
            "Debian APT-HTTP/1.3 "
        ));
        test.add(new Log(
            "65.39.197.164",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            404,
            2174,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "213.239.192.210",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            200,
            2174,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "216.46.173.126",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            200,
            2174,
            "-",
            "Opera/10.46"
        ));

        // when
        Map<String, Integer> answer = StatAnalyser.mostCommonResources(test);

        // then
        assertThat(answer.size()).isEqualTo(3);
        assertThat(answer.get("/downloads/product_2")).isEqualTo(4);
        assertThat(answer.get("/downloads/product_1")).isEqualTo(3);
        assertThat(answer.get("/emulation.gif")).isEqualTo(2);
    }

    @Test
    @DisplayName("Самые частые коды ответов")
    void mostAnswers() {
        // given
        List<Log> test = new ArrayList<>();
        test.add(new Log(
            "20.38.50.37",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/emulation.gif",
            200,
            2642,
            "-",
            "Opera/10.33"
        ));
        test.add(new Log(
            "130.220.210.145",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/emulation.gif",
            200,
            1731,
            "-",
            "Opera/10.33"
        ));
        test.add(new Log(
            "121.8.89.31",
            "-",
            OffsetDateTime.MIN,
            "HEAD",
            "/analyzing%20Multi-lateral.svg",
            404,
            1552,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "80.91.33.133",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_1",
            304,
            2174,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "210.245.80.75",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_1",
            302,
            2174,
            "-",
            "Debian APT-HTTP/1.3 "
        ));
        test.add(new Log(
            "129.67.27.148",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_1",
            304,
            2174,
            "-",
            "Debian APT-HTTP/1.3 "
        ));
        test.add(new Log(
            "54.251.142.26",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            304,
            2174,
            "-",
            "Debian APT-HTTP/1.3 "
        ));
        test.add(new Log(
            "65.39.197.164",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            404,
            2174,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "213.239.192.210",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            200,
            2174,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "216.46.173.126",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            200,
            2174,
            "-",
            "Opera/10.46"
        ));

        // when
        Map<Integer, Integer> answer = StatAnalyser.mostCommonResponses(test);

        // then
        assertThat(answer.size()).isEqualTo(3);
        assertThat(answer.get(200)).isEqualTo(4);
        assertThat(answer.get(304)).isEqualTo(3);
        assertThat(answer.get(404)).isEqualTo(2);
    }

    @Test
    @DisplayName("Самые частые Юзер агенты")
    void mostUserAgents() {
        // given
        List<Log> test = new ArrayList<>();
        test.add(new Log(
            "20.38.50.37",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/emulation.gif",
            200,
            2642,
            "-",
            "Opera/10.33"
        ));
        test.add(new Log(
            "130.220.210.145",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/emulation.gif",
            200,
            1731,
            "-",
            "Opera/10.33"
        ));
        test.add(new Log(
            "121.8.89.31",
            "-",
            OffsetDateTime.MIN,
            "HEAD",
            "/analyzing%20Multi-lateral.svg",
            404,
            1552,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "80.91.33.133",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_1",
            304,
            2174,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "210.245.80.75",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_1",
            302,
            2174,
            "-",
            "Debian APT-HTTP/1.3"
        ));
        test.add(new Log(
            "129.67.27.148",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_1",
            304,
            2174,
            "-",
            "Debian APT-HTTP/1.3"
        ));
        test.add(new Log(
            "54.251.142.26",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            304,
            2174,
            "-",
            "Debian APT-HTTP/1.3"
        ));
        test.add(new Log(
            "65.39.197.164",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            404,
            2174,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "213.239.192.210",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            200,
            2174,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "216.46.173.126",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            200,
            2174,
            "-",
            "Opera/10.46"
        ));

        // when
        Map<String, Integer> answer = StatAnalyser.mostCommonUserAgents(test);

        // then
        assertThat(answer.size()).isEqualTo(3);
        assertThat(answer.get("Opera/10.46")).isEqualTo(5);
        assertThat(answer.get("Debian APT-HTTP/1.3")).isEqualTo(3);
        assertThat(answer.get("Opera/10.33")).isEqualTo(2);
    }

    @Test
    @DisplayName("Самые частые запросы")
    void mostRequests() {
        // given
        List<Log> test = new ArrayList<>();
        test.add(new Log(
            "20.38.50.37",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/emulation.gif",
            200,
            2642,
            "-",
            "Opera/10.33"
        ));
        test.add(new Log(
            "130.220.210.145",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/emulation.gif",
            200,
            1731,
            "-",
            "Opera/10.33"
        ));
        test.add(new Log(
            "121.8.89.31",
            "-",
            OffsetDateTime.MIN,
            "HEAD",
            "/analyzing%20Multi-lateral.svg",
            404,
            1552,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "80.91.33.133",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_1",
            304,
            2174,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "210.245.80.75",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_1",
            302,
            2174,
            "-",
            "Debian APT-HTTP/1.3"
        ));
        test.add(new Log(
            "129.67.27.148",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_1",
            304,
            2174,
            "-",
            "Debian APT-HTTP/1.3"
        ));
        test.add(new Log(
            "54.251.142.26",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            304,
            2174,
            "-",
            "Debian APT-HTTP/1.3"
        ));
        test.add(new Log(
            "65.39.197.164",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            404,
            2174,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "213.239.192.210",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            200,
            2174,
            "-",
            "Opera/10.46"
        ));
        test.add(new Log(
            "216.46.173.126",
            "-",
            OffsetDateTime.MIN,
            "GET",
            "/downloads/product_2",
            200,
            2174,
            "-",
            "Opera/10.46"
        ));

        // when
        Map<String, Integer> answer = StatAnalyser.mostCommonRequest(test);

        // then
        assertThat(answer.size()).isEqualTo(2);
        assertThat(answer.get("GET")).isEqualTo(9);
        assertThat(answer.get("HEAD")).isEqualTo(1);
    }
}

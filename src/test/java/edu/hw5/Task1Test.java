package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Корректное время")
    void correctTime() {
        // given
        List<String> test = new ArrayList<>();
        test.add("2022-03-12, 20:20 - 2022-03-12, 23:50");
        test.add("2022-05-11, 01:30 - 2022-05-11, 06:20");
        test.add("2022-04-01, 21:30 - 2022-04-02, 01:20");
        test.add("2022-04-01, 08:14 - 2022-04-01, 17:20");
        test.add("2022-03-22, 22:30 - 2022-03-23, 05:18");

        // when
        String answer = Task1.averageTime(test);

        // then
        assertThat(answer).isEqualTo("5ч 36м");
    }

    @Test
    @DisplayName("Некорректное время")
    void incorrectTime() {
        // given
        List<String> test = new ArrayList<>();
        test.add("2022-03-12, 20:20 - 2022-03-11, 23:50");
        test.add("2022-05-11, 01:30 - 2022-05-11, 06:20");
        test.add("2022-04-01, 21:30 - 2022-04-02, 01:20");
        test.add("2022-04-01, 08:14 - 2022-04-01, 17:20");
        test.add("2022-03-22, 22:30 - 2022-03-23, 05:18");

        // when
        String answer = Task1.averageTime(test);

        // then
        assertThat(answer).isEqualTo("Input returns negative answer");
    }

    @Test
    @DisplayName("Ошибка парсинга")
    void parsingException() {
        // given
        List<String> test = new ArrayList<>();
        test.add("2022-03-12, 20:20 - 2022-03-12, 25:50");
        test.add("2022-05-11, 01:30 - 2022-05-11, 06:20");
        test.add("2022-04-01, 21:30 - 2022-04-02, 01:20");
        test.add("2022-04-01, 08:14 - 2022-04-01, 17:20");
        test.add("2022-03-22, 22:30 - 2022-03-23, 05:18");

        // when
        String answer = Task1.averageTime(test);

        // then
        assertThat(answer).isEqualTo("Input can't be parsed");
    }
}

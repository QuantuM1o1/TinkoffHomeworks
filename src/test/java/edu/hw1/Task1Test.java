package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Одна минута")
    void oneMinute() {
        // given
        String test = "01:00";

        // when
        int answer = Task1.minutesToSeconds(test);

        // then
        assertThat(answer).isEqualTo(60);
    }
    @Test
    @DisplayName("Случайное число")
    void randomNumber() {
        // given
        String test = "13:56";

        // when
        int answer = Task1.minutesToSeconds(test);

        // then
        assertThat(answer).isEqualTo(836);
    }
    @Test
    @DisplayName("Больше 59ти секунд")
    void sixtySeconds() {
        // given
        String test = "10:60";

        // when
        int answer = Task1.minutesToSeconds(test);

        // then
        assertThat(answer).isEqualTo(-1);
    }
    @Test
    @DisplayName("Больше двух цифр в минутах")
    void threeNumbers() {
        // given
        String test = "451:10";

        // when
        int answer = Task1.minutesToSeconds(test);

        // then
        assertThat(answer).isEqualTo(27070);
    }
    @Test
    @DisplayName("Отрицательное число минут")
    void negativeMinutes() {
        // given
        String test = "-51:10";

        // when
        int answer = Task1.minutesToSeconds(test);

        // then
        assertThat(answer)
            .isEqualTo(-1);
    }
}

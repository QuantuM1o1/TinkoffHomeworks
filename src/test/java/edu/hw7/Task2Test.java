package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Параллельный факториал")
    void parallelFactorial() {
        // given
        long test = 20L;

        // when
        long answer = Task2.factorial(test);

        // then
        assertThat(answer).isEqualTo(2_432_902_008_176_640_000L);
    }

    @Test
    @DisplayName("Факториал от нуля")
    void zeroFactorial() {
        // given
        long test = 0L;

        // when
        long answer = Task2.factorial(test);

        // then
        assertThat(answer).isEqualTo(1L);
    }

    @Test
    @DisplayName("Факториал отрицательного числа")
    void negativeNumberFactorial() {
        // given
        long test = -1L;

        // when
        long answer = Task2.factorial(test);

        // then
        assertThat(answer).isEqualTo(-1L);
    }

    @Test
    @DisplayName("Факториал слишком большого числа")
    void bigNumber() {
        // given
        long test = 21L;

        // when
        long answer = Task2.factorial(test);

        // then
        assertThat(answer).isEqualTo(-1L);
    }
}

package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("4 цифры")
    void fourDigits() {
        // given
        int testNumber = 4666;

        // when
        int answer = Task2.countDigits(testNumber);

        // then
        assertThat(answer).isEqualTo(4);
    }
    @Test
    @DisplayName("3 цифры")
    void threeDigits() {
        // given
        int testNumber = 544;

        // when
        int answer = Task2.countDigits(testNumber);

        // then
        assertThat(answer).isEqualTo(3);
    }
    @Test
    @DisplayName("1 цифра")
    void oneDigit() {
        // given
        int testNumber = 0;

        // when
        int answer = Task2.countDigits(testNumber);

        // then
        assertThat(answer).isEqualTo(1);
    }
    @Test
    @DisplayName("Отрицательное число, 2 цифры")
    void negativeNumber() {
        // given
        int testNumber = -17;

        // when
        int answer = Task2.countDigits(testNumber);

        // then
        assertThat(answer).isEqualTo(2);
    }
}

package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("6174")
    void sixtyOneSeventyFour() {
        // given
        int test = 6174;

        // when
        int answer = Task6.countK(test);

        // then
        assertThat(answer).isEqualTo(0);
    }
    @Test
    @DisplayName("Число, которое даёт 999 после манипуляции")
    void answerIs999() {
        // given
        int test = 1222;

        // when
        int answer = Task6.countK(test);

        // then
        // 1222 -> 999 (добавляем ноль 9990) -> 8991 -> 8082 -> 8532 -> 6174
        assertThat(answer).isEqualTo(5);
    }
    @Test
    @DisplayName("3 шага")
    void threeSteps() {
        // given
        int test = 3524;

        // when
        int answer = Task6.countK(test);

        // then
        assertThat(answer).isEqualTo(3);
    }
    @Test
    @DisplayName("7 шагов")
    void sevenSteps() {
        // given
        int test = 6175;

        // when
        int answer = Task6.countK(test);

        // then
        assertThat(answer).isEqualTo(7);
    }
    @Test
    @DisplayName("Меньше знаков")
    void lessThan4() {
        // given
        int test = 547;

        // when
        int answer = Task6.countK(test);

        // then
        assertThat(answer).isEqualTo(-1);
    }
    @Test
    @DisplayName("Больше знаков")
    void moreThan4() {
        // given
        int test = 10000;

        // when
        int answer = Task6.countK(test);

        // then
        assertThat(answer).isEqualTo(-1);
    }
    @Test
    @DisplayName("1000")
    void oneThousand() {
        // given
        int test = 1000;

        // when
        int answer = Task6.countK(test);

        // then
        assertThat(answer).isEqualTo(-1);
    }
    @Test
    @DisplayName("Одинаковые цифры")
    void allDigitsAreEqual() {
        // given
        int test = 7777;

        // when
        int answer = Task6.countK(test);

        // then
        assertThat(answer).isEqualTo(-1);
    }
}

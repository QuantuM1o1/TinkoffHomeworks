package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Arrays.array;

public class Task2Test {
    @Test
    @DisplayName("Стандартное поведение")
    void standard() {
        // given
        String test = "((())())(()(()()))";

        // when
        String[] answer = Task2.clusterize(test);

        // then
        assertThat(answer).isEqualTo(array("((())())", "(()(()()))"));
    }

    @Test
    @DisplayName("Лишняя закрывающая")
    void extraCloseBracket() {
        // given
        String test = "((())())(()(()())))";

        // when
        String[] answer = Task2.clusterize(test);

        // then
        assertThat(answer).isEqualTo(array("Check input"));
    }

    @Test
    @DisplayName("Лишняя открывающая")
    void extraOpenBrackets() {
        // given
        String test = "((())()()(()(()()))";

        // when
        String[] answer = Task2.clusterize(test);

        // then
        assertThat(answer).isEqualTo(array("Check input"));
    }

    @Test
    @DisplayName("Закрывающая в начале")
    void startsWithClosingBracket() {
        // given
        String test = ")((())())(()(()()))";

        // when
        String[] answer = Task2.clusterize(test);

        // then
        assertThat(answer).isEqualTo(array("Check input"));
    }

    @Test
    @DisplayName("Символ")
    void symbol() {
        // given
        String test = "((())())(a()(()()))";

        // when
        String[] answer = Task2.clusterize(test);

        // then
        assertThat(answer).isEqualTo(array("Check input"));
    }
}

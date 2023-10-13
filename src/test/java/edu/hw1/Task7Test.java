package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Степень двойки влево на один")
    void twoPoweredLeft() {
        // given
        int test = 16;
        int testShift = 1;

        // when
        int answer = Task7.rotateLeft(test, testShift);

        // then
        assertThat(answer).isEqualTo(1);
    }
    @Test
    @DisplayName("Число влево")
    void numberLeft() {
        // given
        int test = 17;
        int testShift = 2;

        // when
        int answer = Task7.rotateLeft(test, testShift);

        // then
        assertThat(answer).isEqualTo(6);
    }
    @Test
    @DisplayName("Число влево не изменяется")
    void unchanged() {
        // given
        int test = 7;
        int testShift = 5;

        // when
        int answer = Task7.rotateLeft(test, testShift);

        // then
        assertThat(answer).isEqualTo(7);
    }
    @Test
    @DisplayName("Ноль влево")
    void number0Left() {
        // given
        int test = 0;
        int testShift = 5;

        // when
        int answer = Task7.rotateLeft(test, testShift);

        // then
        assertThat(answer).isEqualTo(0);
    }
    @Test
    @DisplayName("Единица влево")
    void number1Left() {
        // given
        int test = 1;
        int testShift = 5;

        // when
        int answer = Task7.rotateLeft(test, testShift);

        // then
        assertThat(answer).isEqualTo(1);
    }
    @Test
    @DisplayName("Максимальный инт влево")
    void maxIntLeft() {
        // given
        int test = Integer.MAX_VALUE;
        int testShift = 3;

        // when
        int answer = Task7.rotateLeft(test, testShift);

        // then
        assertThat(answer).isEqualTo(Integer.MAX_VALUE);
    }
    @Test
    @DisplayName("Степень двойки вправо на один")
    void twoPoweredRight() {
        // given
        int test = 8;
        int testShift = 1;

        // when
        int answer = Task7.rotateRight(test, testShift);

        // then
        assertThat(answer).isEqualTo(4);
    }
    @Test
    @DisplayName("Единица вправо")
    void number1Right() {
        // given
        int test = 1;
        int testShift = 5;

        // when
        int answer = Task7.rotateRight(test, testShift);

        // then
        assertThat(answer).isEqualTo(1);
    }
    @Test
    @DisplayName("Ноль вправо")
    void number0Right() {
        // given
        int test = 0;
        int testShift = 5;

        // when
        int answer = Task7.rotateRight(test, testShift);

        // then
        assertThat(answer).isEqualTo(0);
    }
    @Test
    @DisplayName("Максимальный инт вправо")
    void maxIntRight() {
        // given
        int test = Integer.MAX_VALUE;
        int testShift = 5;

        // when
        int answer = Task7.rotateRight(test, testShift);

        // then
        assertThat(answer).isEqualTo(Integer.MAX_VALUE);
    }
    @Test
    @DisplayName("Число вправо")
    void numberRight() {
        // given
        int test = 10;
        int testShift = 3;

        // when
        int answer = Task7.rotateRight(test, testShift);

        // then
        assertThat(answer).isEqualTo(5);
    }
}

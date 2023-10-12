package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    @DisplayName("Четное количество цифр, true")
    void evenAndTrue() {
        // given
        int test = 11211230;

        // when
        boolean answer = Task5.isPalindromeDescendant(test);

        // then
        assertTrue(answer);
    }
    @Test
    @DisplayName("Четное количество цифр, сам ответ нечетный")
    void unevenAnswer() {
        // given
        int test = 123312;

        // when
        boolean answer = Task5.isPalindromeDescendant(test);

        // then
        assertTrue(answer);
    }
    @Test
    @DisplayName("Четное количество цифр, сумма цифр больше 9ти, false")
    void evenAndFalse() {
        // given
        int test = 9765;

        // when
        boolean answer = Task5.isPalindromeDescendant(test);

        // then
        assertFalse(answer);
    }
    @Test
    @DisplayName("Четное количество цифр, сумма цифр больше 9ти, true")
    void evenOverAndTrue() {
        // given
        int test = 793301;

        // when
        boolean answer = Task5.isPalindromeDescendant(test);

        // then
        assertTrue(answer);
    }
}

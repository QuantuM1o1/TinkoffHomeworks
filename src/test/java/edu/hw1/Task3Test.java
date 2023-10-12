package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test
    @DisplayName("Массивы для True")
    void trueAnswer() {
        // given
        int[] a1 = {3, 1};
        int[] a2 = {4, 0};

        // when
        boolean answer = Task3.isNestable(a1, a2);

        // then
        assertTrue(answer);
    }
    @Test
    @DisplayName("Массивы для False")
    void falseAnswer() {
        // given
        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {2, 3};

        // when
        boolean answer = Task3.isNestable(a1, a2);

        // then
        assertFalse(answer);
    }
    @Test
    @DisplayName("Пустой массив")
    void noArray() {
        // given
        int[] a1 = {};
        int[] a2 = {2, 3};

        // when
        boolean answer = Task3.isNestable(a1, a2);

        // then
        assertFalse(answer);
    }
    @Test
    @DisplayName("Первый массив из одного элемента, но подходит по условию")
    void oneElementArray() {
        // given
        int[] a1 = {7};
        int[] a2 = {2, 9};

        // when
        boolean answer = Task3.isNestable(a1, a2);

        // then
        assertTrue(answer);
    }
}

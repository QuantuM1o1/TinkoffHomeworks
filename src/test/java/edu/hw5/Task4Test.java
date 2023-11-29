package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {
    @Test
    @DisplayName("Неправильный пароль")
    void badPassword() {
        // given
        String test = "password";

        // when
        boolean answer = Task4.passwordChecker(test);

        // then
        assertFalse(answer);
    }

    @Test
    @DisplayName("Правильный пароль")
    void goodPassword() {
        // given
        String test = "password$letsgo";

        // when
        boolean answer = Task4.passwordChecker(test);

        // then
        assertTrue(answer);
    }

    @Test
    @DisplayName("Один правильный символ")
    void oneSymbol() {
        // given
        String test = "&";

        // when
        boolean answer = Task4.passwordChecker(test);

        // then
        assertTrue(answer);
    }

    @Test
    @DisplayName("Все правильные символы")
    void allSymbols() {
        // given
        String test = "~!@#$%^&*|";

        // when
        boolean answer = Task4.passwordChecker(test);

        // then
        assertTrue(answer);
    }
}

package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerInputTest {
    @Test
    @DisplayName("Тест длины ввода")
    void inputWrongSize() {
        // given
        Player player = new Player();
        String input = "ва";

        // when
        boolean answer = player.validateInput(input);

        // then
        assertFalse(answer);
    }
    @Test
    @DisplayName("Тест латиницы")
    void inputNotCyrillic() {
        // given
        Player player = new Player();
        String input = "t";

        // when
        boolean answer = player.validateInput(input);

        // then
        assertFalse(answer);
    }

    @Test
    @DisplayName("Правильный ввод")
    void inputCorrect() {
        // given
        Player player = new Player();
        String input = "а";

        // when
        boolean answer = player.validateInput(input);

        // then
        assertTrue(answer);
    }
}

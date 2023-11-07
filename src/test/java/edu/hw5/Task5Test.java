package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    @DisplayName("Правильные номера")
    void correctPlates() {
        // given
        String test1 = "А123ВЕ777";
        String test2 = "О777ОО177";

        // when
        boolean answer1 = Task5.carPlateChecker(test1);
        boolean answer2 = Task5.carPlateChecker(test2);

        // then
        assertTrue(answer1);
        assertTrue(answer2);
    }

    @Test
    @DisplayName("Неправильные номера")
    void incorrectPlates() {
        // given
        String test1 = "123АВЕ777";
        String test2 = "А123ВГ77";
        String test3= "А123ВЕ7777";

        // when
        boolean answer1 = Task5.carPlateChecker(test1);
        boolean answer2 = Task5.carPlateChecker(test2);
        boolean answer3 = Task5.carPlateChecker(test3);

        // then
        assertFalse(answer1);
        assertFalse(answer2);
        assertFalse(answer3);
    }
}

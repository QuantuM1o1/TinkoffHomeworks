package edu.hw5;

import edu.hw5.Task7.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {
    @Test
    @DisplayName("Первое условие true")
    void firstConTrue() {
        // given
        String test1 = "010";
        String test2 = "11011";
        String test3= "000101010";

        // when
        boolean answer1 = First.threeSymbolsThirdOneIs0(test1);
        boolean answer2 = First.threeSymbolsThirdOneIs0(test2);
        boolean answer3 = First.threeSymbolsThirdOneIs0(test3);

        // then
        assertTrue(answer1);
        assertTrue(answer2);
        assertTrue(answer3);
    }

    @Test
    @DisplayName("Первое условие false")
    void firstConFalse() {
        // given
        String test1 = "01";
        String test2 = "120";
        String test3= "001000";

        // when
        boolean answer1 = First.threeSymbolsThirdOneIs0(test1);
        boolean answer2 = First.threeSymbolsThirdOneIs0(test2);
        boolean answer3 = First.threeSymbolsThirdOneIs0(test3);

        // then
        assertFalse(answer1);
        assertFalse(answer2);
        assertFalse(answer3);
    }

    @Test
    @DisplayName("Второе условие true")
    void secondConTrue() {
        // given
        String test1 = "010";
        String test2 = "11011";
        String test3= "000101010";

        // when
        boolean answer1 = Second.firstAndLastAreEqual(test1);
        boolean answer2 = Second.firstAndLastAreEqual(test2);
        boolean answer3 = Second.firstAndLastAreEqual(test3);

        // then
        assertTrue(answer1);
        assertTrue(answer2);
        assertTrue(answer3);
    }

    @Test
    @DisplayName("Второе условие false")
    void secondConFalse() {
        // given
        String test1 = "01";
        String test2 = "120";
        String test3= "0010001";

        // when
        boolean answer1 = Second.firstAndLastAreEqual(test1);
        boolean answer2 = Second.firstAndLastAreEqual(test2);
        boolean answer3 = Second.firstAndLastAreEqual(test3);

        // then
        assertFalse(answer1);
        assertFalse(answer2);
        assertFalse(answer3);
    }

    @Test
    @DisplayName("Третье условие true")
    void thirdConTrue() {
        // given
        String test1 = "010";
        String test2 = "110";
        String test3= "000";

        // when
        boolean answer1 = Third.lengthIs1to3(test1);
        boolean answer2 = Third.lengthIs1to3(test2);
        boolean answer3 = Third.lengthIs1to3(test3);

        // then
        assertTrue(answer1);
        assertTrue(answer2);
        assertTrue(answer3);
    }

    @Test
    @DisplayName("Третье условие false")
    void thirdConFalse() {
        // given
        String test1 = "";
        String test2 = "120";
        String test3= "0010001";

        // when
        boolean answer1 = Third.lengthIs1to3(test1);
        boolean answer2 = Third.lengthIs1to3(test2);
        boolean answer3 = Third.lengthIs1to3(test3);

        // then
        assertFalse(answer1);
        assertFalse(answer2);
        assertFalse(answer3);
    }
}

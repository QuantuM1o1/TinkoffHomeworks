package edu.hw5;

import edu.hw5.Task8.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {
    @Test
    @DisplayName("Первое условие true")
    void firstConTrue() {
        // given
        String test1 = "010";
        String test2 = "11011";
        String test3= "000101010";

        // when
        boolean answer1 = First.oddLength(test1);
        boolean answer2 = First.oddLength(test2);
        boolean answer3 = First.oddLength(test3);

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
        boolean answer1 = First.oddLength(test1);
        boolean answer2 = First.oddLength(test2);
        boolean answer3 = First.oddLength(test3);

        // then
        assertFalse(answer1);
        assertFalse(answer2);
        assertFalse(answer3);
    }

    @Test
    @DisplayName("Второе условие true")
    void secondConTrue() {
        // given
        String test1 = "0";
        String test2 = "011";
        String test3 = "10";
        String test4 = "11";
        String test5 = "101011";

        // when
        boolean answer1 = Second.startsWith0andOddOr1andEven(test1);
        boolean answer2 = Second.startsWith0andOddOr1andEven(test2);
        boolean answer3 = Second.startsWith0andOddOr1andEven(test3);
        boolean answer4 = Second.startsWith0andOddOr1andEven(test4);
        boolean answer5 = Second.startsWith0andOddOr1andEven(test5);

        // then
        assertTrue(answer1);
        assertTrue(answer2);
        assertTrue(answer3);
        assertTrue(answer4);
        assertTrue(answer5);
    }

    @Test
    @DisplayName("Второе условие false")
    void secondConFalse() {
        // given
        String test1 = "12";
        String test2 = "00";
        String test3 = "01";
        String test4 = "111";
        String test5 = "101";

        // when
        boolean answer1 = Second.startsWith0andOddOr1andEven(test1);
        boolean answer2 = Second.startsWith0andOddOr1andEven(test2);
        boolean answer3 = Second.startsWith0andOddOr1andEven(test3);
        boolean answer4 = Second.startsWith0andOddOr1andEven(test4);
        boolean answer5 = Second.startsWith0andOddOr1andEven(test5);

        // then
        assertFalse(answer1);
        assertFalse(answer2);
        assertFalse(answer3);
        assertFalse(answer4);
        assertFalse(answer5);
    }

    @Test
    @DisplayName("Третье условие true")
    void thirdConTrue() {
        // given
        String test1 = "000";
        String test2 = "1";
        String test3 = "101011110110111101110";
        String test4 = "11000";
        String test5 = "000111111";

        // when
        boolean answer1 = Third.threeZeros(test1);
        boolean answer2 = Third.threeZeros(test2);
        boolean answer3 = Third.threeZeros(test3);
        boolean answer4 = Third.threeZeros(test4);
        boolean answer5 = Third.threeZeros(test5);

        // then
        assertTrue(answer1);
        assertTrue(answer2);
        assertTrue(answer3);
        assertTrue(answer4);
        assertTrue(answer5);
    }

    @Test
    @DisplayName("Третье условие false")
    void thirdConFalse() {
        // given
        String test1 = "12000";
        String test2 = "1011110111";
        String test3 = "00";
        String test4 = "10101";
        String test5 = "101011101010111";

        // when
        boolean answer1 = Third.threeZeros(test1);
        boolean answer2 = Third.threeZeros(test2);
        boolean answer3 = Third.threeZeros(test3);
        boolean answer4 = Third.threeZeros(test4);
        boolean answer5 = Third.threeZeros(test5);

        // then
        assertFalse(answer1);
        assertFalse(answer2);
        assertFalse(answer3);
        assertFalse(answer4);
        assertFalse(answer5);
    }

    @Test
    @DisplayName("Четвертое условие true")
    void fourthConTrue() {
        // given
        String test1 = "000";
        String test2 = "1";
        String test3 = "101011110110111101110";
        String test4 = "11000";
        String test5 = "000111111";

        // when
        boolean answer1 = Fourth.neither11nor111(test1);
        boolean answer2 = Fourth.neither11nor111(test2);
        boolean answer3 = Fourth.neither11nor111(test3);
        boolean answer4 = Fourth.neither11nor111(test4);
        boolean answer5 = Fourth.neither11nor111(test5);

        // then
        assertTrue(answer1);
        assertTrue(answer2);
        assertTrue(answer3);
        assertTrue(answer4);
        assertTrue(answer5);
    }

    @Test
    @DisplayName("Четвертое условие false")
    void fourthConFalse() {
        // given
        String test1 = "120";
        String test2 = "111";
        String test3 = "11";

        // when
        boolean answer1 = Fourth.neither11nor111(test1);
        boolean answer2 = Fourth.neither11nor111(test2);
        boolean answer3 = Fourth.neither11nor111(test3);

        // then
        assertFalse(answer1);
        assertFalse(answer2);
        assertFalse(answer3);
    }

    @Test
    @DisplayName("Пятое условие true")
    void fifthConTrue() {
        // given
        String test1 = "1";
        String test2 = "10";
        String test3 = "101";
        String test4 = "111";
        String test5 = "11101";
        String test6 = "10111";

        // when
        boolean answer1 = Fifth.everyOddIs1(test1);
        boolean answer2 = Fifth.everyOddIs1(test2);
        boolean answer3 = Fifth.everyOddIs1(test3);
        boolean answer4 = Fifth.everyOddIs1(test4);
        boolean answer5 = Fifth.everyOddIs1(test5);
        boolean answer6 = Fifth.everyOddIs1(test6);

        // then
        assertTrue(answer1);
        assertTrue(answer2);
        assertTrue(answer3);
        assertTrue(answer4);
        assertTrue(answer5);
        assertTrue(answer6);
    }

    @Test
    @DisplayName("Пятое условие false")
    void fifthConFalse() {
        // given
        String test1 = "0";
        String test2 = "100";
        String test3 = "110";
        String test4 = "10110";
        String test5 = "1010110";

        // when
        boolean answer1 = Fifth.everyOddIs1(test1);
        boolean answer2 = Fifth.everyOddIs1(test2);
        boolean answer3 = Fifth.everyOddIs1(test3);
        boolean answer4 = Fifth.everyOddIs1(test4);
        boolean answer5 = Fifth.everyOddIs1(test5);

        // then
        assertFalse(answer1);
        assertFalse(answer2);
        assertFalse(answer3);
        assertFalse(answer4);
        assertFalse(answer5);
    }

    @Test
    @DisplayName("Шестое условие true")
    void sixthConTrue() {
        // given
        String test1 = "100";
        String test2 = "010";
        String test3 = "001";
        String test4 = "1000";
        String test5 = "0100";
        String test6 = "00100";

        // when
        boolean answer1 = Sixth.min2ZerosAndMax1One(test1);
        boolean answer2 = Sixth.min2ZerosAndMax1One(test2);
        boolean answer3 = Sixth.min2ZerosAndMax1One(test3);
        boolean answer4 = Sixth.min2ZerosAndMax1One(test4);
        boolean answer5 = Sixth.min2ZerosAndMax1One(test5);
        boolean answer6 = Sixth.min2ZerosAndMax1One(test6);

        // then
        assertTrue(answer1);
        assertTrue(answer2);
        assertTrue(answer3);
        assertTrue(answer4);
        assertTrue(answer5);
        assertTrue(answer6);
    }

    @Test
    @DisplayName("Шестое условие false")
    void sixthConFalse() {
        // given
        String test1 = "0";
        String test2 = "1010";
        String test3 = "110";
        String test4 = "10110";
        String test5 = "1010110";

        // when
        boolean answer1 = Sixth.min2ZerosAndMax1One(test1);
        boolean answer2 = Sixth.min2ZerosAndMax1One(test2);
        boolean answer3 = Sixth.min2ZerosAndMax1One(test3);
        boolean answer4 = Sixth.min2ZerosAndMax1One(test4);
        boolean answer5 = Sixth.min2ZerosAndMax1One(test5);

        // then
        assertFalse(answer1);
        assertFalse(answer2);
        assertFalse(answer3);
        assertFalse(answer4);
        assertFalse(answer5);
    }

    @Test
    @DisplayName("Седьмое условие true")
    void seventhConTrue() {
        // given
        String test1 = "100";
        String test2 = "010";
        String test3 = "001";
        String test4 = "1000";
        String test5 = "0100";
        String test6 = "00100";

        // when
        boolean answer1 = Seventh.noConsecutive1s(test1);
        boolean answer2 = Seventh.noConsecutive1s(test2);
        boolean answer3 = Seventh.noConsecutive1s(test3);
        boolean answer4 = Seventh.noConsecutive1s(test4);
        boolean answer5 = Seventh.noConsecutive1s(test5);
        boolean answer6 = Seventh.noConsecutive1s(test6);

        // then
        assertTrue(answer1);
        assertTrue(answer2);
        assertTrue(answer3);
        assertTrue(answer4);
        assertTrue(answer5);
        assertTrue(answer6);
    }

    @Test
    @DisplayName("Седьмое условие false")
    void seventhConFalse() {
        // given
        String test1 = "011";
        String test2 = "10110";
        String test3 = "110";
        String test4 = "10110";
        String test5 = "1010110";

        // when
        boolean answer1 = Seventh.noConsecutive1s(test1);
        boolean answer2 = Seventh.noConsecutive1s(test2);
        boolean answer3 = Seventh.noConsecutive1s(test3);
        boolean answer4 = Seventh.noConsecutive1s(test4);
        boolean answer5 = Seventh.noConsecutive1s(test5);

        // then
        assertFalse(answer1);
        assertFalse(answer2);
        assertFalse(answer3);
        assertFalse(answer4);
        assertFalse(answer5);
    }
}

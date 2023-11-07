package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {
    @Test
    @DisplayName("Является подпоследовательностью")
    void isSubsequence() {
        // given
        String test1 = "ACE";
        String t1 = "ABCDEF";
        String test2 = "abc";
        String t2 = "achfdbaabgabcaabg";
        String test3= "13аге%0$@dfis\\ac";
        String t3= "123апге%60$@kkdfjis\\abc";

        // when
        boolean answer1 = Task6.subsequenceChecker(test1, t1);
        boolean answer2 = Task6.subsequenceChecker(test2, t2);
        boolean answer3 = Task6.subsequenceChecker(test3, t3);

        // then
        assertTrue(answer1);
        assertTrue(answer2);
        assertTrue(answer3);
    }

    @Test
    @DisplayName("Не является подпоследовательностью")
    void isntSubsequence() {
        // given
        String test1 = "ACE";
        String t1 = "ABCDF";
        String test2 = "abc";
        String t2 = "achfdaagacaabg";
        String test3= "13аге%0$@dfis\\ac";
        String t3= "123апге%60$kkdfjis\\abc";

        // when
        boolean answer1 = Task6.subsequenceChecker(test1, t1);
        boolean answer2 = Task6.subsequenceChecker(test2, t2);
        boolean answer3 = Task6.subsequenceChecker(test3, t3);

        // then
        assertFalse(answer1);
        assertFalse(answer2);
        assertFalse(answer3);
    }
}

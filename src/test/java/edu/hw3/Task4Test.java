package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("1999")
    void nineteenNinetyNine() {
        // given
        int test = 1999;

        // when
        String answer = Task4.convertToRoman(test);

        // then
        assertThat(answer).isEqualTo("MCMXCIX");
    }

    @Test
    @DisplayName("0")
    void zero() {
        // given
        int test = 0;

        // when
        String answer = Task4.convertToRoman(test);

        // then
        assertThat(answer).isEqualTo("Check input");
    }

    @Test
    @DisplayName("-1")
    void negativeOne() {
        // given
        int test = -1;

        // when
        String answer = Task4.convertToRoman(test);

        // then
        assertThat(answer).isEqualTo("Check input");
    }

    @Test
    @DisplayName("1")
    void one() {
        // given
        int test = 1;

        // when
        String answer = Task4.convertToRoman(test);

        // then
        assertThat(answer).isEqualTo("I");
    }

    @Test
    @DisplayName("4000")
    void fourThousands() {
        // given
        int test = 4000;

        // when
        String answer = Task4.convertToRoman(test);

        // then
        assertThat(answer).isEqualTo("Check input");
    }

    @Test
    @DisplayName("3999")
    void maxNumber() {
        // given
        int test = 3999;

        // when
        String answer = Task4.convertToRoman(test);

        // then
        assertThat(answer).isEqualTo("MMMCMXCIX");
    }
}

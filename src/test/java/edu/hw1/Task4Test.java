package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("123456")
    void oneToSix() {
        // given
        String test = "123456";

        // when
        String answer = Task4.fixString(test);

        // then
        assertThat(answer).isEqualTo("214365");
    }
    @Test
    @DisplayName("Нечётное количество символов в строке")
    void oddNumberOfChars() {
        // given
        String test = "badce";

        // when
        String answer = Task4.fixString(test);

        // then
        assertThat(answer).isEqualTo("abcde");
    }
}

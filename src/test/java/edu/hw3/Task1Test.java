package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Hello, world!")
    void helloWorld() {
        // given
        String test = "Hello, world!";

        // when
        String answer = Task1.atbash(test);

        // then
        assertThat(answer).isEqualTo("Svool, dliow!");
    }

    @Test
    @DisplayName("Различные символы")
    void differentSymbols() {
        // given
        String test = "Different символы !№;%:?*()_-=+*/,.";

        // when
        String answer = Task1.atbash(test);

        // then
        assertThat(answer).isEqualTo("Wruuvivmg символы !№;%:?*()_-=+*/,.");
    }
}

package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Одноядерная программа")
    void oneThread() {
        // given
        int test = 100_000_000;

        // when
        double answer = Task4.singleThreadPi(test);

        // then
        assertThat(answer).isBetween(3.13D, 3.15D);
    }

    @Test
    @DisplayName("Многоядерная программа")
    void multipleThreads() {
        // given
        int test = 100_000_000;
        int numberOfThreads = 4;

        // when
        double answer = Task4.multipleThreadsPi(test, numberOfThreads);

        // then
        assertThat(answer).isBetween(3.13D, 3.15D);
    }
}

package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test
{
    @Test
    @DisplayName("Массив строк")
    void strings() {
        // given
        String[] test = {"this", "and", "that", "and"};

        // when
        String[] answer = Task3.freqDict(test);

        // then
        assertThat(answer).containsOnly("that: 1", "and: 2", "this: 1");
    }

    @Test
    @DisplayName("Массив интов")
    void integers() {
        // given
        Integer[] test = {1, 17, 1, 3};

        // when
        String[] answer = Task3.freqDict(test);

        // then
        assertThat(answer).containsOnly("1: 2", "17: 1", "3: 1");
    }

    @Test
    @DisplayName("Массив дабл значений")
    void doubles() {
        // given
        Double[] test = {1.17D, 17.3D, 1.17D, 3.2D};

        // when
        String[] answer = Task3.freqDict(test);

        // then
        assertThat(answer).containsOnly("1.17: 2", "17.3: 1", "3.2: 1");
    }

    @Test
    @DisplayName("Массив булеан значений")
    void booleans() {
        // given
        Boolean[] test = {true, false, true, true};

        // when
        String[] answer = Task3.freqDict(test);

        // then
        assertThat(answer).containsOnly("true: 3", "false: 1");
    }

    @Test
    @DisplayName("Массив чаров")
    void characters() {
        // given
        Character[] test = {'c', 'с', 'c', 'c'};

        // when
        String[] answer = Task3.freqDict(test);

        // then
        assertThat(answer).containsOnly("c: 3", "с: 1");
    }
}

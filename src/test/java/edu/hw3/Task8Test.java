package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Проверка интов")
    void intReversed() {
        // given
        Iterator<Integer> iterator = new Task8.BackwardIterator<>(List.of(1,2,3));
        int[] answer = new int[3];
        int i = 0;

        // when
        while (iterator.hasNext()) {
            answer[i] = iterator.next();
            i++;
        }

        // then
        assertThat(answer[0]).isEqualTo(3);
    }

    @Test
    @DisplayName("Проверка строк")
    void stringReversed() {
        // given
        Iterator<String> iterator = new Task8.BackwardIterator<>(List.of("a", "b", "c"));
        String[] answer = new String[3];
        int i = 0;

        // when
        while (iterator.hasNext()) {
            answer[i] = iterator.next();
            i++;
        }

        // then
        assertThat(answer[0]).isEqualTo("c");
    }
}

package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("null элемент")
    void helloWorld() {
        // given
        TreeMap<String, String> tree = Task7.nullTree();

        // when
        tree.put(null, "test");

        // then
        assertThat(tree.containsKey(null)).isTrue();
    }
}

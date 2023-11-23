package edu.hw7;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Многопоточный инкремент")
    void atomicIncrement() {
        // given
        int value = 20_000;

        // when
        List<Thread> threadList = Stream.generate(() -> new Thread(Task1::increment))
            .limit(value)
            .toList();
        threadList.forEach(Thread::start);
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // then
        assertThat(Task1.value()).isEqualTo(value);
    }
}

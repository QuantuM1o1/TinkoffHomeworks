package edu.hw8;

import edu.hw8.Task2.FixedThreadPool;
import edu.hw8.Task2.ThreadPool;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Подсчёт чисел Фибоначи на одном потоке")
    void oneThread() {
        // given
        int numberOfThreads = 1;
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);
        fibonacci.add(1);
        int limit = 47;
        Runnable task = () -> {
            for (int i = 2; i <= limit; i++) {
                fibonacci.add(fibonacci.get(i-2) + fibonacci.get(i-1));
            }
        };

        // when
        try (ThreadPool pool = FixedThreadPool.create(numberOfThreads)) {
            pool.execute(task);
            pool.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // then
        assertThat(fibonacci.get(2)).isEqualTo(1);
        assertThat(fibonacci.get(10)).isEqualTo(55);
    }

    @Test
    @DisplayName("Подсчёт чисел Фибоначи на нескольких потоках")
    void multiThreading() {
        // given
        int numberOfThreads = 4;
        List<List<Integer>> fibonacci = new ArrayList<>();
        fibonacci.add(new ArrayList<>());
        fibonacci.add(new ArrayList<>());
        fibonacci.add(new ArrayList<>());
        fibonacci.add(new ArrayList<>());
        fibonacci.get(0).add(0);
        fibonacci.get(0).add(1);
        fibonacci.get(1).add(0);
        fibonacci.get(1).add(1);
        fibonacci.get(2).add(0);
        fibonacci.get(2).add(1);
        fibonacci.get(3).add(0);
        fibonacci.get(3).add(1);
        int limit = 47;
        List<Runnable> taskList = new ArrayList<>();
        for (int j = 0; j < numberOfThreads; j++) {
            int finalJ = j;
            taskList.add(() -> {
                for (int i = 2; i <= limit; i++) {
                    fibonacci.get(finalJ).add(fibonacci.get(finalJ).get(i-2) + fibonacci.get(finalJ).get(i-1));
                }
            });
        }

        // when
        try (ThreadPool pool = FixedThreadPool.create(numberOfThreads)) {
            for (Runnable task : taskList) {
                pool.execute(task);
            }
            pool.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // then
        assertThat(fibonacci.get(0))
            .isEqualTo(fibonacci.get(1))
            .isEqualTo(fibonacci.get(2))
            .isEqualTo(fibonacci.get(3));
    }
}

package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Несколько пятниц")
    void multipleFridays() {
        // given
        int test = 1925;

        // when
        List<LocalDate> answer = Task2.allFridays13thOfTheYear(test);

        // then
        assertThat(answer.size()).isEqualTo(3);
        assertThat(answer.get(0).toString()).isEqualTo("1925-02-13");
        assertThat(answer.get(1).toString()).isEqualTo("1925-03-13");
        assertThat(answer.get(2).toString()).isEqualTo("1925-11-13");
    }

    @Test
    @DisplayName("Одна пятница")
    void singleFriday() {
        // given
        int test = 1983;

        // when
        List<LocalDate> answer = Task2.allFridays13thOfTheYear(test);

        // then
        assertThat(answer.size()).isEqualTo(1);
        assertThat(answer.get(0).toString()).isEqualTo("1983-05-13");
    }

    @Test
    @DisplayName("Следующая пятница")
    void nextFriday() {
        // given
        LocalDate test = LocalDate.of(1984, Month.JULY, 14);

        // when
        LocalDate answer = Task2.nextFriday13th(test);

        // then
        assertThat(answer.toString()).isEqualTo("1985-09-13");
    }
}

package edu.hw5;

import edu.hw5.Task3.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test
    @DisplayName("Год-месяц-день")
    void yearToDay() {
        // given
        String test = "2020-10-10";

        // when
        Optional<LocalDate> answer = Task3Parser.parseDate(test);

        // then
        assertTrue(answer.isPresent());
        assertThat(answer.get()).isEqualTo("2020-10-10");
    }

    @Test
    @DisplayName("Год-месяц-день(кратко)")
    void yearToDayShort() {
        // given
        String test = "2020-1-2";

        // when
        Optional<LocalDate> answer = Task3Parser.parseDate(test);

        // then
        assertTrue(answer.isPresent());
        assertThat(answer.get()).isEqualTo("2020-01-02");
    }

    @Test
    @DisplayName("День-месяц-год")
    void dayToYear() {
        // given
        String test = "1/3/1976";

        // when
        Optional<LocalDate> answer = Task3Parser.parseDate(test);

        // then
        assertTrue(answer.isPresent());
        assertThat(answer.get()).isEqualTo("1976-03-01");
    }

    @Test
    @DisplayName("День-месяц-год(год - 2 цифры")
    void dayToYearShort() {
        // given
        String test = "1/3/20";

        // when
        Optional<LocalDate> answer = Task3Parser.parseDate(test);

        // then
        assertTrue(answer.isPresent());
        assertThat(answer.get()).isEqualTo("2020-03-01");
    }

    @Test
    @DisplayName("Завтра")
    void tomorrow() {
        // given
        String test = "tomorrow";

        // when
        Optional<LocalDate> answer = Task3Parser.parseDate(test);

        // then
        assertTrue(answer.isPresent());
        assertThat(answer.get()).isEqualTo(LocalDate.now().plusDays(1));
    }

    @Test
    @DisplayName("Сегодня")
    void today() {
        // given
        String test = "today";

        // when
        Optional<LocalDate> answer = Task3Parser.parseDate(test);

        // then
        assertTrue(answer.isPresent());
        assertThat(answer.get()).isEqualTo(LocalDate.now());
    }

    @Test
    @DisplayName("Вчера")
    void yesterday() {
        // given
        String test = "yesterday";

        // when
        Optional<LocalDate> answer = Task3Parser.parseDate(test);

        // then
        assertTrue(answer.isPresent());
        assertThat(answer.get()).isEqualTo(LocalDate.now().minusDays(1));
    }

    @Test
    @DisplayName("Один день назад")
    void oneDayAgo() {
        // given
        String test = "1 day ago";

        // when
        Optional<LocalDate> answer = Task3Parser.parseDate(test);

        // then
        assertTrue(answer.isPresent());
        assertThat(answer.get()).isEqualTo(LocalDate.now().minusDays(1));
    }

    @Test
    @DisplayName("Несколько дней назад")
    void SomeAmountOfDaysAgo() {
        // given
        String test = "2234 days ago";

        // when
        Optional<LocalDate> answer = Task3Parser.parseDate(test);

        // then
        assertTrue(answer.isPresent());
        assertThat(answer.get()).isEqualTo(LocalDate.now().minusDays(2234));
    }

    @Test
    @DisplayName("Не спарсили")
    void optionalEmpty() {
        // given
        String test = "5 months ago";

        // when
        Optional<LocalDate> answer = Task3Parser.parseDate(test);

        // then
        assertFalse(answer.isPresent());
    }
}

package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Ascending order")
    void ascending() {
        // given
        String[] test = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        String sortMethod = "ASC";

        // when
        Task5.Contact[] answer = Task5.parseContacts(test, sortMethod);
        String answerName = answer[0].getFirstName();

        // then
        assertThat(answerName).isEqualTo("Paul");
    }

    @Test
    @DisplayName("Descending order")
    void descending() {
        // given
        String[] test = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        String sortMethod = "DESC";

        // when
        Task5.Contact[] answer = Task5.parseContacts(test, sortMethod);
        String answerName = answer[0].getFirstName();

        // then
        assertThat(answerName).isEqualTo("Carl");
    }

    @Test
    @DisplayName("Пустой массив")
    void emptyArray() {
        // given
        String[] test = {};
        String sortMethod = "ASC";

        // when
        Task5.Contact[] answer = Task5.parseContacts(test, sortMethod);

        // then
        assertThat(answer).isEmpty();
    }

    @Test
    @DisplayName("Массив равен null")
    void nullArray() {
        // given
        String sortMethod = "ASC";

        // when
        Task5.Contact[] answer = Task5.parseContacts(null, sortMethod);

        // then
        assertThat(answer).isEmpty();
    }

    @Test
    @DisplayName("Неверно задана сортировка")
    void sortingIsWrong() {
        // given
        String[] test = {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        String sortMethod = "Asc";

        // when
        Task5.Contact[] answer = Task5.parseContacts(test, sortMethod);

        // then
        assertThat(answer).isEmpty();
    }

    @Test
    @DisplayName("Нет фамилии")
    void noFamily() {
        // given
        String[] test = {"Fester", "Leonhard Euler", "Carl Gauss"};
        String sortMethod = "ASC";

        // when
        Task5.Contact[] answer = Task5.parseContacts(test, sortMethod);
        String answerName = answer[1].getFirstName();

        // then
        assertThat(answerName).isEqualTo("Fester");
    }
}

package edu.hw6;

import edu.hw6.Task5.HackerNews;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Размер JSON'а")
    void hackerNewsLength() {
        // given

        // when
        long[] answer = HackerNews.hackerNewsTopStories();

        // then
        assertThat(answer.length).isGreaterThan(400);
    }

    @Test
    @DisplayName("Заголовок новости")
    void newsName() {
        // given
        long test = 37570037;

        // when
        String answer = HackerNews.news(test);

        // then
        assertThat(answer).isEqualTo("JDK 21 Release Notes");
    }
}

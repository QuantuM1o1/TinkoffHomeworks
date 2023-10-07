package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    @DisplayName("True")
    void trueReturn() {
        // given
        int[][] test = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };

        // when
        boolean answer = Task8.knightBoardCapture(test);

        // then
        assertThat(answer).isEqualTo(true);
    }

    @Test
    @DisplayName("False")
    void falseReturn() {
        // given
        int[][] test = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };

        // when
        boolean answer = Task8.knightBoardCapture(test);

        // then
        assertThat(answer).isEqualTo(false);
    }

    @Test
    @DisplayName("Проверяем первый ход")
    void move1() {
        // given
        int[][] test = {
            {1, 0, 1, 0, 1, 0, 1, 1},
            {0, 1, 0, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };

        // when
        boolean answer = Task8.knightBoardCapture(test);

        // then
        assertThat(answer).isEqualTo(false);
    }

    @Test
    @DisplayName("Проверяем второй ход")
    void move2() {
        // given
        int[][] test = {
            {1, 0, 1, 0, 1, 0, 1, 1},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };

        // when
        boolean answer = Task8.knightBoardCapture(test);

        // then
        assertThat(answer).isEqualTo(false);
    }

    @Test
    @DisplayName("Проверяем третий ход")
    void move3() {
        // given
        int[][] test = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1}
        };

        // when
        boolean answer = Task8.knightBoardCapture(test);

        // then
        assertThat(answer).isEqualTo(false);
    }

    @Test
    @DisplayName("Проверяем четвертый ход")
    void move4() {
        // given
        int[][] test = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 1}
        };

        // when
        boolean answer = Task8.knightBoardCapture(test);

        // then
        assertThat(answer).isEqualTo(false);
    }

    @Test
    @DisplayName("Проверяем пятый ход")
    void move5() {
        // given
        int[][] test = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {1, 0, 0, 1, 0, 1, 0, 1}
        };

        // when
        boolean answer = Task8.knightBoardCapture(test);

        // then
        assertThat(answer).isEqualTo(false);
    }

    @Test
    @DisplayName("Проверяем шестой ход")
    void move6() {
        // given
        int[][] test = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {1, 0, 0, 1, 0, 1, 0, 1}
        };

        // when
        boolean answer = Task8.knightBoardCapture(test);

        // then
        assertThat(answer).isEqualTo(false);
    }

    @Test
    @DisplayName("Проверяем седьмой ход")
    void move7() {
        // given
        int[][] test = {
            {1, 0, 1, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };

        // when
        boolean answer = Task8.knightBoardCapture(test);

        // then
        assertThat(answer).isEqualTo(false);
    }

    @Test
    @DisplayName("Проверяем восьмой ход")
    void move8() {
        // given
        int[][] test = {
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {0, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };

        // when
        boolean answer = Task8.knightBoardCapture(test);

        // then
        assertThat(answer).isEqualTo(false);
    }
}

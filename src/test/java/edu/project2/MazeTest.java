package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MazeTest {
    @Test
    @DisplayName("Размер лабиринта меньше")
    void maze1x1() {
        // given
        Maze maze = new Maze(1,1);

        // when
        int answer = maze.getSize();

        // then
        assertThat(answer).isEqualTo(9);
    }

    @Test
    @DisplayName("Размер лабиринта нулевой")
    void maze0x0() {
        // given
        Maze maze = new Maze(0,0);

        // when
        int answer = maze.getSize();

        // then
        assertThat(answer).isEqualTo(9);
    }

    @Test
    @DisplayName("Размер лабиринта отрицательный")
    void mazeNegativeSize() {
        // given
        Maze maze = new Maze(-1,-1);

        // when
        int answer = maze.getSize();

        // then
        assertThat(answer).isEqualTo(9);
    }

    @Test
    @DisplayName("Размер лабиринта минимальный")
    void maze2x2() {
        // given
        Maze maze = new Maze(2,2);

        // when
        int answer = maze.getSize();

        // then
        assertThat(answer).isEqualTo(4);
    }

    @Test
    @DisplayName("Размер лабиринта максимальный")
    void maze100x100() {
        // given
        Maze maze = new Maze(100,100);

        // when
        int answer = maze.getSize();

        // then
        assertThat(answer).isEqualTo(100 * 100);
    }
    @Test
    @DisplayName("Размер лабиринта больше")
    void maze101x101() {
        // given
        Maze maze = new Maze(101,101);

        // when
        int answer = maze.getSize();

        // then
        assertThat(answer).isEqualTo(9);
    }

    @Test
    @DisplayName("Корректное добавление путей")
    void mazeEdges() {
        // given
        Maze maze = new Maze(5,5);

        // when
        maze.addEdge(1, 2);
        maze.addEdge(1, 2);
        maze.addEdge(2, 1);
        List<Integer> answer = maze.getEdges(1);

        // then
        assertThat(answer.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Минимальные координаты")
    void mazeMinCoordinates() {
        // given
        Maze maze = new Maze(5,5);

        // when
        Coordinate answer = maze.findCoordinates(0);

        // then
        assertThat(answer.getX()).isEqualTo(0);
        assertThat(answer.getY()).isEqualTo(0);
    }

    @Test
    @DisplayName("Отрицательные координаты")
    void mazeNegativeCoordinates() {
        // given
        Maze maze = new Maze(5,5);

        // when
        Coordinate answer = maze.findCoordinates(-10);

        // then
        assertThat(answer.getX()).isEqualTo(-1);
        assertThat(answer.getY()).isEqualTo(-1);
    }

    @Test
    @DisplayName("Координаты максимальные")
    void mazeMaxCoordinates() {
        // given
        Maze maze = new Maze(5,5);

        // when
        Coordinate answer = maze.findCoordinates(24);

        // then
        assertThat(answer.getX()).isEqualTo(4);
        assertThat(answer.getY()).isEqualTo(4);
    }

    @Test
    @DisplayName("Координаты больше")
    void mazeTooBigCoordinates() {
        // given
        Maze maze = new Maze(5,5);

        // when
        Coordinate answer = maze.findCoordinates(25);

        // then
        assertThat(answer.getX()).isEqualTo(-1);
        assertThat(answer.getY()).isEqualTo(-1);
    }

    @Test
    @DisplayName("Ячейка отрицательное значение")
    void mazeCellNegative() {
        // given
        Maze maze = new Maze(5,5);

        // when
        int answer = maze.findCell(new Coordinate(-1, -1));

        // then
        assertThat(answer).isEqualTo(-1);

    }

    @Test
    @DisplayName("Ячейка минимальная")
    void mazeCellMin() {
        // given
        Maze maze = new Maze(5,5);

        // when
        int answer = maze.findCell(new Coordinate(0, 0));

        // then
        assertThat(answer).isEqualTo(0);

    }

    @Test
    @DisplayName("Ячейка максимальная")
    void mazeCellMax() {
        // given
        Maze maze = new Maze(5,5);

        // when
        int answer = maze.findCell(new Coordinate(4, 4));

        // then
        assertThat(answer).isEqualTo(24);

    }

    @Test
    @DisplayName("Ячейка больше")
    void mazeCellTooBig() {
        // given
        Maze maze = new Maze(5,5);

        // when
        int answer = maze.findCell(new Coordinate(5, 5));

        // then
        assertThat(answer).isEqualTo(-1);
    }

    @Test
    @DisplayName("Высота")
    void mazeHeight() {
        // given
        Maze maze = new Maze(4,5);

        // when
        int answer = maze.getHeight();

        // then
        assertThat(answer).isEqualTo(4);
    }

    @Test
    @DisplayName("Высота отрицательная")
    void mazeNegativeHeight() {
        // given
        Maze maze = new Maze(-1,5);

        // when
        int answer = maze.getHeight();

        // then
        assertThat(answer).isEqualTo(3);
    }

    @Test
    @DisplayName("Ширина")
    void mazeWidth() {
        // given
        Maze maze = new Maze(5,4);

        // when
        int answer = maze.getWidth();

        // then
        assertThat(answer).isEqualTo(4);
    }

    @Test
    @DisplayName("Ширина отрицательная")
    void mazeNegativeWidth() {
        // given
        Maze maze = new Maze(5,-1);

        // when
        int answer = maze.getWidth();

        // then
        assertThat(answer).isEqualTo(3);
    }
}

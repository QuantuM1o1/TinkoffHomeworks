package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MazeGeneratorTest {
    @Test
    @DisplayName("Корректная генерация Recursive Backtracker")
    void correctRecursiveBacktrackerGenerator() {
        // given
        MazeGenerator generator = new RecursiveBacktrackerGenerator();

        // when
        Maze maze = generator.createMaze(4, 5);
        MazeSolver solver = new BFSSolver();
        List<Integer> answer = solver.solveMaze(maze, new Coordinate(0, 0), new Coordinate(4, 3));

        // then
        assertThat(maze.getSize()).isEqualTo(20);
        assertThat(maze.getHeight()).isEqualTo(4);
        assertThat(maze.getWidth()).isEqualTo(5);
        assertThat(maze.findCoordinates(11).getX()).isEqualTo(new Coordinate(1, 2).getX());
        assertThat(maze.findCoordinates(11).getY()).isEqualTo(new Coordinate(1, 2).getY());
        assertFalse(maze.getEdges(1).isEmpty());
        assertThat(maze.findCell(new Coordinate(2, 1))).isEqualTo(7);
        assertTrue(answer.size() > 6);
    }

    @Test
    @DisplayName("Некорректная генерация Recursive Backtracker")
    void incorrectRecursiveBacktrackerGenerator() {
        // given
        MazeGenerator generator = new RecursiveBacktrackerGenerator();

        // when
        Maze maze = generator.createMaze(0, 5);
        MazeSolver solver = new BFSSolver();
        List<Integer> answer = solver.solveMaze(maze, new Coordinate(0, 0), new Coordinate(4, 3));

        // then
        assertThat(maze.getSize()).isEqualTo(9);
        assertThat(maze.getHeight()).isEqualTo(3);
        assertThat(maze.getWidth()).isEqualTo(3);
        assertThat(maze.findCoordinates(11).getX()).isEqualTo(new Coordinate(-1, -1).getX());
        assertThat(maze.findCoordinates(11).getY()).isEqualTo(new Coordinate(-1, -1).getY());
        assertFalse(maze.getEdges(1).isEmpty());
        assertThat(maze.findCell(new Coordinate(3, 1))).isEqualTo(-1);
        assertTrue(answer.isEmpty());
    }

    @Test
    @DisplayName("Корректная генерация Aldous-Broder")
    void correctAldousBroderGenerator() {
        // given
        MazeGenerator generator = new AldousBroderGenerator();

        // when
        Maze maze = generator.createMaze(4, 5);
        MazeSolver solver = new BFSSolver();
        List<Integer> answer = solver.solveMaze(maze, new Coordinate(0, 0), new Coordinate(4, 3));

        // then
        assertThat(maze.getSize()).isEqualTo(20);
        assertThat(maze.getHeight()).isEqualTo(4);
        assertThat(maze.getWidth()).isEqualTo(5);
        assertThat(maze.findCoordinates(11).getX()).isEqualTo(new Coordinate(1, 2).getX());
        assertThat(maze.findCoordinates(11).getY()).isEqualTo(new Coordinate(1, 2).getY());
        assertFalse(maze.getEdges(1).isEmpty());
        assertThat(maze.findCell(new Coordinate(2, 1))).isEqualTo(7);
        assertTrue(answer.size() > 6);
    }

    @Test
    @DisplayName("Некорректная генерация Aldous-Broder")
    void incorrectAldousBroderGenerator() {
        // given
        MazeGenerator generator = new RecursiveBacktrackerGenerator();

        // when
        Maze maze = generator.createMaze(0, 5);
        MazeSolver solver = new BFSSolver();
        List<Integer> answer = solver.solveMaze(maze, new Coordinate(0, 0), new Coordinate(4, 3));

        // then
        assertThat(maze.getSize()).isEqualTo(9);
        assertThat(maze.getHeight()).isEqualTo(3);
        assertThat(maze.getWidth()).isEqualTo(3);
        assertThat(maze.findCoordinates(11).getX()).isEqualTo(new Coordinate(-1, -1).getX());
        assertThat(maze.findCoordinates(11).getY()).isEqualTo(new Coordinate(-1, -1).getY());
        assertFalse(maze.getEdges(1).isEmpty());
        assertThat(maze.findCell(new Coordinate(3, 1))).isEqualTo(-1);
        assertTrue(answer.isEmpty());
    }

    @Test
    @DisplayName("Корректная генерация Binary Tree")
    void correctBinaryTreeGenerator() {
        // given
        MazeGenerator generator = new BinaryTreeGenerator();

        // when
        Maze maze = generator.createMaze(4, 5);
        MazeSolver solver = new BFSSolver();
        List<Integer> answer = solver.solveMaze(maze, new Coordinate(0, 0), new Coordinate(4, 3));

        // then
        assertThat(maze.getSize()).isEqualTo(20);
        assertThat(maze.getHeight()).isEqualTo(4);
        assertThat(maze.getWidth()).isEqualTo(5);
        assertThat(maze.findCoordinates(11).getX()).isEqualTo(new Coordinate(1, 2).getX());
        assertThat(maze.findCoordinates(11).getY()).isEqualTo(new Coordinate(1, 2).getY());
        assertFalse(maze.getEdges(1).isEmpty());
        assertThat(maze.findCell(new Coordinate(2, 1))).isEqualTo(7);
        assertTrue(answer.size() > 6);
    }

    @Test
    @DisplayName("Некорректная генерация Binary Tree")
    void incorrectBinaryTreeGenerator() {
        // given
        MazeGenerator generator = new BinaryTreeGenerator();

        // when
        Maze maze = generator.createMaze(0, 5);
        MazeSolver solver = new BFSSolver();
        List<Integer> answer = solver.solveMaze(maze, new Coordinate(0, 0), new Coordinate(4, 3));

        // then
        assertThat(maze.getSize()).isEqualTo(9);
        assertThat(maze.getHeight()).isEqualTo(3);
        assertThat(maze.getWidth()).isEqualTo(3);
        assertThat(maze.findCoordinates(11).getX()).isEqualTo(new Coordinate(-1, -1).getX());
        assertThat(maze.findCoordinates(11).getY()).isEqualTo(new Coordinate(-1, -1).getY());
        assertFalse(maze.getEdges(1).isEmpty());
        assertThat(maze.findCell(new Coordinate(3, 1))).isEqualTo(-1);
        assertTrue(answer.isEmpty());
    }
}

package edu.hw9;

import edu.hw9.Task3.ConcurrentDFSSolver;
import edu.project2.Coordinate;
import edu.project2.Maze;
import edu.project2.MazeSolver;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3Test {
    @Test
    @DisplayName("Тест решения")
    void multiThreadSolver() {
        // given
        Maze maze = new Maze(3,3);
        maze.addEdge(0, 1);
        maze.addEdge(1, 2);
        maze.addEdge(2, 5);
        maze.addEdge(5, 8);
        maze.addEdge(8, 7);
        maze.addEdge(7, 6);
        maze.addEdge(6, 3);
        MazeSolver solver = new ConcurrentDFSSolver();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(2, 1);

        // when
        List<Integer> answer = solver.solveMaze(maze, start, end);

        // then
        assertThat(answer).asList().containsOnly(0, 1, 2, 5);
    }

    @Test
    @DisplayName("Нет решения в мультипотоках")
    void noAnswerMulti() {
        // given
        Maze maze = new Maze(3,3);
        maze.addEdge(0, 1);
        maze.addEdge(1, 2);
        maze.addEdge(2, 5);
        maze.addEdge(5, 8);
        maze.addEdge(8, 7);
        maze.addEdge(7, 6);
        maze.addEdge(6, 3);
        MazeSolver solver = new ConcurrentDFSSolver();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(1, 1);

        // when
        List<Integer> answer = solver.solveMaze(maze, start, end);

        // then
        assertTrue(answer.isEmpty());
    }
}

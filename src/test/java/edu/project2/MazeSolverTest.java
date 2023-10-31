package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MazeSolverTest {
    @Test
    @DisplayName("Есть решение BFS")
    void solverBFSValid() {
        // given
        Maze maze = new Maze(3,3);
        maze.addEdge(0, 1);
        maze.addEdge(1, 2);
        maze.addEdge(2, 5);
        maze.addEdge(5, 8);
        maze.addEdge(8, 7);
        maze.addEdge(7, 6);
        maze.addEdge(6, 3);
        MazeSolver solver = new BFSSolver();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(2, 1);

        // when
        List<Integer> answer = solver.solveMaze(maze, start, end);

        // then
        assertThat(answer).asList().containsOnly(0, 1, 2, 5);
    }

    @Test
    @DisplayName("Нет решения BFS")
    void solverBFSInvalid() {
        // given
        Maze maze = new Maze(3,3);
        maze.addEdge(0, 1);
        maze.addEdge(1, 2);
        maze.addEdge(2, 5);
        maze.addEdge(5, 8);
        maze.addEdge(8, 7);
        maze.addEdge(7, 6);
        maze.addEdge(6, 3);
        MazeSolver solver = new BFSSolver();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(1, 1);

        // when
        List<Integer> answer = solver.solveMaze(maze, start, end);

        // then
        assertTrue(answer.isEmpty());
    }

    @Test
    @DisplayName("Есть решение DFS")
    void solverDFSValid() {
        // given
        Maze maze = new Maze(3,3);
        maze.addEdge(0, 1);
        maze.addEdge(1, 2);
        maze.addEdge(2, 5);
        maze.addEdge(5, 8);
        maze.addEdge(8, 7);
        maze.addEdge(7, 6);
        maze.addEdge(6, 3);
        MazeSolver solver = new DFSSolver();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(2, 1);

        // when
        List<Integer> answer = solver.solveMaze(maze, start, end);

        // then
        assertThat(answer).asList().containsOnly(0, 1, 2, 5);
    }

    @Test
    @DisplayName("Нет решения DFS")
    void solverDFSInvalid() {
        // given
        Maze maze = new Maze(3,3);
        maze.addEdge(0, 1);
        maze.addEdge(1, 2);
        maze.addEdge(2, 5);
        maze.addEdge(5, 8);
        maze.addEdge(8, 7);
        maze.addEdge(7, 6);
        maze.addEdge(6, 3);
        MazeSolver solver = new DFSSolver();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(1, 1);

        // when
        List<Integer> answer = solver.solveMaze(maze, start, end);

        // then
        assertTrue(answer.isEmpty());
    }
}

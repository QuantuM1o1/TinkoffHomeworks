package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MazeDrawerTest {
    @Test
    @DisplayName("Отрисовка")
    void drawing() {
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
        Coordinate end = new Coordinate(2, 0);
        List<Integer> list = solver.solveMaze(maze, start, end);

        // when
        char[][] answer = MazeDrawer.drawMaze(maze, list);

        // then
        assertThat(answer[0]).isEqualTo(new char[] {'█', '█','█','█','█', '█', '█'});
        assertThat(answer[1]).isEqualTo(new char[] {'█', '*','*','*','*', '*', '█'});
        assertThat(answer[2]).isEqualTo(new char[] {'█', '█','█','█','█', ' ', '█'});
        assertThat(answer[3]).isEqualTo(new char[] {'█', ' ','█',' ','█', ' ', '█'});
        assertThat(answer[4]).isEqualTo(new char[] {'█', ' ','█','█','█', ' ', '█'});
        assertThat(answer[5]).isEqualTo(new char[] {'█', ' ',' ',' ',' ', ' ', '█'});
        assertThat(answer[6]).isEqualTo(new char[] {'█', '█','█','█','█', '█', '█'});
    }
}

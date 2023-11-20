package edu.project2;

import java.util.List;

public class Main {
    private Main() {
    }

    @SuppressWarnings({"MagicNumber", "RegexpSinglelineJava"})
    public static void main(String[] args) {
        MazeGenerator generator = new RecursiveBacktrackerGenerator();
        Maze maze = generator.createMaze(8, 50);
        MazeSolver solver = new DFSSolver();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(49, 7);
        List<Integer> list = solver.solveMaze(maze, start, end);
        System.out.println(list);
        MazeDrawer.drawMaze(maze, list);
    }
}

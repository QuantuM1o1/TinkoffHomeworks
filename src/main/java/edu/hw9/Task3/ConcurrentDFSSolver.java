package edu.hw9.Task3;

import edu.project2.Coordinate;
import edu.project2.Maze;
import edu.project2.MazeSolver;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;

public class ConcurrentDFSSolver implements MazeSolver {
    @Override
    public List<Integer> solveMaze(Maze maze, Coordinate startingPointCoordinate, Coordinate finalPointCoordinate) {
        if (notValidCoordinate(maze, startingPointCoordinate) || notValidCoordinate(maze, finalPointCoordinate)) {
            return Collections.emptyList();
        }
        int finalPoint = maze.findCell(finalPointCoordinate);
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            List<Boolean> visited = new CopyOnWriteArrayList<>();
            for (int i = 0; i < maze.getSize(); i++) {
                visited.add(false);
            }
            List<Integer> path = new CopyOnWriteArrayList<>();
            return forkJoinPool.invoke(new DFSTask(maze, startingPointCoordinate, finalPoint, visited, path));
        }
    }
}

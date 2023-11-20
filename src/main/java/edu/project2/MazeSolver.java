package edu.project2;

import java.util.List;

public interface MazeSolver {
    List<Integer> solveMaze(Maze maze, Coordinate startingPointCoordinate, Coordinate finalPointCoordinate);

    default boolean notValidCoordinate(Maze maze, Coordinate coordinate) {
        return (coordinate.getX() < 0 || coordinate.getX() > maze.getWidth() - 1
            || coordinate.getY() < 0 || coordinate.getY() > maze.getHeight() - 1);
    }
}

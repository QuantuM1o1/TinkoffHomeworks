package edu.project2;

import java.util.List;

public interface MazeSolver {
    List<Integer> solveMaze(Maze maze, Coordinate startingPointCoordinate, Coordinate finalPointCoordinate);
}

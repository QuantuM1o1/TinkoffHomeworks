package edu.project2;

import java.util.List;
import java.util.function.Predicate;

public interface MazeGenerator {
    Coordinate[] POSSIBLE_NEARBY_CELLS =
        {new Coordinate(0, -1), new Coordinate(1, 0), new Coordinate(0, 1), new Coordinate(-1, 0)};

    Maze createMaze(int height, int width);

    default int checkNearbyCells(
        Coordinate currentCellCoordinate,
        Maze maze,
        List<Integer> nearbyCells,
        int count,
        Predicate<Integer> condition) {
        int answer = count;
        for (Coordinate possibleNearbyCell : POSSIBLE_NEARBY_CELLS) {
            Coordinate cellToCheckCoordinate =
                new Coordinate(currentCellCoordinate.getX() + possibleNearbyCell.getX(),
                    currentCellCoordinate.getY() + possibleNearbyCell.getY());
            if (cellToCheckCoordinate.getX() >= 0 && cellToCheckCoordinate.getX() < maze.getWidth()
                && cellToCheckCoordinate.getY() >= 0 && cellToCheckCoordinate.getY() < maze.getHeight()) {
                int cellToCheck = maze.findCell(cellToCheckCoordinate);
                if (condition.test(cellToCheck)) {
                    nearbyCells.add(cellToCheck);
                    answer++;
                }
            }
        }
        return answer;
    }
}

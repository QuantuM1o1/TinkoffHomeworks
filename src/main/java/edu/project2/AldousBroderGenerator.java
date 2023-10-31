package edu.project2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AldousBroderGenerator implements MazeGenerator {
    private final static Coordinate[] POSSIBLE_NEARBY_CELLS =
        {new Coordinate(0, -1), new Coordinate(1, 0), new Coordinate(0, 1), new Coordinate(-1, 0)};

    @Override
    public Maze createMaze(int height, int width) {
        Maze maze = new Maze(height, width);
        Set<Integer> uncheckedCells = new HashSet<>(maze.getSize());
        for (int i = 0; i < maze.getSize(); i++) {
            uncheckedCells.add(i);
        }
        Random rand = new Random();
        int currentCell = rand.nextInt() % maze.getSize();
        currentCell = Math.abs(currentCell);
        uncheckedCells.remove(currentCell);
        while (!uncheckedCells.isEmpty()) {
            Coordinate currentCellCoordinate = maze.findCoordinates(currentCell);
            ArrayList<Integer> nearbyCells = new ArrayList<>();
            int count = 0;
            for (Coordinate possibleNearbyCell : POSSIBLE_NEARBY_CELLS) {
                Coordinate cellToCheckCoordinate =
                    new Coordinate(currentCellCoordinate.getX() + possibleNearbyCell.getX(),
                        currentCellCoordinate.getY() + possibleNearbyCell.getY());
                if (cellToCheckCoordinate.getX() >= 0 && cellToCheckCoordinate.getX() < maze.getWidth()
                    && cellToCheckCoordinate.getY() >= 0 && cellToCheckCoordinate.getY() < maze.getHeight()) {
                    int cellToCheck = maze.findCell(cellToCheckCoordinate);
                    nearbyCells.add(cellToCheck);
                    count++;
                }
            }
            int nextCell = rand.nextInt() % count;
            nextCell = Math.abs(nextCell);
            nextCell = nearbyCells.get(nextCell);
            if (uncheckedCells.contains(nextCell)) {
                maze.addEdge(currentCell, nextCell);
                uncheckedCells.remove(nextCell);
            }
            currentCell = nextCell;
        }
        return maze;
    }
}

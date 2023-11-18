package edu.project2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;

public class AldousBroderGenerator implements MazeGenerator {
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
            List<Integer> nearbyCells = new ArrayList<>();
            int count = 0;
            count = checkNearbyCells(currentCellCoordinate, maze, nearbyCells, count, cellToCheck -> true);
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

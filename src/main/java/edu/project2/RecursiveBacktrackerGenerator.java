package edu.project2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RecursiveBacktrackerGenerator implements MazeGenerator {
    @Override
    public Maze createMaze(int height, int width) {
        Maze maze = new Maze(height, width);
        Set<Integer> uncheckedCells = new HashSet<>();
        for (int i = 0; i < maze.getSize(); i++) {
            uncheckedCells.add(i);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        Random rand = new Random();
        int currentCell = rand.nextInt() % maze.getSize();
        currentCell = Math.abs(currentCell);
        uncheckedCells.remove(currentCell);
        stack.addFirst(currentCell);
        while (!uncheckedCells.isEmpty()) {
            currentCell = stack.removeFirst();
            Coordinate currentCellCoordinate = maze.findCoordinates(currentCell);
            ArrayList<Integer> nearbyCells = new ArrayList<>();
            int count = 0;
            count = checkNearbyCells(currentCellCoordinate, maze, nearbyCells, count, uncheckedCells::contains);
            if (count == 0) {
                continue;
            }
            int nextCell = rand.nextInt() % count;
            nextCell = Math.abs(nextCell);
            nextCell = nearbyCells.get(nextCell);
            stack.addFirst(currentCell);
            stack.addFirst(nextCell);
            uncheckedCells.remove(nextCell);
            maze.addEdge(currentCell, nextCell);
        }
        return maze;
    }
}

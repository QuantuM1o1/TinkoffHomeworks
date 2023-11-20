package edu.project2;

import java.util.Random;

public class BinaryTreeGenerator implements MazeGenerator {
    @Override
    public Maze createMaze(int height, int width) {
        Maze maze = new Maze(height, width);
        Random rand = new Random();
        for (int currentCell = 0; currentCell < maze.getSize(); currentCell++) {
            int nextCell = rand.nextInt() % 2;
            nextCell = Math.abs(nextCell);
            Coordinate currentCellCoordinate = maze.findCoordinates(currentCell);
            if (currentCell == maze.getWidth() - 1) {
                continue;
            } else if (currentCellCoordinate.getY() == 0) {
                nextCell = currentCell + 1;
            } else if (currentCellCoordinate.getX() == maze.getWidth() - 1) {
                nextCell = currentCell - maze.getWidth();
            } else if (nextCell == 0) {
                nextCell = currentCell + 1;
            } else {
                nextCell = currentCell - maze.getWidth();
            }
            maze.addEdge(currentCell, nextCell);
        }
        return maze;
    }
}

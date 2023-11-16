package edu.project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFSSolver implements MazeSolver {
    private List<Integer> path;
    private int finalPoint;
    private boolean[] visited;
    private Maze maze;

    @Override
    public List<Integer> solveMaze(Maze maze, Coordinate startingPointCoordinate, Coordinate finalPointCoordinate) {
        if (notValidCoordinate(maze, startingPointCoordinate) || notValidCoordinate(maze, finalPointCoordinate)) {
            return Collections.emptyList();
        }
        int startingPoint = maze.findCell(startingPointCoordinate);
        this.finalPoint = maze.findCell(finalPointCoordinate);
        this.maze = maze;
        visited = new boolean[maze.getSize()];
        path = new ArrayList<>();
        if (depthFirstSearch(startingPoint)) {
            return path;
        }
        return Collections.emptyList();
    }

    private boolean depthFirstSearch(int currentNode) {
        visited[currentNode] = true;
        path.add(currentNode);
        if (currentNode == finalPoint) {
            return true;
        }
        for (int neighbor : maze.getEdges(currentNode)) {
            if (!visited[neighbor] && depthFirstSearch(neighbor)) {
                return true;
            }
        }
        path.removeLast();
        return false;
    }


}

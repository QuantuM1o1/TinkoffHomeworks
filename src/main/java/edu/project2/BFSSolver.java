package edu.project2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BFSSolver implements MazeSolver {
    private Map<Integer, Integer> parentNodes;
    private int startingPoint;
    private int finalPoint;

    @Override
    public List<Integer> solveMaze(Maze maze, Coordinate startingPointCoordinate, Coordinate finalPointCoordinate) {
        if (startingPointCoordinate.getX() < 0 || startingPointCoordinate.getX() > maze.getWidth() - 1
            || finalPointCoordinate.getX() < 0 || finalPointCoordinate.getX() > maze.getWidth() - 1
            || startingPointCoordinate.getY() < 0 || startingPointCoordinate.getY() > maze.getHeight() - 1
            || finalPointCoordinate.getY() < 0 || finalPointCoordinate.getY() > maze.getHeight() - 1) {
            return Collections.emptyList();
        }
        this.startingPoint = maze.findCell(startingPointCoordinate);
        this.finalPoint = maze.findCell(finalPointCoordinate);
        boolean[] visited = new boolean[maze.getSize()];
        Deque<Integer> queue = new ArrayDeque<>();
        parentNodes = new HashMap<>();
        visited[this.startingPoint] = true;
        queue.add(this.startingPoint);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            if (currentNode == this.finalPoint) {
                return returnPath();
            }
            for (int neighbor : maze.getEdges(currentNode)) {
                if (visited[neighbor]) {
                    continue;
                }
                visited[neighbor] = true;
                parentNodes.put(neighbor, currentNode);
                queue.add(neighbor);
            }
        }
        return Collections.emptyList();
    }

    private List<Integer> returnPath() {
        List<Integer> path = new ArrayList<>();
        int currentNode = finalPoint;
        while (currentNode != startingPoint) {
            path.add(currentNode);
            currentNode = parentNodes.get(currentNode);
        }
        path.add(startingPoint);
        return path;
    }
}

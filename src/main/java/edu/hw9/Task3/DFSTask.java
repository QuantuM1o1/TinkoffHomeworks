package edu.hw9.Task3;

import edu.project2.Coordinate;
import edu.project2.Maze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DFSTask extends RecursiveTask<List<Integer>> {
    private final int finalPoint;
    private final Maze maze;
    private final Coordinate currentCoordinate;
    private final List<Boolean> visited;
    private final List<Integer> path;

    public DFSTask(Maze maze, Coordinate currentCoordinate, int finalPoint, List<Boolean> visited, List<Integer> path) {
        this.maze = maze;
        this.currentCoordinate = currentCoordinate;
        this.finalPoint = finalPoint;
        this.visited = visited;
        this.path = path;
    }

    @Override
    public List<Integer> compute() {
        int startingPoint = maze.findCell(currentCoordinate);
        return depthFirstSearch(startingPoint);
    }

    private List<Integer> depthFirstSearch(int currentNode) {
        visited.set(currentNode, true);
        path.add(currentNode);
        if (currentNode == finalPoint) {
            return path;
        }
        List<DFSTask> tasks = new ArrayList<>();
        for (int neighbor : maze.getEdges(currentNode)) {
            if (!visited.get(neighbor)) {
                DFSTask task =
                    new DFSTask(maze, maze.findCoordinates(neighbor), finalPoint, visited, new ArrayList<>(path));
                tasks.add(task);
                task.fork();
            }
        }
        for (DFSTask task : tasks) {
            List<Integer> output = task.join();
            if (output.contains(finalPoint)) {
                return output;
            }
        }
        return Collections.emptyList();
    }
}

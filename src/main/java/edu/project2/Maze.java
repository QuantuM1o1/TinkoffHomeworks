package edu.project2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maze {
    private final Map<Integer, List<Integer>> nodes;
    private final int height;
    private final int width;
    private static final int MAX_SIZE = 101;
    private static final int MIN_SIZE = 1;
    private static final int DEFAULT_SIZE = 3;

    public Maze(int height, int width) {
        if (height > MIN_SIZE && height < MAX_SIZE && width > MIN_SIZE && width < MAX_SIZE) {
            this.height = height;
            this.width = width;
        } else {
            this.height = DEFAULT_SIZE;
            this.width = DEFAULT_SIZE;
        }
        nodes = new HashMap<>(this.getSize());
        for (int i = 0; i < this.getSize(); i++) {
            nodes.put(i, new ArrayList<>());
        }
    }

    public int getSize() {
        return height * width;
    }

    public void addEdge(int endpoint1, int endpoint2) {
        if (!nodes.get(endpoint1).contains(endpoint2)) {
            nodes.get(endpoint1).add(endpoint2);
            nodes.get(endpoint2).add(endpoint1);
        }
    }

    public List<Integer> getEdges(int node) {
        return nodes.get(node);
    }

    public Coordinate findCoordinates(int cell) {
        if (cell < 0 || cell > this.getSize() - 1) {
            return new Coordinate(-1, -1);
        }
        return new Coordinate(cell % width, cell / width);
    }

    public int findCell(Coordinate coordinates) {
        if (coordinates.getX() < 0 || coordinates.getX() > width - 1
            || coordinates.getY() < 0 || coordinates.getY() > height - 1) {
            return -1;
        }
        return coordinates.getX() + coordinates.getY() * width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}

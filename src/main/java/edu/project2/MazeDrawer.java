package edu.project2;

import java.util.List;

public class MazeDrawer {
    private MazeDrawer() {
    }

    private final static char PATH = '*';
    private final static char EMPTY_SPACE = ' ';
    private final static char WALL = '█';

    @SuppressWarnings("RegexpSinglelineJava")
    public static char[][] drawMaze(Maze maze, List<Integer> path) {
        int height = maze.getHeight();
        height = recalculateCoordinate(height);
        int width = maze.getWidth();
        width = recalculateCoordinate(width);
        char[][] drawing = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i % 2 == 1) && (j % 2 == 1)) {
                    drawing[i][j] = EMPTY_SPACE;
                } else {
                    drawing[i][j] = WALL;
                }
            }
        }
        for (int i = 0; i < maze.getSize(); i++) {
            List<Integer> noWalls = maze.getEdges(i);
            for (int node : noWalls) {
                Coordinate wallToDeleteCoordinate = maze.findCoordinates(i);
                wallToDeleteCoordinate.setX(recalculateCoordinate(wallToDeleteCoordinate.getX()));
                wallToDeleteCoordinate.setY(recalculateCoordinate(wallToDeleteCoordinate.getY()));
                int wallToDelete = node - i;
                if (wallToDelete == 1) {
                    wallToDeleteCoordinate.setX(wallToDeleteCoordinate.getX() + 1);
                } else if (wallToDelete == maze.getWidth()) {
                    wallToDeleteCoordinate.setY(wallToDeleteCoordinate.getY() + 1);
                }
                drawing[wallToDeleteCoordinate.getY()][wallToDeleteCoordinate.getX()] = EMPTY_SPACE;
            }
        }
        for (int i = 0; i < path.size() - 1; i++) {
            int start = path.get(i);
            int end = path.get(i + 1);
            if (start > end) {
                int temp = start;
                start = end;
                end = temp;
            }
            Coordinate startCoordinate = maze.findCoordinates(start);
            startCoordinate.setX(recalculateCoordinate(startCoordinate.getX()));
            startCoordinate.setY(recalculateCoordinate(startCoordinate.getY()));
            drawing[startCoordinate.getY()][startCoordinate.getX()] = PATH;
            Coordinate endCoordinate = maze.findCoordinates(end);
            endCoordinate.setX(recalculateCoordinate(endCoordinate.getX()));
            endCoordinate.setY(recalculateCoordinate(endCoordinate.getY()));
            drawing[endCoordinate.getY()][endCoordinate.getX()] = PATH;
            int emptySpaceToPath = end - start;
            if (emptySpaceToPath == 1) {
                startCoordinate.setX(startCoordinate.getX() + 1);
            } else if (emptySpaceToPath == maze.getWidth()) {
                startCoordinate.setY(startCoordinate.getY() + 1);
            }
            drawing[startCoordinate.getY()][startCoordinate.getX()] = PATH;

        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(drawing[i][j]);
            }
            System.out.println();
        }
        return drawing;
    }

    private static int recalculateCoordinate(int coordinate) {
        return coordinate * 2 + 1;
    }
}

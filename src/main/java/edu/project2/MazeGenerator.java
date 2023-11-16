package edu.project2;

public interface MazeGenerator {
    Coordinate[] POSSIBLE_NEARBY_CELLS =
        {new Coordinate(0, -1), new Coordinate(1, 0), new Coordinate(0, 1), new Coordinate(-1, 0)};

    Maze createMaze(int height, int width);


}

package edu.project3;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PathFinder {
    private final static Logger LOGGER = LogManager.getLogger();

    private PathFinder() {
    }

    public static List<Path> findPath(String input) {
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + input);
        Path sourcePath = Paths.get("src\\");
        try (Stream<Path> paths = Files.find(sourcePath, Integer.MAX_VALUE, (path, f) -> pathMatcher.matches(path))) {
            return paths.toList();
        } catch (IOException e) {
            LOGGER.info("No files in path");
            return Collections.emptyList();
        }
    }
}

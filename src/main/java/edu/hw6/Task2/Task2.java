package edu.hw6.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static final String REGEX_TO_FIND_FILENAME = "(.+)(\\..+)";

    private Task2() {
    }

    public static Path cloneFile(Path path) {
        String pathString = path.getFileName().toString();
        Pattern pattern = Pattern.compile(REGEX_TO_FIND_FILENAME);
        Matcher matcher = pattern.matcher(pathString);
        String stringToFind;
        Path pathOfCopy = path;
        if (matcher.find()) {
            stringToFind = path.getParent().toString() + "/" + matcher.group(1) + " — копия" + matcher.group(2);
            pathOfCopy = Paths.get(stringToFind);
            if (Files.isReadable(pathOfCopy)) {
                for (int i = 2; Files.isReadable(Paths.get(stringToFind)); i++) {
                    stringToFind = path
                        .getParent()
                        .toString()
                        + "/" + matcher.group(1) + " — копия (" + i + ")" + matcher.group(2);
                    pathOfCopy = Paths.get(stringToFind);
                }
            }
        }
        try {
            Files.copy(path, pathOfCopy);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pathOfCopy.getFileName();
    }
}

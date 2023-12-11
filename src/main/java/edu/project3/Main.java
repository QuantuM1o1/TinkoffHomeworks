package edu.project3;

import java.net.URI;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String DEFAULT_FILE_FORMAT = ".txt";

    private Main() {
    }

    public static void main(String[] args) {
        ArgumentParser parser = new ArgumentParser(args);
        String stringPath = parser.parsePath();
        LocalDate startDate = parser.parseStartDate();
        LocalDate finalDate = parser.parseFinalDate();
        String stringFormat = parser.parseFormat();
        List<Log> logList = new ArrayList<>();
        List<Path> pathList = new ArrayList<>();
        if (stringPath != null && stringPath.matches("^https?:.*")) {
            URI uri = URI.create(stringPath);
            logList = LogReader.read(uri);
        } else {
            pathList = PathFinder.findPath(stringPath, "src\\");
            for (Path path : pathList) {
                logList.addAll(LogReader.read(path));
            }
        }
        logList = logList.stream()
            .filter(log ->
                log.time().isAfter(OffsetDateTime.of(startDate, LocalTime.MIN, ZoneOffset.UTC))
                    && log.time().isBefore(OffsetDateTime.of(finalDate, LocalTime.MAX, ZoneOffset.UTC)))
            .toList();
        stringFormat = switch (stringFormat) {
            case "markdown" -> ".md";
            case "adoc" -> ".adoc";
            default -> DEFAULT_FILE_FORMAT;
        };
        FileCreator.createFileWithStats(stringFormat, logList, pathList, startDate, finalDate);
    }
}

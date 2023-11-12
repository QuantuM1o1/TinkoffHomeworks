package edu.project3;

import java.net.URI;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String DEFAULT_FILE_FORMAT = ".txt";

    private Main() {
    }

    public static void main(String[] args) {
        String stringPath = null;
        LocalDate startDate = LocalDate.MIN;
        LocalDate finalDate = LocalDate.MAX;
        String stringFormat = DEFAULT_FILE_FORMAT;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--path")) {
                stringPath = args[i + 1];
            }
            if (args[i].equals("--from")) {
                startDate = LocalDate.parse(args[i + 1], DateTimeFormatter.ISO_LOCAL_DATE);
            }
            if (args[i].equals("--to")) {
                finalDate = LocalDate.parse(args[i + 1], DateTimeFormatter.ISO_LOCAL_DATE);
            }
            if (args[i].equals("--format")) {
                stringFormat = args[i + 1];
            }
        }
        List<Log> logList = new ArrayList<>();
        List<Path> pathList = new ArrayList<>();
        if (stringPath != null && stringPath.matches("^https?:.*")) {
            URI uri = URI.create(stringPath);
            logList = LogReader.read(uri);
        } else {
            pathList = PathFinder.findPath(stringPath);
            for (Path path : pathList) {
                logList.addAll(LogReader.read(path));
            }
        }
        LocalDate finalStartDate = startDate;
        LocalDate finalFinalDate = finalDate;
        logList = logList.stream()
            .filter(log ->
                log.time().isAfter(OffsetDateTime.of(finalStartDate, LocalTime.MIN, ZoneOffset.UTC))
                    && log.time().isBefore(OffsetDateTime.of(finalFinalDate, LocalTime.MAX, ZoneOffset.UTC)))
            .toList();
        stringFormat = switch (stringFormat) {
            case "markdown" -> ".md";
            case "adoc" -> ".adoc";
            default -> DEFAULT_FILE_FORMAT;
        };
        FileCreator.createFileWithStats(stringFormat, logList, pathList, startDate, finalDate);
    }
}

package edu.project3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileCreator {
    private FileCreator() {
    }

    private final static String FORMAT_TO_HAVE_THOUSANDS_SEPARATOR = "%,d";
    private final static String QUANTITY_COLUMN_NAME = "Количество";
    private final static String COLUMNS_OF_THE_SAME_WIDTH = "%1$";
    private static List<Path> pathList;
    private static LocalDate startDate;
    private static LocalDate finalDate;
    private static List<Log> logList;
    private static List<String> firstColumn;
    private static List<String> secondColumn;
    private final static Logger LOGGER = LogManager.getLogger();
    private static StringBuilder stringBuilder;

    public static String createFileWithStats(
        String fileFormat,
        List<Log> logList,
        List<Path> pathList,
        LocalDate startDate,
        LocalDate finalDate) {
        FileCreator.pathList = pathList;
        FileCreator.startDate = startDate;
        FileCreator.finalDate = finalDate;
        FileCreator.logList = logList;
        stringBuilder = new StringBuilder();
        FileCreator.firstColumn = new ArrayList<>();
        FileCreator.secondColumn = new ArrayList<>();
        addGeneralInfo();
        addRequestedResources();
        addResponseCodes();
        addUserAgents();
        addRequests();
        Path path = Paths.get("src\\main\\resources\\project3\\result" + fileFormat);
        if (!Files.isWritable(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                LOGGER.info("Couldn't create a file");
            }
        }
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    private static int findColumnWidth(List<String> allStrings) {
        return allStrings.stream().max(Comparator.comparing(String::length)).orElse("d").length();
    }

    private static void writeOneCell(String string, int width) {
        stringBuilder.append(" ");
        stringBuilder.append(String.format(COLUMNS_OF_THE_SAME_WIDTH + width + "s", string));
        stringBuilder.append(" ");
        stringBuilder.append("|");
    }

    private static void writeDivider(int width) {
        stringBuilder.append(":");
        stringBuilder.append(String
            .format(COLUMNS_OF_THE_SAME_WIDTH + width + "s", " ")
            .replace(' ', '-'));
        stringBuilder.append(":");
        stringBuilder.append("|");
    }

    private static void createTable(
        List<String> firstColumn, int widthOfFirstColumn,
        List<String> secondColumn, int widthOfSecondColumn) {
        for (int i = 0; i < firstColumn.size(); i++) {
            stringBuilder.append("|");
            writeOneCell(firstColumn.get(i), widthOfFirstColumn);
            writeOneCell(secondColumn.get(i), widthOfSecondColumn);
            stringBuilder.append("\n");
            if (i == 0) {
                stringBuilder.append("|");
                writeDivider(widthOfFirstColumn);
                writeDivider(widthOfSecondColumn);
                stringBuilder.append("\n");
            }
        }
    }

    private static void createTable(
        List<String> firstColumn, int widthOfFirstColumn,
        List<String> secondColumn, int widthOfSecondColumn,
        List<String> thirdColumn, int widthOfThirdColumn) {
        for (int i = 0; i < firstColumn.size(); i++) {
            stringBuilder.append("|");
            writeOneCell(firstColumn.get(i), widthOfFirstColumn);
            writeOneCell(secondColumn.get(i), widthOfSecondColumn);
            writeOneCell(thirdColumn.get(i), widthOfThirdColumn);
            stringBuilder.append("\n");
            if (i == 0) {
                stringBuilder.append("|");
                writeDivider(widthOfFirstColumn);
                writeDivider(widthOfSecondColumn);
                writeDivider(widthOfThirdColumn);
                stringBuilder.append("\n");
            }
        }
    }

    private static void addGeneralInfo() {
        stringBuilder.append("### Общая информация:").append(System.lineSeparator()).append(System.lineSeparator());
        firstColumn.add("Метрика");
        firstColumn.add("Файл(-ы)");
        firstColumn.add("Начальная дата");
        firstColumn.add("Конечная дата");
        firstColumn.add("Количество запросов");
        firstColumn.add("Средний размер ответа");
        int widthOfFirstColumn = findColumnWidth(firstColumn);
        secondColumn.add("Значение");
        if (!pathList.isEmpty()) {
            secondColumn.add(pathList.stream()
                .map(path -> path.getFileName().toString())
                .collect(Collectors.joining(", ")));
        } else {
            secondColumn.add("-");
        }
        if (startDate != LocalDate.MIN) {
            secondColumn.add(startDate.toString());
        } else {
            secondColumn.add("-");
        }
        if (finalDate != LocalDate.MAX) {
            secondColumn.add(finalDate.toString());
        } else {
            secondColumn.add("-");
        }
        secondColumn.add(String.format(Locale.ENGLISH, FORMAT_TO_HAVE_THOUSANDS_SEPARATOR, logList.size()));
        secondColumn.add(String.format("%.0f", StatAnalyser.averageAnswerSize(logList)) + " b");
        int widthOfSecondColumn = findColumnWidth(secondColumn);
        createTable(firstColumn, widthOfFirstColumn, secondColumn, widthOfSecondColumn);
        firstColumn.clear();
        secondColumn.clear();
    }

    private static void addRequestedResources() {
        stringBuilder.append("\n### Запрашиваемые ресурсы: \n \n");
        Map<String, Integer> map = StatAnalyser.mostCommonResources(logList);
        firstColumn.add("Ресурсы");
        secondColumn.add(QUANTITY_COLUMN_NAME);
        firstColumn.addAll(map.keySet());
        int widthOfFirstColumn = findColumnWidth(firstColumn);
        secondColumn.addAll(map.values().stream()
            .map(integer -> String.format(Locale.ENGLISH, FORMAT_TO_HAVE_THOUSANDS_SEPARATOR, integer))
            .toList());
        int widthOfSecondColumn = findColumnWidth(secondColumn);
        createTable(firstColumn, widthOfFirstColumn, secondColumn, widthOfSecondColumn);
        firstColumn.clear();
        secondColumn.clear();
    }

    private static void addResponseCodes() {
        stringBuilder.append("\n### Коды ответа: \n \n");
        Map<Integer, Integer> mapIntInt = StatAnalyser.mostCommonResponses(logList);
        firstColumn.add("Код");
        secondColumn.add("Сообщение");
        List<String> thirdColumn = new ArrayList<>();
        thirdColumn.add(QUANTITY_COLUMN_NAME);
        firstColumn.addAll(mapIntInt.keySet().stream().map(String::valueOf).toList());
        int widthOfFirstColumn = findColumnWidth(firstColumn);
        secondColumn.addAll(mapIntInt.keySet().stream().map(Log::getResponseMessage).toList());
        int widthOfSecondColumn = findColumnWidth(secondColumn);
        thirdColumn.addAll(mapIntInt.values().stream()
            .map(integer -> String.format(Locale.ENGLISH, FORMAT_TO_HAVE_THOUSANDS_SEPARATOR, integer))
            .toList());
        int widthOfThirdColumn = findColumnWidth(thirdColumn);
        createTable(firstColumn, widthOfFirstColumn,
            secondColumn, widthOfSecondColumn,
            thirdColumn, widthOfThirdColumn);
        firstColumn.clear();
        secondColumn.clear();
    }

    private static void addUserAgents() {
        stringBuilder.append("\n### Юзер агенты: \n \n");
        Map<String, Integer> map = StatAnalyser.mostCommonUserAgents(logList);
        firstColumn.add("Агенты");
        secondColumn.add(QUANTITY_COLUMN_NAME);
        firstColumn.addAll(map.keySet());
        int widthOfFirstColumn = findColumnWidth(firstColumn);
        secondColumn.addAll(map.values().stream()
            .map(integer -> String.format(Locale.ENGLISH, FORMAT_TO_HAVE_THOUSANDS_SEPARATOR, integer))
            .toList());
        int widthOfSecondColumn = findColumnWidth(secondColumn);
        createTable(firstColumn, widthOfFirstColumn, secondColumn, widthOfSecondColumn);
        firstColumn.clear();
        secondColumn.clear();
    }

    private static void addRequests() {
        stringBuilder.append("\n### Запросы: \n \n");
        Map<String, Integer> map = StatAnalyser.mostCommonRequest(logList);
        firstColumn.add("Код запроса");
        secondColumn.add(QUANTITY_COLUMN_NAME);
        firstColumn.addAll(map.keySet());
        int widthOfFirstColumn = findColumnWidth(firstColumn);
        secondColumn.addAll(map.values().stream()
            .map(integer -> String.format(Locale.ENGLISH, FORMAT_TO_HAVE_THOUSANDS_SEPARATOR, integer))
            .toList());
        int widthOfSecondColumn = findColumnWidth(secondColumn);
        createTable(firstColumn, widthOfFirstColumn, secondColumn, widthOfSecondColumn);
        firstColumn.clear();
        secondColumn.clear();
    }
}

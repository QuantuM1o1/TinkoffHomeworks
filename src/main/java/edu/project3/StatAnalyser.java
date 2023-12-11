package edu.project3;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatAnalyser {
    private StatAnalyser() {
    }

    private static final int FIRST_N_FOR_STATS = 3;

    public static double averageAnswerSize(List<Log> logList) {
        return logList.stream().mapToInt(Log::bytesSent).average().orElse(0d);
    }

    public static Map<String, Integer> mostCommonResources(List<Log> logList) {
        return logList.stream()
            .collect(Collectors
                .groupingBy(Log::requestAddress, Collectors
                    .summingInt(value -> 1)))
            .entrySet().stream()
            .sorted(
            Map.Entry.<String, Integer>comparingByValue()
                .reversed())
            .limit(FIRST_N_FOR_STATS)
            .collect(Collectors
                .toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new
        ));
    }

    public static Map<Integer, Integer> mostCommonResponses(List<Log> logList) {
        return logList.stream()
            .collect(Collectors
                .groupingBy(Log::responseCode, Collectors
                    .summingInt(value -> 1)))
            .entrySet().stream()
            .sorted(
                Map.Entry.<Integer, Integer>comparingByValue()
                    .reversed())
            .limit(FIRST_N_FOR_STATS)
            .collect(Collectors
                .toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new
                ));
    }

    public static Map<String, Integer> mostCommonUserAgents(List<Log> logList) {
        return logList.stream()
            .collect(Collectors
                .groupingBy(Log::userAgent, Collectors
                    .summingInt(value -> 1)))
            .entrySet().stream()
            .sorted(
                Map.Entry.<String, Integer>comparingByValue()
                    .reversed())
            .limit(FIRST_N_FOR_STATS)
            .collect(Collectors
                .toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new
                ));
    }

    public static Map<String, Integer> mostCommonRequest(List<Log> logList) {
        return logList.stream()
            .collect(Collectors
                .groupingBy(Log::status, Collectors
                    .summingInt(value -> 1)))
            .entrySet().stream()
            .sorted(
                Map.Entry.<String, Integer>comparingByValue()
                    .reversed())
            .limit(FIRST_N_FOR_STATS)
            .collect(Collectors
                .toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new
                ));
    }
}

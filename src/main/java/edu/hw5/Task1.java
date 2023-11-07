package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Task1 {
    public static final int MINUTES_IN_HOUR = 60;
    public static final String PATTERN_FOR_FORMATTER = "yyyy-MM-dd, HH:mm";

    private Task1() {
    }

    public static String averageTime(List<String> input) {
        Duration sum = Duration.ofDays(0);
        for (String string : input) {
            String[] array = string.split(" - ");
            String string1 = array[0];
            String string2 = array[1];
            LocalDateTime time1;
            LocalDateTime time2;
            try {
                time1 = LocalDateTime.parse(string1, DateTimeFormatter.ofPattern(PATTERN_FOR_FORMATTER));
                time2 = LocalDateTime.parse(string2, DateTimeFormatter.ofPattern(PATTERN_FOR_FORMATTER));
            } catch (DateTimeParseException e) {
                return "Input can't be parsed";
            }
            if (time1.isAfter(time2)) {
                return "Input returns negative answer";
            }
            Duration duration = Duration.between(time1, time2);
            duration = duration.dividedBy(input.size());
            sum = sum.plus(duration);
        }
        return sum.toHours() + "ч " + sum.toMinutes() % MINUTES_IN_HOUR + "м";
    }
}

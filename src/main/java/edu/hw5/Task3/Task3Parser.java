package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class Task3Parser {
    private Task3Parser() {
    }

    public static Optional<LocalDate> parseDate(String string) {
        StringToDateParser parser = StringToDateParser.link(
            new DayMonthYear2digitsParser(),
            new DayMonthYearParser(),
            new DaysAgoParser(),
            new TodayParser(),
            new TomorrowParser(),
            new YearMonthDayParser(),
            new YesterdayParser());
        return parser.parse(string);
    }
}

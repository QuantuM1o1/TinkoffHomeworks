package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class YearMonthDayParser extends StringToDateParser {
    @Override
    public Optional<LocalDate> parse(String input) {
        try {
            return Optional.of(LocalDate.parse(input, DateTimeFormatter.ofPattern("y-M-d")));
        } catch (DateTimeParseException exception) {
            return parseNext(input);
        }
    }
}

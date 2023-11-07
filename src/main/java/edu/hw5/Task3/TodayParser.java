package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class TodayParser extends StringToDateParser {
    @Override
    public Optional<LocalDate> parse(String input) {
        if ("today".equals(input)) {
            return Optional.of(LocalDate.now());
        } else {
            return parseNext(input);
        }
    }
}

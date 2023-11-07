package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class YesterdayParser extends StringToDateParser {
    @Override
    public Optional<LocalDate> parse(String input) {
        if ("yesterday".equals(input)) {
            return Optional.of(LocalDate.now().minusDays(1));
        } else {
            return parseNext(input);
        }
    }
}

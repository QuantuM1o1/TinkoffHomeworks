package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class TomorrowParser extends StringToDateParser {
    @Override
    public Optional<LocalDate> parse(String input) {
        if ("tomorrow".equals(input)) {
            return Optional.of(LocalDate.now().plusDays(1));
        } else {
            return parseNext(input);
        }
    }
}

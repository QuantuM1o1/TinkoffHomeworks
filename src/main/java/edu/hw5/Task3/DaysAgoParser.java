package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class DaysAgoParser extends StringToDateParser {
    @Override
    public Optional<LocalDate> parse(String input) {
        if (input.matches("^\\d+ day(s)? ago$")) {
            String[] inputSplitted = input.split(" ");
            int numberOfDays = Integer.parseInt(inputSplitted[0]);
            return Optional.of(LocalDate.now().minusDays(numberOfDays));
        } else {
            return parseNext(input);
        }
    }
}

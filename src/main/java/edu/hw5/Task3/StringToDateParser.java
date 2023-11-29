package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class StringToDateParser {
    private StringToDateParser next;

    public static StringToDateParser link(StringToDateParser first, StringToDateParser... chain) {
        StringToDateParser head = first;
        for (StringToDateParser nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract Optional<LocalDate> parse(String input);

    protected Optional<LocalDate> parseNext(String input) {
        if (next == null) {
            return Optional.empty();
        }
        return next.parse(input);
    }
}

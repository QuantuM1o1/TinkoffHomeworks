package edu.project3;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogCreator {
    private final static char END_OF_LINE = '\n';
    private final StringBuilder stringBuilder;
    private final List<Log> logList;

    public LogCreator() {
        logList = new ArrayList<>();
        stringBuilder = new StringBuilder();
    }

    void createLogs(char c) {
        Pattern pattern = Pattern.compile(
            "^(.+) - (.+) \\[(.+)] \"(.+) (/.+) H.+\" (\\d+) (\\d+) \"(.+)\" \"(.+)\"$");
        Matcher matcher;
        if (c == END_OF_LINE) {
            String log = stringBuilder.toString();
            stringBuilder.setLength(0);
            matcher = pattern.matcher(log);
            if (matcher.find()) {
                int i = 1;
                logList.add(new Log(
                    matcher.group(i++),
                    matcher.group(i++),
                    OffsetDateTime.parse(matcher.group(i++),
                        DateTimeFormatter.ofPattern("d/MMM/y:H:m:s xx").withLocale(Locale.ENGLISH)),
                    matcher.group(i++),
                    matcher.group(i++),
                    Integer.parseInt(matcher.group(i++)),
                    Integer.parseInt(matcher.group(i++)),
                    matcher.group(i++),
                    matcher.group(i)));
            }
        } else {
            stringBuilder.append(c);
        }
    }

    public List<Log> getLogList() {
        return logList;
    }
}

package edu.project3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ArgumentParser {
    private String stringPath = null;
    private LocalDate startDate = LocalDate.MIN;
    private  LocalDate finalDate = LocalDate.MAX;
    private String stringFormat = ".txt";


    public ArgumentParser(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--path")) {
                stringPath = args[i + 1];
            }
            if (args[i].equals("--from")) {
                startDate = LocalDate.parse(args[i + 1], DateTimeFormatter.ISO_LOCAL_DATE);
            }
            if (args[i].equals("--to")) {
                finalDate = LocalDate.parse(args[i + 1], DateTimeFormatter.ISO_LOCAL_DATE);
            }
            if (args[i].equals("--format")) {
                stringFormat = args[i + 1];
            }
        }
    }

    public String parsePath() {
        return  stringPath;
    }

    public LocalDate parseStartDate() {
        return startDate;
    }

    public LocalDate parseFinalDate() {
        return finalDate;
    }

    public String parseFormat() {
        return stringFormat;
    }
}

package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static final int DATE_WE_ARE_SEARCHING = 13;

    private Task2() {
    }

    public static List<LocalDate> allFridays13thOfTheYear(int year) {
        List<LocalDate> datesOfFridays13th = new ArrayList<>();
        for (Month eachMonth : Month.values()) {
            if (LocalDate.of(year, eachMonth, DATE_WE_ARE_SEARCHING).getDayOfWeek() == DayOfWeek.FRIDAY) {
                datesOfFridays13th.add(LocalDate.of(year, eachMonth, DATE_WE_ARE_SEARCHING));
            }
        }
        return datesOfFridays13th;
    }

    public static LocalDate nextFriday13th(LocalDate currentDate) {
        List<LocalDate> list = allFridays13thOfTheYear(currentDate.getYear());
        LocalDate nextFriday;
        for (LocalDate date : list) {
            if (date.isAfter(currentDate)) {
                nextFriday = (LocalDate) date.adjustInto(currentDate);
                return nextFriday;
            }
        }
        list = allFridays13thOfTheYear(currentDate.plusYears(1).getYear());
        nextFriday = (LocalDate) list.get(0).adjustInto(currentDate);
        return nextFriday;
    }
}

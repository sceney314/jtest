package jdk8.riqi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-18 11:16
 * Description:
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019, 6, 18);
        System.out.println(date);

        int year = date.getYear();
        System.out.println(year);

        Month month = date.getMonth();
        System.out.println(month);

        int day = date.getDayOfMonth();
        System.out.println(day);

        DayOfWeek dow = date.getDayOfWeek();
        System.out.println(dow);

        System.out.println("day of year " + date.getDayOfYear());
        System.out.println("toEpochDay " + date.toEpochDay());
        System.out.println("now " + LocalDate.now().toString());
        System.out.println("year " + date.get(ChronoField.YEAR));

        int len = date.lengthOfMonth();
        System.out.println(len);

        boolean leap = date.isLeapYear();
        System.out.println(leap);

    }
}

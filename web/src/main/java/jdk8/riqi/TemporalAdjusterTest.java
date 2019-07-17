package jdk8.riqi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-18 20:55
 * Description:
 */
public class TemporalAdjusterTest {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2019, 6, 18);
        LocalDate date12 = date1.plusDays(1);
        System.out.println("date12 - " + date12);
        System.out.println("date12 - " + date12.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("date12 - " + date12.format(DateTimeFormatter.BASIC_ISO_DATE));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("date12 - " + date12.format(formatter));

        LocalDate date2 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        System.out.println(date2);
        LocalDate date3 = date2.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(date3);

        System.out.println("dayOfWeekInMonth : " + date1.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.FRIDAY)));
        System.out.println("firstDayOfMonth : " + date1.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("firstDayOfNextMonth : " + date1.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println("firstDayOfYear : " + date1.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("firstDayOfNextYear : " + date1.with(TemporalAdjusters.firstDayOfNextYear()));
        System.out.println("firstInMonth : " + date1.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY)));
        System.out.println("lastDayOfMonth : " + date1.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("lastDayOfYear : " + date1.with(TemporalAdjusters.lastDayOfYear()));
        System.out.println("lastInMonth : " + date1.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY)));
        System.out.println("next : " + date1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));
        System.out.println("previous : " + date1.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)));
        System.out.println("nextOrSame : " + date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)));
        System.out.println("previousOrSame : " + date1.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY)));
    }
}

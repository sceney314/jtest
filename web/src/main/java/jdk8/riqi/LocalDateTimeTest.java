package jdk8.riqi;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-18 11:35
 * Description:
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019, 6, 18);
        LocalTime time = LocalTime.of(13, 45, 20);
        LocalDateTime dt1 = LocalDateTime.of(2019, Month.JUNE, 18, 13, 45, 20);
        System.out.println(dt1.toString());
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        System.out.println(dt2);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        System.out.println(dt3);
        LocalDateTime dt4 = date.atTime(time);
        System.out.println(dt4);
        LocalDateTime dt5 = time.atDate(date);
        System.out.println(dt5);

        Instant instant = Instant.ofEpochSecond(3);
        System.out.println(Instant.now().get(ChronoField.NANO_OF_SECOND));
        System.out.println(Instant.now().get(ChronoField.MICRO_OF_SECOND));
        System.out.println(Instant.now().get(ChronoField.MILLI_OF_SECOND));
        System.out.println(Instant.now());

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        LocalDateTime ld2 = ldt.plusDays(22L).withHour(15).withMinute(0).withSecond(0);
        System.out.println(ld2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2019-09-09 23:45:23", formatter);
        System.out.println(dateTime);
    }
}

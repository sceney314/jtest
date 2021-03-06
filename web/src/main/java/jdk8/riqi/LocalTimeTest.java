package jdk8.riqi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-18 11:33
 * Description:
 */
public class LocalTimeTest {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(13, 2, 20);
        System.out.println(time);

        int hour = time.getHour();
        System.out.println("hour" + hour);

        int minute = time.getMinute();
        System.out.println("minute" + minute);

        int second = time.getSecond();
        System.out.println("second" + second);

        LocalDate date = LocalDate.parse("2014-03-18");
        System.out.println(date);
        LocalTime time1 = LocalTime.parse("13:45:20");
        System.out.println(time1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(LocalTime.parse("13:45:20", formatter));

    }
}

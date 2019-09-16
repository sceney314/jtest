package jdk8.riqi;


import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-18 11:16
 * Description:
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019, 8, 16);
        LocalDate ld = date.plusDays(0);
        System.out.println(ld.toString());
        System.out.println(date.toString());
        System.out.println("周" + date.getDayOfWeek().getValue());

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


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM月dd日");
        System.out.println(LocalDate.now().format(formatter));

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println(LocalTime.now().format(formatter2));

        LocalDate ddd = LocalDate.parse("2019-08-16");
        System.out.println(ddd);

        LocalDate localDate = LocalDate.of(2019, 8, 16);
        LocalTime localTime = LocalTime.of(23, 59, 59);

        Date d = mergeDateTime(localDate, localTime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(d));
    }

    public static Date setDate(Date date, Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer second, Integer milliSecond){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (year != null){
            cal.set(Calendar.YEAR, year);
        }

        if (month != null){
            cal.set(Calendar.DECEMBER, month - 1);
        }

        if (day != null){
            cal.set(Calendar.DAY_OF_MONTH, day);
        }

        if (hour != null){
            cal.set(Calendar.HOUR_OF_DAY, hour);
        }

        if (minute != null){
            cal.set(Calendar.MINUTE, minute);
        }

        if (second != null){
            cal.set(Calendar.SECOND, second);
        }

        if (milliSecond != null){
            cal.set(Calendar.MILLISECOND, milliSecond);
        }

        return cal.getTime();
    }

    /**
     * 合并 LocalDate 和 LocalTime 这两个对象
     * @param localDate LocalDate对象
     * @param localTime LocalTime对象
     * @return Date
     */
    public static Date mergeDateTime(LocalDate localDate, LocalTime localTime){
        return setDate(new Date(), localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth(), localTime.getHour(), localTime.getMinute(), localTime.getSecond(), 0);
    }
}

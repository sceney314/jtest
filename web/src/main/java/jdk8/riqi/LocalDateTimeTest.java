package jdk8.riqi;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-18 11:35
 * Description:
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        System.out.println((nextDay().getTime() - System.currentTimeMillis()) / 1000L);
    }

    /**
     * 获取今日凌晨日期
     * @return Date
     */
    public static Date today(){
        return dayZeroPoint(new Date());
    }

    /**
     * 某天零点
     * @param date
     * @return
     */
    public static Date dayZeroPoint(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 时间增减
     *
     * @param date     Date
     * @param field    int
     * @param interval int
     * @return Date
     */
    public static Date addDate(Date date, int field, int interval) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, interval);
        return cal.getTime();
    }

    /**
     * 获取明日凌日期
     * @return Date
     */
    public static Date nextDay(){
        return addDate(today(), Calendar.DAY_OF_MONTH, 1);
    }
}

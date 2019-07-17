package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) {
        String ss = "2019-04-02 23:12:35";
        Date date = parseDateTime(ss);
        System.out.println(datetimeFormat(date));
        System.out.println(dateFormat(parseDate(ss)));
        System.out.println(timeFormat(parseTime(ss)));
    }

    public static Date parseDateTime(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.parse(date);
        }catch (Exception e){
            return null;
        }
    }

    public static Date parseDate(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(date);
        }catch (Exception e){
            return null;
        }
    }

    public static Date parseTime(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            return dateFormat.parse(date);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 格式化催记，默认 yyyy-mm-dd hh:ii:ss 格式
     * @param date 日期
     * @return String
     */
    public static String datetimeFormat(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    /**
     * 格式化催记，默认 yyyy-mm-dd hh:ii:ss 格式
     * @param date 日期
     * @return String
     */
    public static String dateFormat(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    /**
     * 格式化催记，默认 yyyy-mm-dd hh:ii:ss 格式
     * @param date 日期
     * @return String
     */
    public static String timeFormat(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(date);
    }


}

package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) {

        System.out.println("    today:" + datetimeFormat(today()));
        System.out.println("  nextDay:" + datetimeFormat(nextDay()));
        System.out.println("yesterday:" + datetimeFormat(yesterday()));
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

    public static Date addDate(Date date, int field, int interval) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, interval);
        return cal.getTime();
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
     * 获取明日凌日期
     * @return Date
     */
    public static Date nextDay(){
        return addDate(today(), Calendar.DAY_OF_MONTH, 1);
    }

    /**
     * 获取昨日凌日期
     * @return Date
     */
    public static Date yesterday() {
        return addDate(today(), Calendar.DAY_OF_MONTH, -1);
    }


}

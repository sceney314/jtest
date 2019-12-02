package jdk8.riqi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestRiqi {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        calendar.add(Calendar.MONTH, 1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(calendar.getTime()));

        System.out.println((int) Math.ceil(0.04));
    }
}

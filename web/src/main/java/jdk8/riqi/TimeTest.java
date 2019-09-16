package jdk8.riqi;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengzp
 * 2019-09-10 15:07
 */
public class TimeTest {
    private static List<Shijian> jians = new ArrayList<>();
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static {
        Shijian jian1 = new Shijian();
        jian1.setStart(LocalDateTime.now().withHour(9).withMinute(0).withSecond(0).with(ChronoField.MILLI_OF_SECOND, 0));
        jian1.setEnd(LocalDateTime.now().withHour(12).withMinute(0).withSecond(0).with(ChronoField.MILLI_OF_SECOND, 0));

        Shijian jian2 = new Shijian();
        jian2.setStart(LocalDateTime.now().withHour(15).withMinute(0).withSecond(0).with(ChronoField.MILLI_OF_SECOND, 0));
        jian2.setEnd(LocalDateTime.now().withHour(18).withMinute(0).withSecond(0).with(ChronoField.MILLI_OF_SECOND, 0));

        jians.add(jian1);
        jians.add(jian2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 24; i++){
            LocalDateTime start = LocalDateTime.now().withHour(i).withMinute(0).withSecond(0).with(ChronoField.MILLI_OF_SECOND, 0);
            for (int j = i + 1; j < 24; j++){
                LocalDateTime end = LocalDateTime.now().withHour(j).withMinute(0).withSecond(0).with(ChronoField.MILLI_OF_SECOND, 0);
                checkTime(start, end);
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void checkTime(LocalDateTime start, LocalDateTime end){
//        String content = start.format(format) + " - " + end.format(format);
        String content = start.toLocalTime().toString() + " - " + end.toLocalTime().toString();
        System.out.printf("%s", content );
        for (Shijian shijian : jians){
            if (start.compareTo(shijian.getStart()) >= 0 && end.compareTo(shijian.getEnd()) <= 0){
                System.out.printf("%s", ", 重叠");
                break;
            }

            if (start.compareTo(shijian.getStart()) >= 0 && start.compareTo(shijian.getEnd()) < 0){
                System.out.printf("%s", ", 重叠");
                break;
            }

            if (end.compareTo(shijian.getStart()) > 0 && end.compareTo(shijian.getEnd()) <= 0){
                System.out.printf("%s", ", 重叠");
                break;
            }


            if (shijian.getStart().compareTo(start) >= 0 && shijian.getEnd().compareTo(end) <= 0){
                System.out.printf("%s", ", 重叠");
                break;
            }

            if (shijian.getStart().compareTo(start) >= 0 && shijian.getStart().compareTo(end) < 0){
                System.out.printf("%s", ", 重叠");
                break;
            }

            if (shijian.getEnd().compareTo(start) > 0 && shijian.getEnd().compareTo(start) <= 0){
                System.out.printf("%s", ", 重叠");
                break;
            }
        }

        System.out.println(", 判断结束");
    }

}

@Data
class Shijian{
    private LocalDateTime start;
    private LocalDateTime end;

}
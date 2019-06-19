package jdk8.riqi;

import com.google.common.collect.Lists;
import lombok.Data;

import java.time.*;
import java.time.temporal.ChronoField;
import java.util.*;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-06-18 11:35
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

//        Map<String, DD> zmmap = new HashMap<>();
//        zmmap.put("a", new DD("a"));
//        zmmap.put("d", new DD("d"));
//        zmmap.put("b", new DD("b"));
//        zmmap.put("cd", new DD("c"));
//
//        Set<String> ss = new HashSet<>();
//        ss.add("a");
//        ss.add("b");
//        ss.add("c");
//        ss.add("d");
//
//        zmmap.keySet().removeAll(ss);
//        System.out.println(zmmap);
//        List<DD> dd = Lists.newArrayList(zmmap.values());
//        System.out.println(dd);
    }
}


@Data
class DD{
    private String name;

    public DD(String name) {
        this.name = name;
    }
}

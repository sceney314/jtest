package test;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-12 17:05
 * Description:
 */
public class LeanTest {

    public static void main(String[] args) {
        List<String> ids = new ArrayList<>();
        ids.add("a");
        ids.add("b");
        ids.add("c");
        ids.add("d");
        for (int i = 0; i < 4; i++){
            System.out.println(ids.remove(0));
        }



        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        System.out.println(format.format(now));
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.MINUTE, -1);
        System.out.println(format.format(cal.getTime()));
        System.out.println(cal.getTime().compareTo(now));

        Peson peson = new Peson();
        peson.setName("张三");
        peson.setBirthday(new Date());

        String json = "{\"birthday\":1562055138,\"name\":\"张三\"}";
        Peson peson1 = JSON.parseObject(json, Peson.class);
        System.out.println(peson1);

        Student student = new Student();
        student.setName("张三");
        student.setNumber("1");
        student.setSchool("哄时代峰峻啦");

        try {
            Student nstu = (Student)student.clone();
            nstu.setSchool("sjfldfs");
            nstu.setNumber("2");
            nstu.setName("李四");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(student);
    }

}

@Data
class Peson{
    private Date birthday;

    private String name;
}

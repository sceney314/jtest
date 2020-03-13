package test.keywords;

import com.alibaba.fastjson.JSON;

/**
 * 2020-03-09 06:35
 */
public class WordTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        user.setAge(12);
        user.setSex("女");
        System.out.println(JSON.toJSONString(user));
    }
}

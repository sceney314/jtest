package json;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-05-29 20:37
 * Description:
 */
public class JsonTest {
    public static void main(String[] args) {
        People people = new People();
        people.setAge("32");
        people.setAliasName("张三");
        people.setIsDel(2);
        people.setTelNo("13245678965");

        System.out.println(JSON.toJSONString(people));

        String json = "{\"age\":\"32\",\"alias_name\":\"张三\",\"is_del\":2,\"tel_no\":\"13245678965\"}";
        Gson gson = new Gson();
        People tmp = gson.fromJson(json, People.class);
        System.out.println(tmp);
    }
}

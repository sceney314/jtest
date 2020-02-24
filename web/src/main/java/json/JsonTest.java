package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-05-29 20:37
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

        Sms sms = new Sms();
        System.out.println(sms);

        Msg<Push> smsMsg = new Msg<>();
        smsMsg.setId(11);
        Push push = new Push();
        push.setContent("test");
        smsMsg.setT(push);


        List<SerializerFeature> featureList = new ArrayList<>();
        featureList.add(SerializerFeature.WriteMapNullValue);
        featureList.add(SerializerFeature.WriteNullNumberAsZero);
        featureList.add(SerializerFeature.WriteNullBooleanAsFalse);
        featureList.add(SerializerFeature.WriteNullStringAsEmpty);
        featureList.add(SerializerFeature.WriteNullListAsEmpty);
        featureList.add(SerializerFeature.QuoteFieldNames);
        SerializerFeature[] features = new SerializerFeature[featureList.size()];
        featureList.toArray(features);

        String json2 = JSON.toJSONString(smsMsg, features);

        Msg<Push> msg = JSON.parseObject(json2, new TypeReference<Msg<Push>>(){});
        System.out.println(msg);

        long d = 1080888293005942785L;
        System.out.println(d % 16);
    }
}

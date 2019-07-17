package file;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-06-27 20:06
 * Description:
 */
public class ReadFileTest {
    public static void main(String[] args) {
        String file = "/data/logs/dhcuiji/test.log";
        Map<String, List<String>> data = new HashMap<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str = "";
            while ((str = in.readLine()) != null) {
                JSONObject json = JSON.parseObject(str);
                String traceId = json.getString("traceid");
                if (data.containsKey(traceId)){
                    data.get(traceId).add(str);
                }else{
                    List<String> tmp = new ArrayList<>();
                    tmp.add(str);
                    data.put(traceId, tmp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(data);
    }
}

package test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public abstract class Water {
    protected static List<Integer> biz = new ArrayList<>();

    public String getBiz(){
        return JSON.toJSONString(biz);
    }
}

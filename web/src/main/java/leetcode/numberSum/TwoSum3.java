package leetcode.numberSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和 3 - 设计数据结构
 *
 * 描述:设计b并实现一个 TwoSum 类。他需要支持以下操作:add 和 find。
 *
 * add -把这个数添加到内部的数据结构。
 *
 * find -是否存在任意一对数字之和等于这个值
 *
 * @author zhengzp
 * 2019-12-09 20:32
 */
public class TwoSum3 {
    private static Integer index = 0;
    private Map<Integer, Integer> dataMap = new HashMap<>();

    public void add(Integer elem){
        dataMap.put(elem, index);
        index++;
    }

    public boolean find(Integer target){
        for (Map.Entry<Integer, Integer> entry : dataMap.entrySet()){
            Integer next = target - entry.getKey();
            if (dataMap.containsKey(next)){
                return true;
            }
        }

        return false;
    }

}

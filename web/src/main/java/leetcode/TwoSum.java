package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author zhengzp
 * 2019-12-06 20:11
 */
public class TwoSum {

    public static void main(String[] args) {
        Integer[] elems = new Integer[]{2, 7, 11, 15};
        Integer target = 17;
        System.out.println(twoSum(elems, target));
        System.out.println(twoSum2(elems, target));
    }

    public static List<Integer> twoSum(Integer[] elems, Integer target){
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < elems.length; i++){
            numberMap.put(elems[i], i);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < elems.length; i++){
            Integer next = target - elems[i];
            if (numberMap.containsKey(next)){
                result.add(i);
                result.add(numberMap.get(next));
                break;
            }
        }

        return result;
    }

    public static List<Integer> twoSum2(Integer[] elems, Integer target){
        Map<Integer, Integer> numberMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < elems.length; i++){
            Integer next = target - elems[i];
            if (numberMap.containsKey(next)){
                result.add(i);
                result.add(numberMap.get(next));
                break;
            }
            numberMap.put(elems[i], i);
        }

        return result;
    }
}

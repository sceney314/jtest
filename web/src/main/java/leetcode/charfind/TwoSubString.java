package leetcode.charfind;

import java.util.HashMap;
import java.util.Map;

/**
 * 至多包含两个不同字符的最长子串
 *
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t 。
 *
 * 示例：
 * 例 1:
 * 输入: “eceba”
 * 输出: 3
 * 解释: t 是 “ece”，长度为3。
 *
 * 例 2:
 * 输入: “ccaabbb”
 * 输出: 5
 * 解释: t 是 “aabbb”，长度为5。
 */
public class TwoSubString {

    public static void main(String[] args) {
        System.out.println(twoChars("ssss"));
    }

    public static int twoChars(String s){
        if (s == null || s.length() < 1){
            return 0;
        }
        int left = 0, right = 0, max = 1;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++){
            map.put(chars[i], map.getOrDefault(chars[i], i));
            if (map.size() > 2){
                int size = i - left;
                left = right;
                right = i;
                max = max < size ? size : max;
                map.remove(chars[left]);
                map.put(chars[i], i);
            }else if (i == chars.length - 1){
                int size = i - left + 1;
                max = max < size ? size : max;
            }

            if (map.size() == 1){
                left = map.getOrDefault(chars[i], i);
            }else if (map.size() == 2){
                right = map.getOrDefault(chars[i], i);
            }
        }

        return max;
    }


}

package leetcode.charfind;

import java.util.HashMap;
import java.util.Map;

/**
 * 至多包含 K 个不同字符的最长子串
 *
 * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 * 示例 1:
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 则 T 为 "ece"，所以长度为 3。
 *
 * 示例 2:
 * 输入: s = "aa", k = 1
 * 输出: 2
 * 解释: 则 T 为 "aa"，所以长度为 2。
 */
public class KString {

    public static void main(String[] args) {
        System.out.println(kDistinctSubString("aa", 1));
    }

    public static int kDistinctSubString(String s, int k){
        int max = 0, left = 0, j = 0;

        char[] elems = new char[k + 1];
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (!map.containsKey(chars[i])){
                elems[j++] = chars[i];
            }

            map.put(chars[i], map.getOrDefault(chars[i], i));
            if (map.size() == 1){
                left = map.get(chars[i]);
            }

            if (map.size() == k + 1){
                int size = i - left;
                map.remove(chars[left]);
                max = max > size ? max : size;
                System.arraycopy(elems, 1, elems, 0, elems.length - 1);
                left = map.get(elems[0]);
                j--;
            }

            if (i == chars.length - 1){
                int size = i - left + 1;
                max = max < size ? size : max;
            }
        }
        return max;
    }
}

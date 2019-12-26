package leetcode.charfind;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class LongestSubstring {

    public static void main(String[] args) {
        String s = "ggububgvfk";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1){
            return 0;
        }
        char[] chars = s.toCharArray();
        int max = 1, left = 0, right = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (; right < chars.length; right++){
            if (!charMap.containsKey(chars[right]) || charMap.get(chars[right]) < left){
                charMap.put(chars[right], right);
                continue;
            }

            if (right - left >= max){
                max = right - left;
            }
            left = charMap.get(chars[right]) + 1;
            charMap.put(chars[right], right);

            if (chars.length - left < max){
                break;
            }
        }

        if (right - left > max){
            max = right - left;
        }

        return max;

//        if (s == null || s.length() < 1){
//            return 0;
//        }
//        char[] chars = s.toCharArray();
//        int max = 1;
//
//        for (int i = 0; i < chars.length - 1; i ++){
//            Map<Character, Character> elems = new HashMap<>();
//            elems.put(chars[i], chars[i]);
//            for (int j = i + 1; j < chars.length; j++){
//                if (!elems.containsKey(chars[j])){
//                    elems.put(chars[j], chars[j]);
//                    continue;
//                }
//                break;
//            }
//            if (elems.size() > max){
//                max = elems.size();
//            }
//        }
//
//        return max;
    }
}

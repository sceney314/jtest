package leetcode.charfind;

import java.util.HashMap;
import java.util.Map;

/**
 * 回文排列
 *
 * 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
 * 示例 1：
 * 输入: "code"
 * 输出: false
 *
 * 示例 2：
 * 输入: "aab"
 * 输出: true
 *
 * 示例 3：
 * 输入: "carerac"
 * 输出: true
 */
public class PalindromePai {
    public static void main(String[] args) {
        System.out.println(canPalindrome("aab"));
        System.out.println(canPalindrome("carerac"));
        System.out.println(canPalindrome("aadgaaaad"));
        System.out.println(canPalindrome("aaaaa"));
        System.out.println(canPalindrome("aavvaa"));
        System.out.println(canPalindrome("aavavvaa"));
        System.out.println(canPalindrome("aa"));
        System.out.println(canPalindrome("b"));
        System.out.println(canPalindrome("abba"));
    }

    public static boolean canPalindrome(String s){
        if (s.length() < 2){
            return true;
        }

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < chars.length; i++){
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
            if (map.get(chars[i]) % 2 == 1){
                j++;
            }else if (map.get(chars[i]) % 2 == 0){
                j--;
            }
        }

        if (j > 1){
            return false;
        }
        return true;
    }
}

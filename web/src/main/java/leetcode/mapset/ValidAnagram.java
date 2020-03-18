package leetcode.mapset;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * 两个字符串中的字母是否一致，只是位置不一样
 * <p>
 * 2020-03-17 06:52
 */
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";

        System.out.println((new ValidAnagram()).isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s == null && t == null){
            return true;
        }

        if (s == null || t == null){
            return false;
        }

        if (s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int i = s.length();
        while (--i >= 0){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            char c2 = t.charAt(i);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() != 0){
                return false;
            }
        }

        return true;
    }
}

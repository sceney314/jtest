package leetcode.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 有效的括号
 * <p>
 * 2020-03-05 19:48
 */
public class Valid {
    public static void main(String[] args) {
        String s = "()";
        System.out.println((new Valid()).isValid(s));
    }

    public boolean isValid(String s) {
        if(s == null || s.trim().length() < 1){
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();
        char[] zifu = s.toCharArray();
        for (int i = 0; i < zifu.length; i++){
            if (stack.isEmpty() && map.containsValue(zifu[i])){
                return false;
            }

            if (map.containsKey(zifu[i])){
                stack.push(zifu[i]);
                continue;
            }

            if (map.get(stack.peek()).equals(zifu[i])){
                stack.pop();
                continue;
            }

            return false;
        }

        return stack.isEmpty();
    }
}

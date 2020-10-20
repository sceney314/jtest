package leetcode.strings;

/**
 * 415. 字符串相加
 *
 * Date: 2020-08-03 14:40
 * Copyright (C), 2015-2020
 */
public class AddStrings {
    public static void main(String[] args) {
        String num1 = "66223434";
        String num2 = "34223434";
        System.out.println(addString(num1, num2));
    }

    public static String addString(String num1, String num2) {
        int m = num1.length(), n = num2.length(), len = Math.max(m, n), i = len - 1;
        char[] c = new char[len];
        int flag = 0;
        while(m > 0 && n > 0){
            int a = num1.charAt(--m) - '0';
            int b = num2.charAt(--n) - '0';
            int tmp = a + b + flag;
            flag = tmp < 10 ? 0 : 1;
            int elem = tmp % 10 + 48;
            c[i--] = (char)elem;
        }

        if(n > 0){
            while (n > 0){
                int b = num2.charAt(--n) - '0';
                int tmp = b + flag;
                flag = tmp < 10 ? 0 : 1;
                int elem = tmp % 10 + 48;
                c[i--] = (char)elem;
            }
        }else if(m > 0){
            while(m > 0){
                int a = num1.charAt(--m) - '0';
                int tmp = a + flag;
                flag = tmp < 10 ? 0 : 1;
                int elem = tmp % 10 + 48;
                c[i--] = (char)elem;
            }
        }

        if (flag == 1){
            return  flag + new String(c);
        }


        return  new String(c);
    }
}

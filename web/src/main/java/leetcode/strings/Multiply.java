package leetcode.strings;

import java.math.BigDecimal;

/**
 * 43. 字符串相乘
 *
 * Date: 2020-08-13 10:25
 * Copyright (C), 2015-2020
 */
public class Multiply {

    public static void main(String[] args) {
        System.out.println(multi("123", "456"));

        System.out.println(fen2Yuan(new Long("1234")));
    }

    /**
     * 分转元,精度:没有小数
     *
     * @param money 钱，单位：分
     * @return String
     */
    public static String fen2Yuan(Long money) {
        if (null == money || money <= 0) {
            return "0";
        }
        BigDecimal fen = new BigDecimal(money);
        BigDecimal mul = new BigDecimal(100);
        return fen.divide(mul, 0, BigDecimal.ROUND_FLOOR).toString();
    }

    public static String multi(String num1, String num2) {
        int m = num1.length(), n = num2.length(), flag = 0;
        String ans = "";

        while(m > 0 && n > 0){
            int l = num1.charAt(--m) - '0';
            int r = num2.charAt(--n) - '0';
            int tmp = l * r + flag;
            flag = tmp / 10;
            ans = tmp % 10 + ans;
        }

        if(m > 0 && n == 0){
            while(m > 0){
                int l = num1.charAt(--m) - '0';
                int tmp = l + flag;
                flag = tmp / 10;
                ans = tmp % 10 + ans;
            }
        }else if(m == 0 && n > 0){
            while(n > 0){
                int l = num1.charAt(--n) - '0';
                int tmp = l + flag;
                flag = tmp / 10;
                ans = tmp % 10 + ans;
            }
        }

        if(flag > 0){
            ans = flag + ans;
        }

        return ans;
    }

}

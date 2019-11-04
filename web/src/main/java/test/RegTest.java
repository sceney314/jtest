package test;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * @author zhengzp
 * 2019-08-01 16:27
 */
public class RegTest {
    public static void main(String[] args) {
//        String regex = "\\d+\\.{0,1}\\d{0,2}";
//        String amount = "345.0";
//        System.out.println(Pattern.matches(regex, amount));
//
//        System.out.println(fen2Yuan(2000_00L));
//        System.out.println(fen2Yuan(2210L));
//
//        Long a = 11L;
//        Long aa = 12L;
//        System.out.println(aa.compareTo(a));
//
//        String con = "我是汉字 we^";
//        System.out.println(con.length());

        String regex = "1\\d{10}";
        String phone = "19997494224";
        System.out.println(Pattern.matches(regex, phone));


    }

    /**
     * 分转元,精度:没有小数
     *
     * @param money 钱，单位：分
     * @return String
     */
    public static String fen2Yuan(Long money) {
        if (null == money || money <= 0) {
            return "0.00";
        }
        BigDecimal fen = new BigDecimal(money);
        BigDecimal mul = new BigDecimal(100);
        return fen.divide(mul, 0, BigDecimal.ROUND_FLOOR).toString();
    }
}

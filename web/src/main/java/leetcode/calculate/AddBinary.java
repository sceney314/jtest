package leetcode.calculate;


/**
 * 二进制求和
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * @author zhengzp
 * 2019-12-11 17:10
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "0", b = "0";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        char[] result = new char[a.length() < b.length() ? b.length() : a.length()];
        int carry = 0, k = result.length - 1;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--, k--){
            int first = i >= 0 ? a.charAt(i) & 1 : 0;
            int second = j >= 0 ? b.charAt(j) & 1 : 0;
            int sum = first ^ second ^ carry;
            result[k] = sum == 1 ? '1' : '0';
            // 结果 0 ，必然 first ^ second 结果和 carry 值一样
            if (sum == 0 && carry == 0 && first == 1){
                carry = 1;
            }else if (sum == 1 && carry == 1 && first == 0){
                carry = 0;
            }
        }

        if (carry == 1){
            return "1" + new String(result);
        }
        return new String(result);
    }
}

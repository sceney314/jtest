package leetcode.calculate;

/**
 * 两整数之和
 *
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 *
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * @author zhengzp
 * 2019-12-12 19:34
 */
public class SumNumber {
    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
    }

    /**
     * 解题思路，两数相加最终表现在二进制上操作就是有进位是 0 没进位是 1 。
     * 1 + 2 = 3
     *   0001
     * + 0010
     * -------
     *   0011
     * 所以加法是一个异或的过程，只需要判断是否有进位，如果有进位则需要进位+1，进位办法 a & b 不等于 0 则表示有进位。
     *
     * 所以计算步骤
     * 1、a ^ b = c
     * 2、a & b = d
     * 3、如果 d = 0 则计算结束，不等于0 则 d 左移一位赋值给 b， c 赋值给 a，重复步骤 1、2
     *
     * @param a 数1
     * @param b 数2
     * @return int
     */
    public static int getSum(int a, int b) {
        while(b != 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}

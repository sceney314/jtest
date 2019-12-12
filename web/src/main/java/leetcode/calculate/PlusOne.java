package leetcode.calculate;

import com.alibaba.fastjson.JSON;

/**
 * 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author zhengzp
 * 2019-12-12 10:09
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = new int[]{9, 8, 1, 9};

        System.out.println(JSON.toJSONString(plus(digits)));
    }

    public static int[] plus(int[] digits) {
        int lastIndex = digits.length - 1;
        if (digits[lastIndex] < 9){
            digits[lastIndex] = digits[lastIndex] + 1;
            return digits;
        }

        int carry = 0;
        for (int i = lastIndex; i >= 0; i--){
            int cur = i == lastIndex ? digits[i] + 1 + carry : digits[i] + carry;
            carry = cur > 9 ? 1: 0;
            digits[i] = carry == 1 ? cur - 10 : cur;
            if (carry == 0){
                return digits;
            }
        }

        // 如果数组长度 +1 则表示最高位是 1 其他是 0
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

package leetcode.numberSum;

/**
 * @author zhengzp
 * 2019-12-09 20:33
 */
public class TwoSumTest {
    public static void main(String[] args) {
        TwoSum3 twoSum3 = new TwoSum3();
        twoSum3.add(2);
        twoSum3.add(7);
        twoSum3.add(11);
        twoSum3.add(15);

        System.out.println(twoSum3.find(9));
        System.out.println(twoSum3.find(16));
    }
}

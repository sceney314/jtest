package leetcode.dynamic;

/**
 * 122. 买卖股票的最佳时机 II
 * <p>
 * 2020-04-05 10:11
 */
public class MaxProfit2 {

    //贪心算法
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println((new MaxProfit2()).maxProfit(prices));
    }
}

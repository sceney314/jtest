package leetcode.dynamic;

/**
 * 121. 买卖股票的最佳时机
 * <p>
 * 2020-04-05 09:31
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                minPrice = prices[i];
                continue;
            }

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > profit) {
                profit = prices[i] - minPrice;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println((new MaxProfit()).maxProfit(prices));
    }
}

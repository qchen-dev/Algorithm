package com.problems.leetcode_stock;

public class Q121BestTimeToBuySellStock {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        // Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 5;
        int actual = sol.maxProfit(prices);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        // Explanation: In this case, no transactions are done and the max profit = 0.
        prices = new int[]{7, 6, 4, 3, 1};
        expected = 0;
        actual = sol.maxProfit(prices);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i]);
                profit = Math.max(profit, prices[i] - min);
            }
            return profit;
        }
    }

}

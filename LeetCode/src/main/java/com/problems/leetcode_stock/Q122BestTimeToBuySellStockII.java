package com.problems.leetcode_stock;

public class Q122BestTimeToBuySellStockII {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        // Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
        // Total profit is 4 + 3 = 7.
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 7;
        int actual = sol.maxProfit(prices);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2:
        // Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
        // Total profit is 4.
        prices = new int[]{1, 2, 3, 4, 5};
        expected = 4;
        actual = sol.maxProfit(prices);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        // Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
        prices = new int[]{7, 6, 4, 3, 1};
        expected = 0;
        actual = sol.maxProfit(prices);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                profit += Math.max(0, prices[i] - prices[i - 1]);
            }
            return profit;
        }
    }

}

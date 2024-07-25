package com.problems.leetcode_stock;

public class Q123BestTimeToBuySellStockIII {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
        // Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int expected = 6;
        int actual = sol.maxProfit(prices);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        // Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
        // Note that you cannot buy on day 1, buy on day 2 and sell them later,
        // as you are engaging multiple transactions at the same time. You must sell before buying again.
        prices = new int[]{1, 2, 3, 4, 5};
        expected = 4;
        actual = sol.maxProfit(prices);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        // Explanation: In this case, no transaction is done, i.e. max profit = 0.
        prices = new int[]{7, 6, 4, 3, 1};
        expected = 0;
        actual = sol.maxProfit(prices);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            // return maxProfit1(prices);
            // return maxProfit2(prices);
            // return maxProfit3(prices);
            return maxProfit4(prices);
        }

        public int maxProfit1(int[] prices) {
            int n = prices.length;
            int[] dp1 = new int[n];
            for (int i = 1, min = prices[0]; i < n; i++) {
                min = Math.min(min, prices[i]);
                dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
            }
            int profit = 0;
            int[] dp2 = new int[n];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    dp2[i] = Math.max(dp2[i], dp1[j] + prices[i] - prices[j]);
                }
                profit = Math.max(profit, dp2[i]);
            }
            return profit;
        }

        public int maxProfit2(int[] prices) {
            int n = prices.length;
            int[] dp1 = new int[n];
            for (int i = 1, min = prices[0]; i < n; i++) {
                min = Math.min(min, prices[i]);
                dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
            }
            int[] best = new int[n];
            best[0] = dp1[0] - prices[0];
            for (int i = 1; i < n; i++) {
                best[i] = Math.max(best[i - 1], dp1[i] - prices[i]);
            }
            int profit = 0;
            int[] dp2 = new int[n];
            for (int i = 1; i < n; i++) {
                dp2[i] = best[i] + prices[i];
                profit = Math.max(profit, dp2[i]);
            }
            return profit;
        }

        public int maxProfit3(int[] prices) {
            int n = prices.length;
            int[] dp1 = new int[n];
            int[] dp2 = new int[n];
            int[] best = new int[n];
            best[0] = -prices[0];
            int profit = 0;

            for (int i = 1, min = prices[0]; i < n; i++) {
                min = Math.min(min, prices[i]);
                dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
                best[i] = Math.max(best[i - 1], dp1[i] - prices[i]);
                dp2[i] = best[i] + prices[i];
                profit = Math.max(profit, dp2[i]);
            }
            return profit;
        }

        public int maxProfit4(int[] prices) {
            int n = prices.length;
            int dp1 = 0;
            int dp2 = 0;
            int best = -prices[0];
            int profit = 0;

            for (int i = 1, min = prices[0]; i < n; i++) {
                min = Math.min(min, prices[i]);
                dp1 = Math.max(dp1, prices[i] - min);
                best = Math.max(best, dp1 - prices[i]);
                dp2 = Math.max(best + prices[i], dp2);
                profit = Math.max(profit, dp2);
            }
            return profit;
        }
    }

}

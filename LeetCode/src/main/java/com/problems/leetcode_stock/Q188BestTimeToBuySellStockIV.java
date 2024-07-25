package com.problems.leetcode_stock;

public class Q188BestTimeToBuySellStockIV {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
        int k = 2;
        int[] prices = {2, 4, 1};
        int expected = 2;
        int actual = sol.maxProfit(k, prices);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        // Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
        // Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
        k = 2;
        prices = new int[]{3, 2, 6, 5, 0, 3};
        expected = 7;
        actual = sol.maxProfit(k, prices);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        k = 2;
        prices = new int[]{1, 2, 4};
        expected = 3;
        actual = sol.maxProfit(k, prices);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int maxProfit(int k, int[] prices) {
            // return maxProfit1(k, prices);
            return maxProfit2(k, prices);
            // return maxProfit3(k, prices);
        }

        private int unlimitedTrades(int[] prices) {
            int n = prices.length;
            int profit = 0;
            for (int i = 1; i < n; i++) {
                profit += Math.max(0, prices[i] - prices[i - 1]);
            }
            return profit;
        }

        private int maxProfit1(int k, int[] prices) {
            int n = prices.length;
            if (k >= n / 2) {
                return unlimitedTrades(prices);
            }
            int[][] dp = new int[k + 1][n];
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j < n; j++) {
                    int best = dp[i - 1][0] + prices[j] - prices[0];
                    for (int p = 1; p < j; p++) {
                        best = Math.max(best, dp[i - 1][p] + prices[j] - prices[p]);
                    }
                    dp[i][j] = Math.max(dp[i][j - 1], best);
                }
            }
            return dp[k][n - 1];
        }

        private int maxProfit2(int k, int[] prices) {
            int n = prices.length;
            if (k >= n / 2) {
                return unlimitedTrades(prices);
            }
            int[][] dp = new int[k + 1][n];
            int best;
            for (int i = 1; i <= k; i++) {
                best = dp[i - 1][0] - prices[0];
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.max(dp[i][j - 1], best + prices[j]);
                    best = Math.max(best, dp[i - 1][j] - prices[j]);
                }
            }
            return dp[k][n - 1];
        }

        private int maxProfit3(int k, int[] prices) {
            int n = prices.length;
            if (k >= n / 2) {
                return unlimitedTrades(prices);
            }
            int[] dp = new int[n];
            int tmp, best;
            for (int i = 1; i <= k; i++) {
                best = dp[0] - prices[0];
                for (int j = 1; j < n; j++) {
                    tmp = dp[j];
                    dp[j] = Math.max(best + prices[j], dp[j - 1]);
                    best = Math.max(best, tmp - prices[j]);
                }
            }
            return dp[n - 1];
        }
    }

}

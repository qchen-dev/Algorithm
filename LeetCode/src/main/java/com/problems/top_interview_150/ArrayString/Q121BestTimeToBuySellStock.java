package com.problems.top_interview_150.ArrayString;

public class Q121BestTimeToBuySellStock {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 5;
        int actual = sol.maxProfit(prices);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        prices = new int[]{7, 6, 4, 3, 1};
        expected = 0;
        actual = sol.maxProfit(prices);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            int min = prices[0];
            int ans = 0;

            for (int price : prices) {
                min = Math.min(min, price);
                ans = Math.max(ans, price - min);
            }
            return ans;
        }
    }

}

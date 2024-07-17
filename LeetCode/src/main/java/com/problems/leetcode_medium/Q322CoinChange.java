package com.problems.leetcode_medium;

import java.util.Arrays;

public class Q322CoinChange {

    // https://leetcode.com/problems/coin-change/description/
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: 11 = 5 + 5 + 1
        int[] coins = {1, 2, 5};
        int amount = 11;
        int expected = 3;
        int actual = sol.coinChange(coins, amount);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        coins = new int[]{2};
        amount = 3;
        expected = -1;
        actual = sol.coinChange(coins, amount);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        coins = new int[]{1};
        amount = 0;
        expected = 0;
        actual = sol.coinChange(coins, amount);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        coins = new int[]{186, 419, 83, 408};
        amount = 6249;
        expected = 20;
        actual = sol.coinChange(coins, amount);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        coins = new int[]{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422};
        amount = 9864;
        expected = 24;
        actual = sol.coinChange(coins, amount);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int coinChange(int[] coins, int amount) {
            if (coins == null || coins.length == 0 || amount < 0) {
                return -1;
            }
            // Method-1
            // Arrays.sort(coins);
            // return changeIt(coins, coins.length - 1, amount);

            // Method-2
            int[][] dp = new int[coins.length + 1][amount + 1];
            for (int[] row : dp) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            return changeIt1(coins, 0, amount, dp);

            // Method-3
            // return dp1(coins, amount);
            // Method-4
            // return dp2(coins, amount);
        }

        private int changeIt1(int[] coins, int i, int amount, int[][] dp) {
            int size = coins.length;
            if (i >= size) {
                return amount != 0 ? -1 : 0;
            }
            if (amount < 0) {
                return -1;
            }
            if (Integer.MAX_VALUE != dp[i][amount]) {
                return dp[i][amount];
            }

            int ways;
            int next;
            int ans = Integer.MAX_VALUE;
            for (int x = 0; x * coins[i] <= amount; x++) {
                ways = -1;
                next = changeIt1(coins, i + 1, amount - x * coins[i], dp);
                if (next != -1) {
                    ways = x + next;
                }
                if (ways != -1) {
                    ans = Math.min(ways, ans);
                }
            }
            ans = ans == Integer.MAX_VALUE ? -1 : ans;
            dp[i][amount] = ans;
            return ans;
        }

        private int dp2(int[] coins, int rest) {
            int size = coins.length;
            int[][] dp = new int[size][rest + 1];

            for (int col = 1; col <= rest; col++) {
                if (col % coins[0] == 0) {
                    dp[0][col] = col / coins[0];
                } else {
                    dp[0][col] = -1;
                }
            }

            for (int i = 1; i < size; i++) {
                for (int j = 1; j <= rest; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    if (dp[i - 1][j] != -1) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    if (j - coins[i] >= 0 && dp[i][j - coins[i]] != -1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i]] + 1);
                    }
                    if (dp[i][j] == Integer.MAX_VALUE) {
                        dp[i][j] = -1;
                    }
                }
            }
            return dp[size - 1][rest];
        }

        private int dp1(int[] coins, int rest) {
            int size = coins.length;
            int[][] dp = new int[size + 1][rest + 1];

            for (int col = 1; col <= rest; col++) {
                dp[size][col] = -1;
            }

            for (int i = size - 1; i >= 0; i--) {
                for (int j = 0; j <= rest; j++) {
                    dp[i][j] = -1;
                    if (dp[i + 1][j] != -1) {
                        dp[i][j] = dp[i + 1][j];
                    }

                    if (j - coins[i] >= 0 && dp[i][j - coins[i]] != -1) {
                        if (dp[i][j] == -1) {
                            dp[i][j] = dp[i][j - coins[i]] + 1;
                        } else {
                            dp[i][j] = Math.min(dp[i][j - coins[i]] + 1, dp[i][j]);
                        }
                    }
                }
            }
            return dp[0][rest];
        }

        private int changeIt(int[] coins, int i, int rest) {
            if (rest < 0) return -1;
            if (i < 0) {
                return rest != 0 ? -1 : 0;
            }

            int count;
            int next;
            int ans = Integer.MAX_VALUE;

            for (int x = 0; x * coins[i] <= rest; x++) {
                count = -1;
                next = changeIt(coins, i - 1, rest - x * coins[i]);
                if (next != -1) {
                    count = x + next;
                }

                if (count != -1) {
                    ans = Math.min(count, ans);
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }

}

package com.problems.top_100_liked.Stack;

import java.util.Arrays;

public class Q739DailyTemperatures {

    // https://leetcode.com/problems/daily-temperatures/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
        int[] actual = sol.dailyTemperatures(temperatures);
        String result = Arrays.equals(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);

        // Example 2
        temperatures = new int[]{30, 40, 50, 60};
        expected = new int[]{1, 1, 1, 0};
        actual = sol.dailyTemperatures(temperatures);
        result = Arrays.equals(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);

        // Example 3
        temperatures = new int[]{30, 60, 90};
        expected = new int[]{1, 1, 0};
        actual = sol.dailyTemperatures(temperatures);
        result = Arrays.equals(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);
    }

    private static class Solution {
        public int[] dailyTemperatures(int[] t) {
            int n = t.length;
            int[] ans = new int[n];
            int[] stack = new int[n];

            int j = -1;
            int i = 0;
            while (i < n) {
                while (j >= 0 && t[stack[j]] < t[i]) {
                    ans[stack[j]] = i - stack[j];
                    --j;
                }
                stack[++j] = i;
                ++i;
            }
            return ans;
        }
    }

}

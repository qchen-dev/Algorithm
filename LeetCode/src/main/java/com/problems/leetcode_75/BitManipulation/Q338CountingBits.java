package com.problems.leetcode_75.BitManipulation;

import java.util.Arrays;

public class Q338CountingBits {

    // https://leetcode.com/problems/counting-bits/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int n = 2;
        int[] expected = {0, 1, 1};
        int[] actual = sol.countBits(n);
        String result = Arrays.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);

        // Example 2
        n = 5;
        expected = new int[]{0, 1, 1, 2, 1, 2};
        actual = sol.countBits(n);
        result = Arrays.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);
    }

    private static class Solution {
        public int[] countBits(int n) {
            int[] ans = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                ans[i] = ans[i >> 1] + (i & 1);
            }
            return ans;
        }
    }

}

package com.problems.leetcode_medium;

import java.util.Objects;

public class Q1052GrumpyBookstoreOwner {

    // https://leetcode.com/problems/grumpy-bookstore-owner/description
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
        // The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        int expected = 16;
        int actual = sol.maxSatisfied(customers, grumpy, minutes);
        String result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        customers = new int[]{1};
        grumpy = new int[]{0};
        minutes = 1;
        expected = 1;
        actual = sol.maxSatisfied(customers, grumpy, minutes);
        result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        customers = new int[]{4, 10, 10};
        grumpy = new int[]{1, 1, 0};
        minutes = 2;
        expected = 24;
        actual = sol.maxSatisfied(customers, grumpy, minutes);
        result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int extra = 0;
            int max = 0;
            int sum = 0;

            int n = customers.length;
            int l = 0, r = 0;
            while (r < n) {
                sum += customers[r] * (1 - grumpy[r]);

                extra += customers[r] * grumpy[r];
                max = Math.max(max, extra);
                if (r - l == minutes - 1) {
                    extra -= customers[l] * grumpy[l++];
                }
                ++r;
            }
            return sum + max;
        }
    }

}

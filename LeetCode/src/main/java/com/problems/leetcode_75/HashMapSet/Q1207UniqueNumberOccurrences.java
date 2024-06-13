package com.problems.leetcode_75.HashMapSet;

import java.util.Arrays;

public class Q1207UniqueNumberOccurrences {

    // https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1.
        // No two values have the same number of occurrences.
        int[] arr = {1, 2, 2, 1, 1, 3};
        boolean expected = true;
        boolean actual = sol.uniqueOccurrences(arr);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        arr = new int[]{1, 2};
        expected = false;
        actual = sol.uniqueOccurrences(arr);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        arr = new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        expected = true;
        actual = sol.uniqueOccurrences(arr);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            int n = arr.length;
            int[] count = new int[n];
            Arrays.sort(arr);

            int i = 0, r = 0;
            while (r < n) {
                if (r == 0 || arr[r] == arr[r - 1]) {
                    count[i]++;
                } else {
                    count[++i]++;
                }
                ++r;
            }
            Arrays.sort(count);
            i = 0;
            while (i < n) {
                if (i != 0 && count[i] != 0 && count[i] == count[i - 1]) {
                    return false;
                }
                ++i;
            }
            return true;
        }
    }

}

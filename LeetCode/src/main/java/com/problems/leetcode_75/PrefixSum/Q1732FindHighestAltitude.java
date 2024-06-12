package com.problems.leetcode_75.PrefixSum;

public class Q1732FindHighestAltitude {

    // https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: The altitudes are[0, -5, -4, 1, 1, -6].The highest is 1.
        int[] gain = {-5, 1, 5, 0, -7};
        int expected = 1;
        int actual = sol.largestAltitude(gain);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        // Explanation: The altitudes are[0, -4, -7, -9, -10, -6, -3, -1].The highest is 0.
        gain = new int[]{-4, -3, -2, -1, 4, 3, 2};
        expected = 0;
        actual = sol.largestAltitude(gain);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int largestAltitude(int[] gains) {
            int altitude = 0;
            int val = 0;

            for (int gain : gains) {
                val += gain;
                altitude = Math.max(altitude, val);
            }
            return altitude;
        }
    }

}

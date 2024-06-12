package com.problems.leetcode_75.SlidingWindow;

public class Q643MaximumAverageSubarrayI {

    // https://leetcode.com/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: Maximum average is(12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double expected = 12.75000;
        double actual = sol.findMaxAverage(nums, k);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        nums = new int[]{5};
        k = 1;
        expected = 5.00000;
        actual = sol.findMaxAverage(nums, k);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int n = nums.length;
            int l = 0, r = l;
            int sum = 0;
            double maxAvg = Integer.MIN_VALUE;

            while (r < n) {
                while (r < n && (r - l + 1) <= k) {
                    sum += nums[r++];
                }
                maxAvg = Math.max(maxAvg, sum * 1.0 / k);
                sum -= nums[l++];
            }
            return maxAvg;
        }
    }

}

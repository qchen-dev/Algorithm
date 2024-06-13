package com.problems.leetcode_75.PrefixSum;

public class Q724FindPivotIndex {

    // https://leetcode.com/problems/find-pivot-index/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: The pivot index is 3.
        // Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
        // Right sum = nums[4] + nums[5] = 5 + 6 = 11
        int[] nums = {1, 7, 3, 6, 5, 6};
        int expected = 3;
        int actual = sol.pivotIndex(nums);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        // Explanation: There is no index that satisfies the conditions in the problem statement.
        nums = new int[]{1, 2, 3};
        expected = -1;
        actual = sol.pivotIndex(nums);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        // Explanation: The pivot index is 0.
        // Left sum = 0 (no elements to the left of index 0)
        // Right sum = nums[1] + nums[2] = 1 + -1 = 0
        nums = new int[]{2, 1, -1};
        expected = 0;
        actual = sol.pivotIndex(nums);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int pivotIndex(int[] nums) {
            int n = nums.length;
            int[] prevSum = new int[n];
            int[] postSum = new int[n];

            prevSum[0] = 0;
            postSum[n - 1] = 0;

            for (int i = 1; i < n; i++) {
                prevSum[i] = prevSum[i - 1] + nums[i - 1];
            }
            for (int i = n - 2; i >= 0; i--) {
                postSum[i] = postSum[i + 1] + nums[i + 1];
            }
            for (int i = 0; i < n; i++) {
                if (prevSum[i] == postSum[i]) {
                    return i;
                }
            }
            return -1;
        }
    }

}

package com.problems.leetcode_75.TwoPointers;

import java.util.Arrays;

public class Q1679MaxNumberKSumPairs {

    // https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: Starting with nums = [1, 2, 3, 4]:
        // -Remove numbers 1 and 4, then nums = [2, 3]
        // -Remove numbers 2 and 3, then nums = []
        // There are no more pairs that sum up to 5, hence a total of 2 operations.
        int[] nums = {1, 2, 3, 4};
        int k = 5;
        int expected = 2;
        int actual = sol.maxOperations(nums, k);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        // Explanation:
        // Starting with nums = [3, 1, 3, 4, 3]:
        // -Remove the first two 3 's, then nums = [1,4,3]
        // There are no more pairs that sum up to 6, hence a total of 1 operation.
        nums = new int[]{3, 1, 3, 4, 3};
        k = 6;
        expected = 1;
        actual = sol.maxOperations(nums, k);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int maxOperations(int[] nums, int k) {
            Arrays.sort(nums);

            int n = nums.length;
            int l = 0, r = n - 1;
            int sum, pair = 0;

            while (l < r) {
                sum = nums[l] + nums[r];
                if (sum == k) {
                    ++pair;
                    ++l;
                    --r;
                } else if (sum < k) {
                    ++l;
                } else {
                    --r;
                }
            }
            return pair;
        }
    }

}

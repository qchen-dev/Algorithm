package com.problems.leetcode_75.BitManipulation;

public class Q136SingleNumber {

    // https://leetcode.com/problems/single-number/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] nums = {2, 2, 1};
        int expected = 1;
        int actual = sol.singleNumber(nums);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        nums = new int[]{4, 1, 2, 1, 2};
        expected = 4;
        actual = sol.singleNumber(nums);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        nums = new int[]{1};
        expected = 1;
        actual = sol.singleNumber(nums);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int singleNumber(int[] nums) {
            int ans = nums[0];

            for (int i = 1; i < nums.length; i++) {
                ans ^= nums[i];
            }
            return ans;
        }
    }

}

package com.problems;

public class Q485MaxConsecutiveOnes {

    // https://leetcode.com/problems/max-consecutive-ones/description/
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: The first two digits or the last three digits are consecutive 1s.
        // The maximum number of consecutive 1s is 3.
        int[] nums = {1, 1, 0, 1, 1, 1};
        int expected = 3;
        int actual = sol.findMaxConsecutiveOnes(nums);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        nums = new int[]{1, 0, 1, 1, 0, 1};
        expected = 2;
        actual = sol.findMaxConsecutiveOnes(nums);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int n = nums.length;
            int l, r = 0;
            int len = 0;

            while (r < n) {
                while (r < n && nums[r] == 0) {
                    ++r;
                }
                l = r;
                while (r < n && nums[r] == 1) {
                    ++r;
                }
                len = Math.max(len, r - l);
            }
            return len;
        }
    }

}

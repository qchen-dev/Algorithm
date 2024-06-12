package com.problems.leetcode_75.SlidingWindow;

public class Q1493LongestSubarrayOnesDeleteOneZero {

    // https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: After deleting the number in position 2, [1, 1, 1]contains 3 numbers with value of 1 's.
        int[] nums = {1, 1, 0, 1};
        int expected = 3;
        int actual = sol.longestSubarray(nums);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        // Explanation:
        // After deleting the number in position 4, [0, 1, 1, 1, 1, 1, 0, 1]
        // longest subarray with value of 1's is [1,1,1,1,1].
        nums = new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1};
        expected = 5;
        actual = sol.longestSubarray(nums);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3:
        // Explanation:
        // You must delete one element.
        nums = new int[]{1, 1, 1};
        expected = 2;
        actual = sol.longestSubarray(nums);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int longestSubarray(int[] nums) {
            int n = nums.length;
            int l = 0, r = 0, len = 0;
            int zero = 0;

            while (r < n) {
                if (nums[r] == 0) {
                    ++zero;
                }
                while (zero > 1) {
                    if (nums[l++] == 0) {
                        --zero;
                    }
                }
                len = Math.max(len, r - l);
                ++r;
            }
            return len;
        }
    }

}

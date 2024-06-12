package com.problems.leetcode_75.TwoPointers;

import java.util.Arrays;

public class Q283MoveZeroes {

    // https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] nums = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};
        sol.moveZeroes(nums);
        String result = Arrays.equals(expected, nums) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(nums), Arrays.toString(expected), result);

        // Example 2
        nums = new int[]{0, 1, 0, 3, 12};
        expected = new int[]{1, 3, 12, 0, 0};
        sol.moveZeroes(nums);
        result = Arrays.equals(expected, nums) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(nums), Arrays.toString(expected), result);
    }

    private static class Solution {
        public void moveZeroes(int[] nums) {
            int len = nums.length;

            // this index is used to place non-zero value
            int nonIdx = -1;
            for (int i = 0; i < len; i++) {
                if (nums[i] != 0) {
                    swap(nums, i, ++nonIdx);
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}

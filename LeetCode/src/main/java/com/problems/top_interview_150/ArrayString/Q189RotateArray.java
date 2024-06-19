package com.problems.top_interview_150.ArrayString;

import java.util.Arrays;

public class Q189RotateArray {

    // https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] expected = {5, 6, 7, 1, 2, 3, 4};
        sol.rotate(nums, k);
        String result = Arrays.equals(nums, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(nums), Arrays.toString(expected), result);

        // Example 2
        nums = new int[]{-1, -100, 3, 99};
        k = 2;
        expected = new int[]{3, 99, -1, -100};
        sol.rotate(nums, k);
        result = Arrays.equals(nums, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(nums), Arrays.toString(expected), result);
    }

    private static class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            reverse(nums, 0, n - k - 1);
            reverse(nums, n - k, n - 1);
            reverse(nums, 0, n - 1);
        }

        private void reverse(int[] nums, int left, int right) {
            while (left < right) {
                int tmp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = tmp;
            }
        }
    }

}

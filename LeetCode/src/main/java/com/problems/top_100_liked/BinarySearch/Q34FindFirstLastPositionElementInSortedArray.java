package com.problems.top_100_liked.BinarySearch;

import java.util.Arrays;

public class Q34FindFirstLastPositionElementInSortedArray {

    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] expected = {3, 4};
        int[] actual = sol.searchRange(nums, target);
        String result = Arrays.equals(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);

        // Example 2
        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 6;
        expected = new int[]{-1, -1};
        actual = sol.searchRange(nums, target);
        result = Arrays.equals(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);

        // Example 3
        nums = new int[]{};
        target = 0;
        expected = new int[]{-1, -1};
        actual = sol.searchRange(nums, target);
        result = Arrays.equals(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);
    }

    private static class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (null == nums || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int first = findFirst(nums, target);
            int last = findLast(nums, target);

            return new int[]{first, last};
        }

        private int findLast(int[] nums, int target) {
            int n = nums.length;
            int l = 0;
            int r = n - 1;
            int mid, val;
            int last = -1;

            while (l <= r) {
                mid = l + ((r - l) >> 1);
                val = nums[mid];
                if (val == target) {
                    last = mid;
                    l = mid + 1;
                } else if (val < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return last;
        }

        private int findFirst(int[] nums, int target) {
            int n = nums.length;
            int l = 0;
            int r = n - 1;
            int mid, val;
            int first = -1;

            while (l <= r) {
                mid = l + ((r - l) >> 1);
                val = nums[mid];
                if (val == target) {
                    first = mid;
                    r = mid - 1;
                } else if (val < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return first;
        }
    }

}

package com.problems.top_interview_150.ArrayString;

import java.util.Arrays;

public class Q88MergeSortedArray {

    // https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        int[] expected = {1, 2, 2, 3, 5, 6};
        sol.merge(nums1, m, nums2, n);
        String result = Arrays.equals(expected, nums1) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(nums1), Arrays.toString(expected), result);

        // Example 2
        nums1 = new int[]{1};
        nums2 = new int[]{};
        m = 1;
        n = 0;
        expected = new int[]{1};
        sol.merge(nums1, m, nums2, n);
        result = Arrays.equals(expected, nums1) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(nums1), Arrays.toString(expected), result);

        // Example 3
        nums1 = new int[]{0};
        nums2 = new int[]{1};
        m = 0;
        n = 1;
        expected = new int[]{1};
        sol.merge(nums1, m, nums2, n);
        result = Arrays.equals(expected, nums1) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(nums1), Arrays.toString(expected), result);
    }

    private static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int idx = nums1.length;

            while (m > 0 && n > 0) {
                if (nums1[m - 1] >= nums2[n - 1]) {
                    nums1[--idx] = nums1[--m];
                } else {
                    nums1[--idx] = nums2[--n];
                }
            }
            while (m > 0) {
                nums1[--idx] = nums1[--m];
            }
            while (n > 0) {
                nums1[--idx] = nums2[--n];
            }
        }
    }

}

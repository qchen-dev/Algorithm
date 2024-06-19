package com.problems.top_interview_150.ArrayString;

public class Q80RemoveDuplicatesFromSortedArrayII {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] expectedNums = {1, 1, 2, 2, 3, 1};
        int expected = 5;
        int actual = sol.removeDuplicates(nums);
        String result = expected == actual && arraysEqual(nums, expectedNums, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        expectedNums = new int[]{0, 0, 1, 1, 2, 3, 3, 3, 1};
        expected = 7;
        actual = sol.removeDuplicates(nums);
        result = expected == actual && arraysEqual(nums, expectedNums, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static boolean arraysEqual(int[] arr1, int[] arr2, int count) {
        if (arr1 == arr2) {
            return true;
        }
        if (null == arr1 ^ null == arr2) {
            return false;
        }
        int len1 = arr1.length, len2 = arr2.length;
        if (len1 < count || len2 < count) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static class Solution {
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            if (n <= 2) return n;

            int k = 2;
            for (int i = 2; i < n; i++) {
                if (nums[i] != nums[k - 2]) {
                    nums[k] = nums[i];
                    k++;
                }
            }
            return k;
        }
    }

}

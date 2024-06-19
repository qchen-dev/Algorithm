package com.problems.top_interview_150.ArrayString;

public class Q27RemoveElement {

    // https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int[] expectedNums = {2, 2, 3, 3};
        int expected = 2;
        int actual = sol.removeElement(nums, val);
        String result = expected == actual && arraysEqual(nums, expectedNums, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        val = 2;
        expectedNums = new int[]{0, 1, 4, 0, 3, -1, -1, -1};
        expected = 5;
        actual = sol.removeElement(nums, val);
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
        public int removeElement(int[] nums, int val) {
            int output = 0;
            int end = nums.length;
            int tmp;

            for (int i = 0; i < end; ) {
                if (nums[i] == val) {
                    tmp = nums[--end];
                    nums[end] = nums[i];
                    nums[i] = tmp;
                }
                if (nums[i] != val) {
                    ++output;
                    ++i;
                }
            }
            return output;
        }
    }

}

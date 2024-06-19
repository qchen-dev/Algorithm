package com.problems.top_interview_150.ArrayString;

public class Q26RemoveDuplicatesFromSortedArray {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] nums = {1, 1, 2};
        int[] expectedNums = {1, 2, 1};
        int expected = 2;
        int actual = sol.removeDuplicates(nums);
        String result = expected == actual && arraysEqual(nums, expectedNums, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        expectedNums = new int[]{0, 1, 2, 3, 4, 1, 1, 1, 1, 1};
        expected = 5;
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
            int k;
            // k = m1(nums);
            k = m2(nums);
            return k;
        }

        private int m1(int[] nums) {
            int j, num, len = nums.length;
            int k = len;
            int idx = 1;
            for (int i = 0; i < len; ) {
                num = nums[i];
                j = i + 1;

                while (j < len && nums[j] == num) {
                    ++j;
                }
                k -= j - i - 1;
                i = j;
                if (idx < len) {
                    nums[idx++] = nums[j >= len ? j - 1 : j];
                }
            }
            return k;
        }

        private int m2(int[] nums) {
            if (null == nums) {
                return 0;
            }
            if (nums.length <= 1) {
                return nums.length;
            }

            int k = 1;
            int n = nums.length;
            for (int i = 0; i < n; ) {
                if (i != 0 && nums[i] != nums[i - 1]) {
                    nums[k++] = nums[i];
                }
                i++;
            }
            return k;
        }
    }

}

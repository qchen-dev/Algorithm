package com.problems.leetcode_75.HashMapSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2215FindDifferenceTwoArrays {

    // https://leetcode.com/problems/find-the-difference-of-two-arrays/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation:
        // For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1
        // and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
        //
        // For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4
        // and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 3));
        expected.add(Arrays.asList(4, 6));

        List<List<Integer>> actual = sol.findDifference(nums1, nums2);
        String result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        // Explanation:
        // For nums1, nums1[2]and nums1[3]are not present in nums2.
        // Since nums1[ 2] ==nums1[3], their value is only included once and answer[0] = [3].
        // Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
        nums1 = new int[]{1, 2, 3, 3};
        nums2 = new int[]{1, 1, 2, 2};
        // expected = [[3],[]]
        expected = new ArrayList<>();
        expected.add(List.of(3));
        expected.add(List.of());

        actual = sol.findDifference(nums1, nums2);
        result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> lst1 = new ArrayList<>();
            List<Integer> lst2 = new ArrayList<>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            for (int i = 0; i < nums1.length; i++) {
                if (i == 0 || nums1[i] != nums1[i - 1]) {
                    if (notPresent(nums1[i], nums2)) {
                        lst1.add(nums1[i]);
                    }
                }
            }
            for (int i = 0; i < nums2.length; i++) {
                if (i == 0 || nums2[i] != nums2[i - 1]) {
                    if (notPresent(nums2[i], nums1)) {
                        lst2.add(nums2[i]);
                    }
                }
            }
            ans.add(lst1);
            ans.add(lst2);

            return ans;
        }

        private boolean notPresent(int num, int[] nums) {
            int n = nums.length;
            int left = 0, right = n - 1, mid;

            while (left <= right) {
                mid = left + ((right - left) >> 1);
                if (nums[mid] == num) {
                    return false;
                } else if (nums[mid] > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return true;
        }
    }

}

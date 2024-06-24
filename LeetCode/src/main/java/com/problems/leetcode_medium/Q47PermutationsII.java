package com.problems.leetcode_medium;

import java.util.*;

public class Q47PermutationsII {

    // https://leetcode.com/problems/permutations-ii/description/
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] nums = {1, 1, 2};
        List<List<Integer>> expected = List.of(List.of(1, 1, 2), List.of(1, 2, 1), List.of(2, 1, 1));
        List<List<Integer>> actual = sol.permuteUnique(nums);
        String result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2:
        nums = new int[]{1, 2, 3};
        expected = List.of(List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1));
        actual = sol.permuteUnique(nums);
        result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            solve(nums, 0, ans);
            return ans;
        }

        private void solve(int[] nums, int idx, List<List<Integer>> ans) {
            int n = nums.length;
            if (idx == n) {
                List<Integer> lst = new ArrayList<>();
                for (int num : nums) {
                    lst.add(num);
                }
                ans.add(lst);
            } else {
                Set<Integer> set = new HashSet<>();
                for (int i = idx; i < n; i++) {
                    if (!set.contains(nums[i])) {
                        set.add(nums[i]);
                        swap(nums, i, idx);
                        solve(nums, idx + 1, ans);
                        swap(nums, i, idx);
                    }
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            if (i != j) {
                nums[i] ^= nums[j];
                nums[j] ^= nums[i];
                nums[i] ^= nums[j];
            }
        }
    }

}

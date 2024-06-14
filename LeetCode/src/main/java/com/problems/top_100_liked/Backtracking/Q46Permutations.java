package com.problems.top_100_liked.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q46Permutations {

    // https://leetcode.com/problems/permutations/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] nums = {1, 2, 3};
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2), Arrays.asList(2, 1, 3), Arrays.asList(2, 3, 1), Arrays.asList(3, 1, 2), Arrays.asList(3, 2, 1));
        List<List<Integer>> actual = sol.permute(nums);
        String result = actual.equals(expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        nums = new int[]{0, 1};
        expected = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 0));
        actual = sol.permute(nums);
        result = actual.equals(expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        nums = new int[]{1};
        expected = List.of(List.of(1));
        actual = sol.permute(nums);
        result = actual.equals(expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            solve(result, nums, 0);

            return result;
        }

        private void solve(List<List<Integer>> result, int[] nums, int i) {
            int n = nums.length;
            if (i == n) {
                List<Integer> ans = new ArrayList<>();
                for (int num : nums) {
                    ans.add(num);
                }
                result.add(ans);
                return;
            }
            for (int j = i; j < n; j++) {
                swap(nums, i, j);
                solve(result, nums, i + 1);
                swap(nums, i, j);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}

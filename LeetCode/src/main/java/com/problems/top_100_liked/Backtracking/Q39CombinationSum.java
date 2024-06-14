package com.problems.top_100_liked.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Q39CombinationSum {

    // https://leetcode.com/problems/combination-sum/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(2, 2, 3), List.of(7));
        List<List<Integer>> actual = sol.combinationSum(candidates, target);
        String result = Objects.equals(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        candidates = new int[]{2, 3, 5};
        target = 8;
        expected = Arrays.asList(Arrays.asList(2, 2, 2, 2), Arrays.asList(2, 3, 3), Arrays.asList(3, 5));
        actual = sol.combinationSum(candidates, target);
        result = Objects.equals(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        candidates = new int[]{2};
        target = 1;
        expected = List.of();
        actual = sol.combinationSum(candidates, target);
        result = Objects.equals(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> lst = new ArrayList<>();
            solve(ans, lst, 0, candidates, target);
            return ans;
        }

        private void solve(List<List<Integer>> ans, List<Integer> lst, int r, int[] candidates, int target) {
            if (target < 0) return;

            if (r == candidates.length) {
                if (target == 0) {
                    ans.add(new ArrayList<>(lst));
                }
                return;
            }
            lst.add(candidates[r]);
            solve(ans, lst, r, candidates, target - candidates[r]);
            lst.removeLast();
            solve(ans, lst, r + 1, candidates, target);
        }
    }

}

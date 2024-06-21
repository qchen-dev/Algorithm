package com.problems.leetcode_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Q153Sum {

    // https://leetcode.com/problems/3sum/
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1:
        // Explanation:
        // nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        // nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        // nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        // The distinct triplets are [-1,0,1] and [-1,-1,2].
        // Notice that the order of the output and the order of the triplets does not matter.
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = List.of(List.of(-1, -1, 2), List.of(-1, 0, 1));
        List<List<Integer>> actual = sol.threeSum(nums);
        String result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        // Explanation: The only possible triplet does not sum up to 0.
        nums = new int[]{0, 1, 1};
        expected = List.of();
        actual = sol.threeSum(nums);
        result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        // Explanation: The only possible triplet sums up to 0.
        nums = new int[]{0, 0, 0};
        expected = List.of(List.of(0, 0, 0));
        actual = sol.threeSum(nums);
        result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    List<List<Integer>> res = twoSum(nums, i + 1, -nums[i]);
                    for (List<Integer> list : res) {
                        list.add(nums[i]);
                        ans.add(list);
                    }
                }
            }
            return ans;
        }

        private List<List<Integer>> twoSum(int[] nums, int start, int target) {
            List<List<Integer>> ans = new ArrayList<>();

            int left = start;
            int right = nums.length - 1;
            int val;
            while (left < right) {
                val = nums[left] + nums[right];
                if (val < target) {
                    ++left;
                } else if (val > target) {
                    --right;
                } else {
                    if (left == start || nums[left] != nums[left - 1]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);
                    }
                    ++left;
                }
            }
            return ans;
        }
    }

}

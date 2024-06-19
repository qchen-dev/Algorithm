package com.problems.top_interview_150.TwoPointers;

public class Q11ContainerWithMostWater {

    // https://leetcode.com/problems/container-with-most-water/submissions/1293252762/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expected = 49;
        int actual = sol.maxArea(height);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        height = new int[]{1, 1};
        expected = 1;
        actual = sol.maxArea(height);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int maxArea(int[] height) {
            int n = height.length;
            int l = 0, r = n - 1;
            int max = 0;
            int minHeight;

            while (l < r) {
                if (height[l] <= height[r]) {
                    minHeight = height[l];
                    ++l;
                } else {
                    minHeight = height[r];
                    --r;
                }
                max = Math.max(max, (r - l + 1) * minHeight);
            }
            return max;
        }
    }

}

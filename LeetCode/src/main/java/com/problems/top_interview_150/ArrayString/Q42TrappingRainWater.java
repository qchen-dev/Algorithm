package com.problems.top_interview_150.ArrayString;

public class Q42TrappingRainWater {

    // https://leetcode.com/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
        // In this case, 6 units of rain water (blue section) are being trapped.
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6;
        int actual = sol.trap(height);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        height = new int[]{4, 2, 0, 3, 2, 5};
        expected = 9;
        actual = sol.trap(height);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int trap(int[] height) {
            if (null == height || height.length <= 2) return 0;

            int ans = 0;
            int n = height.length;
            int l = 0, r = n - 1;
            int leftMax = height[l], rightMax = height[r];
            l = 1;
            r = n - 2;

            while (l <= r) {
                if (leftMax <= rightMax) {
                    leftMax = Math.max(leftMax, height[l]);
                    ans += Math.max(0, leftMax - height[l++]);
                } else {
                    rightMax = Math.max(rightMax, height[r]);
                    ans += Math.max(0, rightMax - height[r--]);
                }
            }
            return ans;
        }
    }

}

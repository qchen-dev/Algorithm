package com.problems.top_interview_150.ArrayString;

public class Q55JumpGame {

    // https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
        int[] nums = {2, 3, 1, 1, 4};
        boolean expected = true;
        boolean actual = sol.canJump(nums);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        // Explanation:
        // You will always arrive at index 3 no matter what.Its maximum jump length is 0,
        // which makes it impossible to reach the last index.
        nums = new int[]{3, 2, 1, 0, 4};
        expected = false;
        actual = sol.canJump(nums);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public boolean canJump(int[] nums) {
            if (null == nums || nums.length < 2) return true;

            int max = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (i > max) return false;
                max = Math.max(max, i + nums[i]);
            }
            return true;
        }
    }

}

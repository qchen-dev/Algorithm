package com.problems.top_interview_150.ArrayString;

public class Q45JumpGameII {

    // https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: The minimum number of jumps to reach the last index is 2.
        // Jump 1 step from index 0 to 1, then 3 steps to the last index.
        int[] nums = {2, 3, 1, 1, 4};
        int expected = 2;
        int actual = sol.jump(nums);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        nums = new int[]{2, 3, 0, 1, 4};
        // expected = 2;
        actual = sol.jump(nums);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int jump(int[] nums) {
            if (null == nums || nums.length < 2) return 0;

            // the max length can be reached from current position
            int curMax = 0;
            // the max length can be reached by taking 1 step
            int next = 0;
            // count the number of steps required
            int step = 0;

            int n = nums.length;
            for (int i = 0; i < n; i++) {
                // if index value can not be reached from current max length
                if (curMax < i) {
                    // take 1 more step to reach next max
                    ++step;
                    curMax = next;
                }
                next = Math.max(next, i + nums[i]);
            }
            return step;
        }
    }

}

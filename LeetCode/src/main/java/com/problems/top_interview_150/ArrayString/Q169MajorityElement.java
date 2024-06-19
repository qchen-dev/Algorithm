package com.problems.top_interview_150.ArrayString;

public class Q169MajorityElement {

    // https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] nums = {3, 2, 3};
        int expected = 3;
        int actual = sol.majorityElement(nums);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        expected = 2;
        actual = sol.majorityElement(nums);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int majorityElement(int[] nums) {
            int candidate = 0, counter = 0;

            for (int num : nums) {
                if (counter == 0) {
                    candidate = num;
                    counter += 1;
                } else {
                    if (num == candidate) {
                        ++counter;
                    } else {
                        --counter;
                    }
                }
            }
            return candidate;
        }
    }

}

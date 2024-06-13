package com.problems.leetcode_75.Stack;

public class Q2390RemoveStarsFromString {

    // https://leetcode.com/problems/removing-stars-from-a-string/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        String s = "leet**cod*e";
        String expected = "lecoe";
        String actual = sol.removeStars(s);
        String result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        s = "erase*****";
        expected = "";
        actual = sol.removeStars(s);
        result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public String removeStars(String s) {
            char[] str = s.toCharArray();
            int n = str.length;
            char[] res = new char[n];
            int offset = 0;
            char chr, star = '*';

            for (int i = 0; i < n; i++) {
                chr = str[i];
                if (chr != star) {
                    res[offset++] = chr;
                } else {
                    if (i != 0) {
                        --offset;
                    }
                }
            }
            return String.valueOf(res, 0, offset);
        }
    }

}

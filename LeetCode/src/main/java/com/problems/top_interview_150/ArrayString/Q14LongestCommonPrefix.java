package com.problems.top_interview_150.ArrayString;

public class Q14LongestCommonPrefix {

    // https://leetcode.com/problems/longest-common-prefix/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        String[] strs = {"flower", "flow", "flight"};
        String expected = "fl";
        String actual = sol.longestCommonPrefix(strs);
        String result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        // Explanation: There is no common prefix among the input strings.
        strs = new String[]{"dog", "racecar", "car"};
        expected = "";
        actual = sol.longestCommonPrefix(strs);
        result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public String longestCommonPrefix(String[] strs) {
            int n = strs.length;
            if (n == 1) return strs[0];

            char[] str = strs[0].toCharArray();
            char[] tmp;
            int min = Integer.MAX_VALUE;
            int idx;

            for (int i = 1; i < n; i++) {
                idx = 0;
                tmp = strs[i].toCharArray();
                while (idx < str.length && idx < tmp.length && str[idx] == tmp[idx]) {
                    ++idx;
                }
                min = Math.min(idx, min);
            }
            return strs[0].substring(0, min);
        }
    }

}

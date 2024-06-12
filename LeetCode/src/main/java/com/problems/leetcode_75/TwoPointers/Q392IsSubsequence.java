package com.problems.leetcode_75.TwoPointers;

public class Q392IsSubsequence {

    // https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        String s = "abc", t = "ahbgdc";
        boolean expected = true;
        boolean actual = sol.isSubsequence(s, t);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        s = "axc";
        t = "ahbgdc";
        expected = false;
        actual = sol.isSubsequence(s, t);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public boolean isSubsequence(String s, String t) {
            char[] s1 = s.toCharArray();
            char[] s2 = t.toCharArray();
            int len1 = s1.length, len2 = s2.length;
            int i1 = 0, i2 = 0;

            while (i2 < len2) {
                if (i1 < len1 && s1[i1] == s2[i2]) {
                    if (++i1 == len1) {
                        return true;
                    }
                }
                ++i2;
            }
            return i1 == len1;
        }
    }

}

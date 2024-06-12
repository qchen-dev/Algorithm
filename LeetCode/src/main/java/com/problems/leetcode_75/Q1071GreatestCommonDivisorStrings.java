package com.problems.leetcode_75;

import java.util.Objects;

public class Q1071GreatestCommonDivisorStrings {

    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        String str1 = "ABCABC", str2 = "ABC";
        String expected = "ABC";
        String actual = sol.gcdOfStrings(str1, str2);
        String result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        str1 = "ABABAB";
        str2 = "ABAB";
        expected = "AB";
        actual = sol.gcdOfStrings(str1, str2);
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        str1 = "LEET";
        str2 = "CODE";
        expected = "";
        actual = sol.gcdOfStrings(str1, str2);
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public String gcdOfStrings(String str1, String str2) {
            if (Objects.equals(str1, str2)) {
                return str1;
            }

            if (!Objects.equals(str1 + str2, str2 + str1)) {
                return "";
            }

            int len1 = str1.length();
            int len2 = str2.length();

            int gcd = gcd(len1, len2);
            return str1.substring(0, gcd);
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }

}

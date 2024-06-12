package com.problems.leetcode_75;

public class Q1768MergeStringAlternately {

    // https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        Solution solution = new Solution();
        final String pass = "PASSED", fail = "FAILED";

        // Example 1
        String word1 = "abc";
        String word2 = "pqr";
        String expected = "apbqcr";
        String actual = solution.mergeAlternately(word1, word2);
        String result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        word1 = "ab";
        word2 = "pqrs";
        expected = "apbqrs";
        actual = solution.mergeAlternately(word1, word2);
        result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        word1 = "abcd";
        word2 = "pq";
        expected = "apbqcd";
        actual = solution.mergeAlternately(word1, word2);
        result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public String mergeAlternately(String word1, String word2) {
            char[] str1 = word1.toCharArray();
            char[] str2 = word2.toCharArray();
            int len1 = str1.length;
            int len2 = str2.length;
            StringBuilder output = new StringBuilder();
            int i1 = 0, i2 = 0;

            // for (; i1 < len1 && i2 < len2; i1++, i2++) {
            while (i1 < len1 && i2 < len2) {
                output.append(str1[i1++]);
                output.append(str2[i2++]);
            }
            if (i1 < len1) {
                output.append(word1.substring(i1));
            }
            if (i2 < len2) {
                output.append(word2.substring(i2));
            }

            return String.valueOf(output);
        }
    }

}

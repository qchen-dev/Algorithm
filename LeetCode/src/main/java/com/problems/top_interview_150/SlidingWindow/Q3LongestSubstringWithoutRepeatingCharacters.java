package com.problems.top_interview_150.SlidingWindow;

import java.util.Arrays;

public class Q3LongestSubstringWithoutRepeatingCharacters {

    // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: The answer is "abc", with the length of 3.
        String s = "abcabcbb";
        int expected = 3;
        int actual = sol.lengthOfLongestSubstring(s);
        String result = actual == expected ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        // Explanation: The answer is "b", with the length of 1.
        s = "bbbbb";
        expected = 1;
        actual = sol.lengthOfLongestSubstring(s);
        result = actual == expected ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        // Explanation: The answer is "wke", with the length of 3.
        // Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
        s = "pwwkew";
        expected = 3;
        actual = sol.lengthOfLongestSubstring(s);
        result = actual == expected ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (null == s || s.isEmpty()) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }
            char[] str = s.toCharArray();
            int n = str.length;
            int[] map = new int[256];
            Arrays.fill(map, -1);

            int prevIdx = -1;
            int longest = 0, cur;
            char chr;

            for (int i = 0; i < n; i++) {
                chr = str[i];
                prevIdx = Math.max(map[chr], prevIdx);
                cur = i - prevIdx;
                longest = Math.max(longest, cur);
                map[chr] = i;
            }
            return longest;
        }
    }

}

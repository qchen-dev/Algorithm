package com.problems.leetcode_75.SlidingWindow;

public class Q1456MaximumVowelsInSubstring {

    // https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: The substring "iii" contains 3 vowel letters.
        String s = "abciiidef";
        int k = 3;
        int expected = 3;
        int actual = sol.maxVowels(s, k);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        // Explanation: Any substring of length 2 contains 2 vowels.
        s = "aeiou";
        k = 2;
        expected = 2;
        actual = sol.maxVowels(s, k);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        // Explanation: "lee", "eet" and "ode" contain 2 vowels.
        s = "leetcode";
        k = 3;
        actual = sol.maxVowels(s, k);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int maxVowels(String s, int k) {
            char[] str = s.toCharArray();
            int n = str.length;
            int l = 0, r = l;
            int ans = 0, sum = 0;

            while (r < n) {
                while (r - l + 1 <= k) {
                    if (isVowel(str[r])) {
                        sum++;
                    }
                    ++r;
                }
                ans = Math.max(ans, sum);
                if (isVowel(str[l++])) {
                    sum--;
                }
            }
            return ans;
        }

        private boolean isVowel(char c) {
            String vowels = "aeiou";
            return vowels.indexOf(c) != -1;
        }
    }

}

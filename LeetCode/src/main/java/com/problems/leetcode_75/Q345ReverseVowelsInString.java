package com.problems.leetcode_75;

public class Q345ReverseVowelsInString {

    // https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        String s = "hello";
        String expected = "holle";
        String actual = sol.reverseVowels(s);
        String result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        s = "leetcode";
        expected = "leotcede";
        actual = sol.reverseVowels(s);
        result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        s = "aA";
        expected = "Aa";
        actual = sol.reverseVowels(s);
        result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public String reverseVowels(String s) {
            char[] str = s.toCharArray();
            int n = str.length;
            int l = 0, r = n - 1;
            boolean left, right;

            while (l < r) {
                left = true;
                right = true;
                if (notVowel(str[l])) {
                    ++l;
                    left = false;
                }
                if (notVowel(str[r])) {
                    --r;
                    right = false;
                }
                if (left && right) {
                    swap(str, l++, r--);
                }
            }
            return String.valueOf(str);
        }

        private void swap(char[] str, int i, int j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }

        private boolean notVowel(char c) {
            String vowels = "aeiouAEIOU";
            return vowels.indexOf(c) == -1;
        }
    }

}

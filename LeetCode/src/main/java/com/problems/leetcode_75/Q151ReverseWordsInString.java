package com.problems.leetcode_75;

public class Q151ReverseWordsInString {

    // https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        String s = "the sky is blue";
        String expected = "blue is sky the";
        String actual = sol.reverseWords(s);
        String result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        s = "  hello world  ";
        expected = "world hello";
        actual = sol.reverseWords(s);
        result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        s = "a good   example";
        expected = "example good a";
        actual = sol.reverseWords(s);
        result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public String reverseWords(String s) {
            StringBuilder ans = new StringBuilder();
            // use only 1 method: m1 or m2
            m1(s, ans);
            // m2(s, ans);
            return String.valueOf(ans);
        }

        private void m1(String s, StringBuilder ans) {
            char[] str = s.toCharArray();
            int n = str.length;
            int l = 0, r = 0;
            boolean first = true;

            while (l < n) {
                while (l < n && str[l] == ' ') {
                    ++l;
                }
                if (l >= n) {
                    break;
                }
                r = l;
                while (r < n && str[r] != ' ') {
                    ++r;
                }

                if (first) {
                    ans.insert(0, String.valueOf(str, l, r - l));
                    // ans.insert(0, s.substring(l, r));
                    first = false;
                } else {
                    ans.insert(0, " ");
                    // ans.insert(0, s.substring(l, Math.min(r, n)));
                    ans.insert(0, String.valueOf(str, l, Math.min(r, n) - l));
                }
                l = r + 1;
            }
        }

        private void m2(String s, StringBuilder ans) {
            char[] str = s.toCharArray();
            int n = str.length;
            int l, r = n - 1;
            boolean first = true;

            while (r >= 0) {
                while (r >= 0 && str[r] == ' ') {
                    --r;
                }
                l = r - 1;
                while (l >= 0 && str[l] != ' ') {
                    --l;
                }
                if (l + 1 < 0) {
                    break;
                }

                String sub = String.valueOf(str, l + 1, r - l);
                if (first) {
                    ans.append(sub);
                    first = false;
                } else {
                    ans.append(" ");
                    ans.append(sub);
                }
                r = l - 1;
            }
        }
    }

}

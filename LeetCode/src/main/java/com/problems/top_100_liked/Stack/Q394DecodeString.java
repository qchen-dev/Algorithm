package com.problems.top_100_liked.Stack;

public class Q394DecodeString {

    // https://leetcode.com/problems/decode-string/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        String s = "3[a]2[bc]";
        String expected = "aaabcbc";
        String actual = sol.decodeString(s);
        String result = actual.equals(expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        s = "3[a2[c]]";
        expected = "accaccacc";
        actual = sol.decodeString(s);
        result = actual.equals(expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        s = "2[abc]3[cd]ef";
        expected = "abcabccdcdcdef";
        actual = sol.decodeString(s);
        result = actual.equals(expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        private static int where = 0;

        public String decodeString(String s) {
            char[] str = s.toCharArray();
            return decode(str, 0);
        }

        private String decode(char[] str, int i) {
            int n = str.length;
            StringBuilder path = new StringBuilder();
            int cur = 0;
            char chr;

            while (i < n && (chr = str[i]) != ']') {
                if (chr >= 'a' && chr <= 'z') {
                    path.append(chr);
                } else if (chr >= '0' && chr <= '9') {
                    cur = cur * 10 + (chr - '0');
                } else {
                    String res = decode(str, i + 1);
                    path.append(res.repeat(cur));
                    i = where;
                    cur = 0;
                }
                i++;
            }
            where = i;
            return String.valueOf(path);
        }
    }

}

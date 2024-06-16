package com.problems.top_100_liked.Stack;

import java.util.Stack;

public class Q20ValidParentheses {

    // https://leetcode.com/problems/valid-parentheses/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        String s = "()";
        boolean expected = true;
        boolean actual = sol.isValid(s);
        String result = actual == expected ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        s = "()[]{}";
        expected = true;
        actual = sol.isValid(s);
        result = actual == expected ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        s = "(]";
        expected = false;
        actual = sol.isValid(s);
        result = actual == expected ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public boolean isValid(String s) {
            if (null == s) {
                return false;
            }
            char[] str = s.toCharArray();
            int n = str.length;
            if ((n & 1) == 1) {
                return false;
            }
            Stack<Character> stack = new Stack<>();

            for (char chr : str) {
                if ("([{".indexOf(chr) != -1) {
                    stack.push(chr == '(' ? ')' : (chr == '[' ? ']' : (chr == '{' ? '}' : '-')));
                } else if ("}])".indexOf(chr) != -1) {
                    if (stack.isEmpty()) return false;
                    if (chr != stack.pop()) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }

}

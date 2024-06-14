package com.problems.top_100_liked.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Q22GenerateParentheses {

    // https://leetcode.com/problems/generate-parentheses/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int n = 3;
        List<String> expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        List<String> actual = sol.generateParenthesis(n);
        String result = Objects.equals(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        n = 1;
        expected = List.of("()");
        actual = sol.generateParenthesis(n);
        result = Objects.equals(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            char[] ans = new char[n << 1];
            generate(result, ans, 0, 0, 0, n);

            return result;
        }

        private void generate(List<String> result, char[] ans, int i, int left, int right, int n) {
            if (i == (n << 1)) {
                result.add(String.valueOf(ans));
                return;
            }
            if (left < n) {
                ans[i] = '(';
                generate(result, ans, i + 1, left + 1, right + 1, n);
            }
            if (right > 0) {
                ans[i] = ')';
                generate(result, ans, i + 1, left, right - 1, n);
            }
        }
    }

}

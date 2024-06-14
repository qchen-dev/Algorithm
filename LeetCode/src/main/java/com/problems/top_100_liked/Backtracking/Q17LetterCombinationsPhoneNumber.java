package com.problems.top_100_liked.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Q17LetterCombinationsPhoneNumber {

    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        String digits = "23";
        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        List<String> actual = sol.letterCombinations(digits);
        String result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        digits = "";
        expected = new ArrayList<>();
        actual = sol.letterCombinations(digits);
        result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        digits = "2";
        expected = Arrays.asList("a", "b", "c");
        actual = sol.letterCombinations(digits);
        result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        static String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            char[] arr = digits.toCharArray();
            List<String> ans = new ArrayList<>();
            int n = arr.length;
            if (n == 0) return ans;
            char[] lst = new char[n];

            calc(arr, ans, 0, lst);
            return ans;
        }

        private void calc(char[] arr, List<String> ans, int idx, char[] lst) {
            int n = arr.length;
            if (n == idx) {
                ans.add(String.valueOf(lst));
                return;
            }

            String pad = letters[arr[idx] - '2'];
            char[] chars = pad.toCharArray();
            for (char chr : chars) {
                lst[idx] = chr;
                calc(arr, ans, idx + 1, lst);
            }
        }
    }

}

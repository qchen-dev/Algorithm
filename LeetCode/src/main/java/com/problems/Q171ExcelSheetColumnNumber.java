package com.problems;

public class Q171ExcelSheetColumnNumber {

    // https://leetcode.com/problems/excel-sheet-column-number/description/
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        String columnTitle = "A";
        int expected = 1;
        int actual = sol.titleToNumber(columnTitle);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        columnTitle = "AB";
        expected = 28;
        actual = sol.titleToNumber(columnTitle);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        columnTitle = "ZY";
        expected = 701;
        actual = sol.titleToNumber(columnTitle);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int titleToNumber(String columnTitle) {
            char[] str = columnTitle.toCharArray();
            int ans = 0;
            for (char chr : str) {
                ans = ans * 26 + chr - 'A' + 1;
            }
            return ans;
        }
    }

}

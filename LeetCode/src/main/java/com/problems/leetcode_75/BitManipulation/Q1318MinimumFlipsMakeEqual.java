package com.problems.leetcode_75.BitManipulation;

public class Q1318MinimumFlipsMakeEqual {

    // https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int a = 2, b = 6, c = 5;
        int expected = 3;
        int actual = sol.minFlips(a, b, c);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        a = 4;
        b = 2;
        c = 7;
        expected = 1;
        actual = sol.minFlips(a, b, c);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        a = 1;
        b = 2;
        c = 3;
        expected = 0;
        actual = sol.minFlips(a, b, c);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {

        /**
         * Constraints:
         *
         * @param a 1 <= a <= 10^9
         * @param b 1 <= b <= 10^9
         * @param c 1 <= c <= 10^9
         * @return minimum flips
         */
        public int minFlips(int a, int b, int c) {
            int n = 31;
            int flip = 0;
            int ai, bi, ci;
            for (int i = 0; i < n; i++) {
                ai = getBit(a, i);
                bi = getBit(b, i);
                ci = getBit(c, i);
                if (ci == 1) {
                    flip += (ai == 1 || bi == 1) ? 0 : 1;
                } else {
                    flip += ai == 1 ? 1 : 0;
                    flip += bi == 1 ? 1 : 0;
                }
            }
            return flip;
        }

        private int getBit(int num, int bit) {
            return (1 & (num >>> bit)) == 1 ? 1 : 0;
        }
    }

}

package com.problems.leetcode_75;

public class Q605CanPlaceFlowers {

    // https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        boolean expected = true;
        boolean actual = sol.canPlaceFlowers(flowerbed, n);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        flowerbed = new int[]{1, 0, 0, 0, 1};
        n = 2;
        expected = false;
        actual = sol.canPlaceFlowers(flowerbed, n);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        flowerbed = new int[]{0, 0, 1, 0, 0};
        n = 1;
        expected = true;
        actual = sol.canPlaceFlowers(flowerbed, n);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int len = flowerbed.length;
            boolean left, right;

            for (int i = 0; i < len; i++) {
                if (flowerbed[i] == 0) {
                    left = i == 0 || flowerbed[i - 1] == 0;
                    right = i == len - 1 || flowerbed[i + 1] == 0;

                    if (left && right) {
                        flowerbed[i] = 1;
                        if (--n == 0) {
                            return true;
                        }
                    }
                }
            }
            return n <= 0;
        }
    }

}

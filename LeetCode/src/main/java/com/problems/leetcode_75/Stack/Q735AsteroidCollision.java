package com.problems.leetcode_75.Stack;

import java.util.Arrays;

public class Q735AsteroidCollision {

    // https://leetcode.com/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
        int[] asteroids = {5, 10, -5};
        int[] expected = new int[]{5, 10};
        int[] actual = sol.asteroidCollision(asteroids);
        String result = Arrays.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);

        // Example 2
        // Explanation: The 8 and - 8 collide exploding each other.
        asteroids = new int[]{8, -8};
        expected = new int[]{};
        actual = sol.asteroidCollision(asteroids);
        result = Arrays.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);

        // Example 3
        // Explanation: The 2 and - 5 collide resulting in - 5. The 10 and - 5 collide resulting in 10.
        asteroids = new int[]{10, 2, -5};
        expected = new int[]{10};
        actual = sol.asteroidCollision(asteroids);
        result = Arrays.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);

        // Example 4
        asteroids = new int[]{-2, -1, 1, 2};
        expected = new int[]{-2, -1, 1, 2};
        actual = sol.asteroidCollision(asteroids);
        result = Arrays.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);

        // Example 5
        asteroids = new int[]{-2, -2, 1, -2};
        expected = new int[]{-2, -2, -2};
        actual = sol.asteroidCollision(asteroids);
        result = Arrays.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);

        // Example 6
        asteroids = new int[]{-2, 2, 1, -2};
        expected = new int[]{-2};
        actual = sol.asteroidCollision(asteroids);
        result = Arrays.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);
    }

    private static class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            int n = asteroids.length;
            int[] tmp = new int[n];
            int i = 0, offset = 0;
            boolean negativeWon;
            int absVal;

            while (i < n) {
                if (asteroids[i] < 0) {
                    // if encountered negative value
                    if (offset == 0 || tmp[offset - 1] < 0) {
                        // if no value on the left, or left value is also negative
                        tmp[offset++] = asteroids[i];
                    } else {
                        // if left value is positive
                        absVal = -asteroids[i];
                        negativeWon = false;
                        while (offset > 0 && tmp[offset - 1] > 0 && tmp[offset - 1] < absVal) {
                            --offset;
                            negativeWon = true;
                        }
                        if (offset > 0 && tmp[offset - 1] > 0) {
                            if (tmp[offset - 1] == absVal) {
                                --offset;
                            }
                            negativeWon = false;
                        }
                        if (negativeWon) {
                            tmp[offset++] = asteroids[i];
                        }
                    }
                } else {
                    // if positive value
                    tmp[offset++] = asteroids[i];
                }
                ++i;
            }
            int[] ans = new int[offset];
            System.arraycopy(tmp, 0, ans, 0, offset);
            return ans;
        }
    }

}

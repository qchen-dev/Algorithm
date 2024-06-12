package com.problems.leetcode_75;

import java.util.ArrayList;
import java.util.List;

public class Q1431KidsGreatestNumberCandies {

    // https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> expected = List.of(true, true, true, false, true);
        List<Boolean> actual = sol.kidsWithCandies(candies, extraCandies);
        String result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        candies = new int[]{4, 2, 1, 1, 2};
        extraCandies = 1;
        expected = List.of(true, false, false, false, false);
        actual = sol.kidsWithCandies(candies, extraCandies);
        result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        candies = new int[]{12, 1, 12};
        extraCandies = 10;
        expected = List.of(true, false, true);
        actual = sol.kidsWithCandies(candies, extraCandies);
        result = expected.equals(actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            List<Boolean> res = new ArrayList<>();

            int max = Integer.MIN_VALUE;
            for (int candy : candies) {
                max = Math.max(max, candy);
            }
            for (int candy : candies) {
                res.add(candy + extraCandies >= max);
            }

            return res;
        }
    }

}

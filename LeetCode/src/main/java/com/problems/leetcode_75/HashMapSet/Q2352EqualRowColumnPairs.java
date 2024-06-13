package com.problems.leetcode_75.HashMapSet;

public class Q2352EqualRowColumnPairs {

    // https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        int expected = 1;
        int actual = sol.equalPairs(grid);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        grid = new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        expected = 3;
        actual = sol.equalPairs(grid);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int equalPairs(int[][] grid) {
            int n = grid.length;
            int pair = 0;

            for (int[] row : grid) {
                for (int col = 0; col < n; col++) {
                    ++pair;
                    for (int offset = 0; offset < n; offset++) {
                        if (row[offset] != grid[offset][col]) {
                            --pair;
                            break;
                        }
                    }
                }
            }
            return pair;
        }
    }

}

package com.problems.top_100_liked.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Q51NQueens {

    // https://leetcode.com/problems/n-queens/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        int n = 4;
        List<List<String>> expected = Arrays.asList(Arrays.asList(".Q..", "...Q", "Q...", "..Q."), Arrays.asList("..Q.", "Q...", "...Q", ".Q.."));
        List<List<String>> actual = sol.solveNQueens(n);
        String result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        n = 1;
        expected = List.of(List.of("Q"));
        actual = sol.solveNQueens(n);
        result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();

            solve(result, new int[n + 1], 1, n);
            return result;
        }

        private void solve(List<List<String>> result, int[] lst, int row, int n) {
            if (row == n + 1) {
                ArrayList<String> ans = new ArrayList<>();
                StringBuilder str;
                for (int i = 1; i <= n; i++) {
                    str = new StringBuilder();
                    for (int j = 1; j <= n; j++) {
                        if (j != lst[i]) {
                            str.append('.');
                        } else {
                            str.append('Q');
                        }
                    }
                    ans.add(str.toString());
                }
                result.add(ans);
                return;
            }

            for (int col = 1; col <= n; col++) {
                if (validate(lst, row, col)) {
                    lst[row] = col;
                    solve(result, lst, row + 1, n);
                }
            }
        }

        private boolean validate(int[] lst, int row, int col) {
            int prev = row - 1;
            while (prev > 0) {
                if (lst[prev] == col || Math.abs(row - prev) == Math.abs(col - lst[prev])) {
                    return false;
                }
                --prev;
            }
            return true;
        }
    }

}

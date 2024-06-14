package com.problems.top_100_liked.Backtracking;

public class Q79WordSearch {

    // https://leetcode.com/problems/word-search/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean expected = true;
        boolean actual = sol.exist(board, word);
        String result = actual == expected ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        word = "SEE";
        expected = true;
        actual = sol.exist(board, word);
        result = actual == expected ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        word = "ABCB";
        expected = false;
        actual = sol.exist(board, word);
        result = actual == expected ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 4
        board = new char[][]{{'A'}};
        word = "A";
        expected = true;
        actual = sol.exist(board, word);
        result = actual == expected ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public boolean exist(char[][] board, String word) {
            char[] w = word.toCharArray();
            int n = board.length;
            int m = board[0].length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (search(board, i, j, w, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean search(char[][] board, int i, int j, char[] w, int k) {
            if (k == w.length) {
                return true;
            }

            int n = board.length;
            int m = board[0].length;
            if (i < 0 || i >= n || j < 0 || j >= m) {
                return false;
            }
            if (board[i][j] != w[k]) {
                return false;
            }
            char tmp = board[i][j];
            board[i][j] = 0;

            boolean up = search(board, i - 1, j, w, k + 1);
            boolean down = search(board, i + 1, j, w, k + 1);
            boolean left = search(board, i, j - 1, w, k + 1);
            boolean right = search(board, i, j + 1, w, k + 1);
            boolean found = up || down || left || right;
            board[i][j] = tmp;

            return found;
        }
    }

}

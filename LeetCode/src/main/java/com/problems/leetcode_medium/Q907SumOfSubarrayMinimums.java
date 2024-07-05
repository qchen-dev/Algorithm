package com.problems.leetcode_medium;

public class Q907SumOfSubarrayMinimums {

    // https://leetcode.com/problems/sum-of-subarray-minimums/description/
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation:
        // Sub arrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
        // Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
        // Sum is 17.
        int[] arr = {3, 1, 2, 4};
        int expected = 17;
        int actual = sol.sumSubarrayMins(arr);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        arr = new int[]{11, 81, 94, 43, 3};
        expected = 444;
        actual = sol.sumSubarrayMins(arr);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int sumSubarrayMins(int[] arr) {
            int n = arr.length;
            int[] stack = new int[n];
            int[] left = lessEqualLeft(arr, stack);
            int[] right = lessRight(arr, stack);

            long sum = 0;
            long len;
            int module = 1_000_000_007;
            for (int i = 0; i < n; i++) {
                len = (long) (i - left[i]) * (right[i] - i);
                sum += len * (long) arr[i];
                sum %= module;
            }
            return (int) sum;
        }

        private int[] lessEqualLeft(int[] arr, int[] stack) {
            int n = arr.length;
            int[] left = new int[n];

            int size = 0;
            for (int i = n - 1; i >= 0; i--) {
                while (size != 0 && arr[i] <= arr[stack[size - 1]]) {
                    left[stack[--size]] = i;
                }
                stack[size++] = i;
            }
            while (size != 0) {
                left[stack[--size]] = -1;
            }
            return left;
        }

        private int[] lessRight(int[] arr, int[] stack) {
            int n = arr.length;
            int[] right = new int[n];

            int size = 0;
            for (int i = 0; i < n; i++) {
                while (size != 0 && arr[i] < arr[stack[size - 1]]) {
                    right[stack[--size]] = i;
                }
                stack[size++] = i;
            }
            while (size != 0) {
                right[stack[--size]] = n;
            }
            return right;
        }
    }

}

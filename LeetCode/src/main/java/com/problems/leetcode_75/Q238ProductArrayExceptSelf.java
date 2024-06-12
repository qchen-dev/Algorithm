package com.problems.leetcode_75;

import java.util.Arrays;

public class Q238ProductArrayExceptSelf {

    // https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        int[] actual = sol.productExceptSelf(nums);
        String result = Arrays.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);

        // Example 2
        nums = new int[]{-1, 1, 0, -3, 3};
        expected = new int[]{0, 0, 9, 0, 0};
        actual = sol.productExceptSelf(nums);
        result = Arrays.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);
    }

    private static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] products = new int[n];
            Arrays.fill(products, 1);

            int prevProduct = 1;
            for (int i = 0; i < n; i++) {
                products[i] *= prevProduct;
                prevProduct *= nums[i];
            }

            prevProduct = 1;
            for (int i = n - 1; i >= 0; i--) {
                products[i] *= prevProduct;
                prevProduct *= nums[i];
            }

            return products;
        }
    }

}

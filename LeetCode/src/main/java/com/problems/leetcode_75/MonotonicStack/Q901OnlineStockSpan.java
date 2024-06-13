package com.problems.leetcode_75.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class Q901OnlineStockSpan {

    // https://leetcode.com/problems/online-stock-span/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        StockSpanner spanner = new StockSpanner();

        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] expected = {1, 1, 1, 2, 1, 4, 6};
        int n = prices.length;
        int[] actual = new int[n];
        String result;

        for (int i = 0; i < n; i++) {
            actual[i] = spanner.next(prices[i]);
        }
        result = Arrays.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", Arrays.toString(actual), Arrays.toString(expected), result);
    }

    private static class StockSpanner {

        private final Stack<Pair> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            int span = 1;
            while (!stack.isEmpty() && stack.peek().price <= price) {
                span += stack.pop().span;
            }
            stack.push(new Pair(price, span));
            return span;
        }

        private static class Pair {
            int price;
            int span;

            Pair(int price, int span) {
                this.price = price;
                this.span = span;
            }
        }
    }

}

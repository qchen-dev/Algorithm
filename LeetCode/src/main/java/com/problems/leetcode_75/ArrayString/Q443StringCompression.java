package com.problems.leetcode_75.ArrayString;

public class Q443StringCompression {

    // https://leetcode.com/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        // Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
        // Return 6, and the first 6 characters of the input array should be: ['a', '2', 'b', '2', 'c', '3']
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int expected = 6;
        int actual = sol.compress(chars);
        String result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        // Explanation: The only group is "a", which remains uncompressed since it 's a single character. Example 3:
        // Return 1, and the first character of the input array should be: ['a']
        chars = new char[]{'a'};
        expected = 1;
        actual = sol.compress(chars);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        // Return 4, and the first 4 characters of the input array should be: ['a', 'b', '1', '2'].
        // Explanation: The groups are "a" and "bbbbbbbbbbbb".This compresses to "ab12".
        chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        expected = 4;
        actual = sol.compress(chars);
        result = expected == actual ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int compress(char[] chars) {
            int n = chars.length;
            int i = 0, l = 0, r;
            StringBuilder str = new StringBuilder();

            char chr;
            while (l < n) {
                chr = chars[l];
                chars[i++] = chr;
                r = l + 1;
                while (r < n && chars[r] == chr) {
                    ++r;
                }
                if (r - l > 1) {
                    str.append(r - l);
                    for (char c : str.toString().toCharArray()) {
                        chars[i++] = c;
                    }
                    str = new StringBuilder();
                }
                l = r;
            }
            return i;
        }
    }

}

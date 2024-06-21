package com.problems.leetcode_medium;

import java.util.Objects;

public class Q165CompareVersionNumbers {

    // https://leetcode.com/problems/compare-version-numbers/description/
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        String version1 = "1.2", version2 = "1.10";
        int expected = -1;
        int actual = sol.compareVersion(version1, version2);
        String result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 2
        // Explanation:
        // Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
        version1 = "1.01";
        version2 = "1.001";
        expected = 0;
        actual = sol.compareVersion(version1, version2);
        result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);

        // Example 3
        // Explanation:
        // version1 has lesser revisions, which means every missing revision are treated as "0".
        version1 = "1.0";
        version2 = "1.0.0.0";
        // expected = 0;
        actual = sol.compareVersion(version1, version2);
        result = Objects.equals(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", actual, expected, result);
    }

    private static class Solution {
        public int compareVersion(String v1, String v2) {
            char[] s1 = v1.toCharArray();
            char[] s2 = v2.toCharArray();
            int len1 = s1.length;
            int len2 = s2.length;
            int i = 0, j = 0;
            int cur1 = 0, cur2 = 0;
            char chr1, chr2, chr0 = '0', dot = '.';
            boolean isDot1, isDot2;

            while (i < len1 || j < len2) {
                isDot1 = false;
                if (i < len1) {
                    chr1 = s1[i];
                    if (chr1 != dot) {
                        cur1 = cur1 * 10 + (chr1 - chr0);
                        i++;
                    } else {
                        isDot1 = true;
                    }
                }

                isDot2 = false;
                if (j < len2) {
                    chr2 = s2[j];
                    if (chr2 != dot) {
                        cur2 = cur2 * 10 + (chr2 - chr0);
                        j++;
                    } else {
                        isDot2 = true;
                    }
                }

                if ((i == len1 || isDot1) && (isDot2 || j == len2)) {
                    if (cur1 > cur2) return 1;
                    if (cur1 < cur2) return -1;
                    cur1 = 0;
                    cur2 = 0;
                    i += i < len1 ? 1 : 0;
                    j += j < len2 ? 1 : 0;
                }
            }
            return 0;
        }
    }

}

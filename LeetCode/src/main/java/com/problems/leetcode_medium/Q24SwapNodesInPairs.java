package com.problems.leetcode_medium;

public class Q24SwapNodesInPairs {

    // https://leetcode.com/problems/swap-nodes-in-pairs/description/
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] src = {1, 2, 3, 4};
        int[] target = {2, 1, 4, 3};
        ListNode head = makeList(src);
        ListNode expected = makeList(target);
        ListNode actual = sol.swapPairs(head);
        String result = isListEqual(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", printList(actual), printList(expected), result);

        // Example 2
        src = new int[]{};
        target = new int[]{};
        head = makeList(src);
        expected = makeList(target);
        actual = sol.swapPairs(head);
        result = isListEqual(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", printList(actual), printList(expected), result);

        // Example 3
        src = new int[]{1};
        target = new int[]{1};
        head = makeList(src);
        expected = makeList(target);
        actual = sol.swapPairs(head);
        result = isListEqual(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", printList(actual), printList(expected), result);

        // Example 4
        src = new int[]{2, 5, 3, 4, 6, 2, 2};
        target = new int[]{5, 2, 4, 3, 2, 6, 2};
        head = makeList(src);
        expected = makeList(target);
        actual = sol.swapPairs(head);
        result = isListEqual(expected, actual) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", printList(actual), printList(expected), result);
    }

    private static boolean isListEqual(ListNode lst1, ListNode lst2) {
        if (lst1 == lst2) {
            return true;
        }
        if (null == lst1 ^ null == lst2) {
            return false;
        }
        while (lst1 != null && lst2 != null && lst1.val == lst2.val) {
            lst1 = lst1.next;
            lst2 = lst2.next;
        }
        return lst1 == lst2;
    }

    private static String printList(ListNode head) {
        if (null == head) {
            return "";
        }
        StringBuilder str = new StringBuilder("" + head.val);
        while (head.next != null) {
            str.append("->").append(head.next.val);
            head = head.next;
        }
        return String.valueOf(str);
    }

    private static ListNode makeList(int[] src) {
        if (null == src || src.length == 0) {
            return null;
        }
        ListNode head = null, cur = null;
        for (int val : src) {
            if (null == head) {
                head = new ListNode(val);
                cur = head;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (null == head || head.next == null) {
                return head;
            }
            ListNode cur = head, next = cur.next, prev = null, nextN;

            while (null != cur && next != null) {
                nextN = next.next;
                next.next = cur;
                cur.next = nextN;
                if (prev == null) {
                    head = next;
                } else {
                    prev.next = next;
                }

                prev = cur;
                cur = nextN;
                next = null != cur ? cur.next : null;
            }
            return head;
        }
    }

}

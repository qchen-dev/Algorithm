package com.problems.top_100_liked.LinkedLists;

public class Q19RemoveNthNodeFromEndList {

    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] nums = {1, 2, 3, 4, 5};
        int n = 2;
        int[] outs = {1, 2, 3, 5};
        ListNode head = makeList(nums);
        ListNode expected = makeList(outs);
        ListNode actual = sol.removeNthFromEnd(head, n);
        String result = isListEqual(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", printList(actual), printList(expected), result);

        // Example 2
        nums = new int[]{1};
        n = 1;
        outs = new int[]{};
        head = makeList(nums);
        expected = makeList(outs);
        actual = sol.removeNthFromEnd(head, n);
        result = isListEqual(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", printList(actual), printList(expected), result);

        // Example 3
        nums = new int[]{1, 2};
        n = 1;
        outs = new int[]{1};
        head = makeList(nums);
        expected = makeList(outs);
        actual = sol.removeNthFromEnd(head, n);
        result = isListEqual(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", printList(actual), printList(expected), result);
    }

    private static String printList(ListNode lst) {
        if (null == lst) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        str.append(lst.val);

        while (null != (lst = lst.next)) {
            str.append("->").append(lst.val);
        }
        return str.toString();
    }

    private static boolean isListEqual(ListNode lst1, ListNode lst2) {
        if (lst1 == lst2) {
            return true;
        }
        if (null == lst1 ^ null == lst2) {
            return false;
        }
        boolean equal = true;
        while (equal && null != lst1 && null != lst2) {
            equal = lst1.val == lst2.val;
            lst1 = lst1.next;
            lst2 = lst2.next;
        }
        return equal;
    }

    private static ListNode makeList(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        ListNode head = null, cur = null;
        for (int num : nums) {
            if (null == head) {
                head = new ListNode(num);
                cur = head;
            } else {
                cur.next = new ListNode(num);
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) {
                return null;
            }
            ListNode prev = null;
            ListNode cur = head;

            while (cur != null) {
                --n;
                if (n == -1) {
                    prev = head;
                }
                if (n < -1) {
                    assert prev != null;
                    prev = prev.next;
                }
                cur = cur.next;
            }
            if (n > 0) {
                return head;
            }
            if (prev == null) {
                return head.next;
            }
            prev.next = prev.next.next;
            return head;
        }
    }

}

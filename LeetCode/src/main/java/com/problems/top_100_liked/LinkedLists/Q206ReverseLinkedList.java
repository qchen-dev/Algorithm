package com.problems.top_100_liked.LinkedLists;

public class Q206ReverseLinkedList {

    // https://leetcode.com/problems/reverse-linked-list/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] nums = {1, 2, 3, 4, 5};
        int[] output = {5, 4, 3, 2, 1};
        ListNode head = makeList(nums);
        ListNode expected = makeList(output);
        ListNode actual = sol.reverseList(head);
        String result = isListEqual(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", printList(actual), printList(expected), result);

        // Example 2
        nums = new int[]{1, 2};
        output = new int[]{2, 1};
        head = makeList(nums);
        expected = makeList(output);
        actual = sol.reverseList(head);
        result = isListEqual(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", printList(actual), printList(expected), result);

        // Example 2
        nums = new int[]{};
        output = new int[]{};
        head = makeList(nums);
        expected = makeList(output);
        actual = sol.reverseList(head);
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

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static class Solution {
        public ListNode reverseList(ListNode head) {
            if (null == head) {
                return null;
            }
            ListNode prev = null, next;
            while (null != head) {
                next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }

}

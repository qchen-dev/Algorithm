package com.problems.top_100_liked.LinkedLists;

public class Q21MergeTwoSortedLists {

    // https://leetcode.com/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        // Example 1
        int[] src1 = {1, 2, 4};
        int[] src2 = {1, 3, 4};
        int[] src3 = {1, 1, 2, 3, 4, 4};
        ListNode lst1 = makeList(src1);
        ListNode lst2 = makeList(src2);
        ListNode expected = makeList(src3);
        ListNode actual = sol.mergeTwoLists(lst1, lst2);
        String result = isListEqual(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", printList(actual), printList(expected), result);

        // Example 2
        src1 = new int[]{};
        src2 = new int[]{};
        src3 = new int[]{};
        lst1 = makeList(src1);
        lst2 = makeList(src2);
        expected = makeList(src3);
        actual = sol.mergeTwoLists(lst1, lst2);
        result = isListEqual(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", printList(actual), printList(expected), result);

        // Example 3
        src1 = new int[]{};
        src2 = new int[]{0};
        src3 = new int[]{0};
        lst1 = makeList(src1);
        lst2 = makeList(src2);
        expected = makeList(src3);
        actual = sol.mergeTwoLists(lst1, lst2);
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
        while (equal && lst1 != null && lst2 != null) {
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
        ListNode head = null, cur = head;
        for (int num : nums) {
            if (head == null) {
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
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == list2) {
                return list1;
            }
            if (list1 == null) return list2;
            if (list2 == null) return list1;

            ListNode head, cur = null;
            if (list1.val <= list2.val) {
                head = list1;
                list1 = list1.next;
            } else {
                head = list2;
                list2 = list2.next;
            }
            cur = head;

            while (true) {
                if (list1 == null) {
                    cur.next = list2;
                    break;
                }
                if (list2 == null) {
                    cur.next = list1;
                    break;
                }

                if (list1.val <= list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }
            return head;
        }
    }

}

package com.problems.top_100_liked.LinkedLists;

public class Q2AddTwoNumbers {

    // https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        final String pass = "PASSED", fail = "FAILED";
        Solution sol = new Solution();

        int[] num1 = {2, 4, 3};
        int[] num2 = {5, 6, 4};
        int[] num3 = {7, 0, 8};
        ListNode lst1 = makeList(num1);
        ListNode lst2 = makeList(num2);
        ListNode expected = makeList(num3);
        ListNode actual = sol.addTwoNumbers(lst1, lst2);
        String result = isListEqual(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", printList(actual), printList(expected), result);

        num1 = new int[]{0};
        num2 = new int[]{0};
        num3 = new int[]{0};
        lst1 = makeList(num1);
        lst2 = makeList(num2);
        expected = makeList(num3);
        actual = sol.addTwoNumbers(lst1, lst2);
        result = isListEqual(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", printList(actual), printList(expected), result);

        num1 = new int[]{9, 9, 9, 9, 9, 9, 9};
        num2 = new int[]{9, 9, 9, 9};
        num3 = new int[]{8, 9, 9, 9, 0, 0, 0, 1};
        lst1 = makeList(num1);
        lst2 = makeList(num2);
        expected = makeList(num3);
        actual = sol.addTwoNumbers(lst1, lst2);
        result = isListEqual(actual, expected) ? pass : fail;
        System.out.printf("The actual is %s, the expected is %s, the result has %s.\n", printList(actual), printList(expected), result);
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
        ListNode head = null, cur = null;
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

    private static String printList(ListNode lst) {
        if (null == lst) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        str.append(lst.val);
        while (null != lst.next) {
            str.append("->").append(lst.val);
            lst = lst.next;
        }
        return String.valueOf(str);
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
        public ListNode addTwoNumbers(ListNode lst1, ListNode lst2) {
            ListNode lst = null, cur = null;
            int carry = 0;
            int v1, v2, v;

            while (lst1 != null || lst2 != null) {
                v1 = lst1 == null ? 0 : lst1.val;
                v2 = lst2 == null ? 0 : lst2.val;

                v = carry + v1 + v2;
                carry = v / 10;
                v %= 10;

                if (cur == null) {
                    cur = new ListNode(v);
                    lst = cur;
                } else {
                    cur.next = new ListNode(v);
                    cur = cur.next;
                }

                lst1 = lst1 == null ? lst1 : lst1.next;
                lst2 = lst2 == null ? lst2 : lst2.next;
            }
            if (carry == 1) {
                cur.next = new ListNode(1);
            }
            return lst;
        }
    }

}

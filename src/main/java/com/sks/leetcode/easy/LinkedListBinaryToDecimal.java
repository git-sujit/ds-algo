package com.sks.leetcode.easy;

import com.sks.leetcode.common.ListNode;

public class LinkedListBinaryToDecimal {
    /**
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     */
    public static int getDecimalValue(ListNode head) {
        if (head == null) return 0;
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;
        }
        return num;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.prepareTestData_binary();
        System.out.println("\nBinary Linked List : " + head);
        System.out.println("Decimal Value : " + getDecimalValue(head));
        System.out.println("\nBinary Linked List : " + head);
    }
}

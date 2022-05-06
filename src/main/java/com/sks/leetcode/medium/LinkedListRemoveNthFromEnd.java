package com.sks.leetcode.medium;

import com.sks.leetcode.common.ListNode;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head
 */
public class LinkedListRemoveNthFromEnd {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return null;
        ListNode nthNode = head;
        ListNode curr = head;
        while (n > 1) {
            nthNode = nthNode.next;
            curr = curr.next;
            n--;
        }
        ListNode prev = null;
        nthNode = head;
        while (curr.next != null) {
            prev = nthNode;
            nthNode = nthNode.next;
            curr = curr.next;
        }
        //System.out.println("nthNode = "+nthNode.val);
        if (nthNode == null || prev == null) return head.next;
        prev.next = nthNode.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.prepareTestData_1();
        System.out.println("List : " + head);
        int n = 2;
        head = removeNthFromEnd(head, n);
        System.out.println("Removed " + n + "th from last");
        System.out.println("List : " + head);
        n = 4;
        head = removeNthFromEnd(head, n);
        System.out.println("Removed " + n + "th from last");
        System.out.println("List : " + head);

        n = 4;
        head = removeNthFromEnd(head, n);
        System.out.println("Removed " + n + "th from last");
        System.out.println("List : " + head);
    }
}

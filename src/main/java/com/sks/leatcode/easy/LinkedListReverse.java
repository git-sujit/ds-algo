package com.sks.leatcode.easy;

import com.sks.leatcode.common.ListNode;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class LinkedListReverse {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.prepareTestData_1();
        System.out.println("Original List: " + head);
        head = reverseList(head);
        System.out.println("Reversed List: " + head);
    }
}

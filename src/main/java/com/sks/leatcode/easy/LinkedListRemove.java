package com.sks.leatcode.easy;

import com.sks.leatcode.common.ListNode;

/**
 * Remove from LinkedList
 */
public class LinkedListRemove {
    /**
     * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val,
     * and return the new head.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        while (head != null && head.val == val) head = head.next;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
        }
        return head;
    }

    /**
     * Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list,
     * instead you will be given access to the node to be deleted directly. node to be deleted is not a tail node
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}

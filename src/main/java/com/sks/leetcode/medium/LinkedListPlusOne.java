package com.sks.leetcode.medium;

import com.sks.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-negative integer represented as a linked list of digits, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class LinkedListPlusOne {
    public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        Map<ListNode, ListNode> nodePrevMap = new HashMap<>();
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            nodePrevMap.put(curr, prev);
            prev = curr;
            curr = curr.next;
        }
        ListNode last = prev;
        int add = 1;
        while (add == 1 && last != null) {
            if (last.val == 9) {
                last.val = 0;
                add = 1;
                last = nodePrevMap.get(last);
            } else {
                last.val += add;
                add = 0;
            }
        }
        if (add == 1) {
            ListNode node = new ListNode(1);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.prepareTestData_1();
        demo(head);

        head = ListNode.prepareTestData_palindrome(true);
        demo(head);
    }

    private static void demo(ListNode head) {
        System.out.println("\nLinkedList = " + head);
        System.out.println("Plus  '1'  = " + new LinkedListPlusOne().plusOne(head));
    }
}

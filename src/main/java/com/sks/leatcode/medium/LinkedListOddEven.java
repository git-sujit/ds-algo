package com.sks.leatcode.medium;

import com.sks.leatcode.common.ListNode;

/**
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices,
 * and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */
public class LinkedListOddEven {
    /**
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;
        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.prepareTestData_1();
        System.out.println("List : " + head);
        head = oddEvenList(head);
        System.out.println("Odd-Even List : " + head);
    }
}

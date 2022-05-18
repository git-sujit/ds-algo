package com.sks.leetcode.medium;

import com.sks.leetcode.common.ListNode;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class LinkedListReversal2 {
    /**
     * Time Complexity :
     * Space Complexity:
     */
    public ListNode reverseBetween_better(ListNode head, int left, int right) {
        if (head == null || left >= right) return head;
        ListNode beforeLeft = null;
        ListNode revStart = null;
        int count = 1;
        ListNode curr = head;
        while (count < left) {
            beforeLeft = curr;
            curr = curr.next;
            count++;
        }
        revStart = curr;
        ListNode prev = curr;
        curr = curr.next;
        while (curr != null && count < right) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count++;
        }
        if (beforeLeft == null) head = prev;
        else beforeLeft.next = prev;

        if (revStart == null) return prev;
        else revStart.next = curr;

        return head;
    }

    /**
     * Time Complexity :
     * Space Complexity:
     */
    public static ListNode reverseBetween_notWorking(ListNode head, int left, int right) {
        if (head == null) return null;
        if (left >= right) return head;
        ListNode curr = head;
        ListNode prevLeft = null;
        ListNode leftNode = null;
        ListNode rightNode = null;
        int count = 1;
        while (curr != null) {
            if (count == left) {
                leftNode = curr;
            }
            if (count == right) {
                rightNode = curr;
                break;
            }
            if (leftNode == null) prevLeft = curr;
            curr = curr.next;
            count++;
        }
        System.out.println("prevLeft = " + prevLeft.val + ", leftNode = " + leftNode.val + ", rightNode = " + rightNode.val);

        if (prevLeft != null) prevLeft.next = rightNode;
        ListNode currNode = leftNode.next;
        leftNode.next = rightNode.next;
        while (leftNode.val != rightNode.val) {
            ListNode temp = currNode.next;
            currNode.next = leftNode;
            leftNode = currNode;
            currNode = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.prepareTestData_1();
        int left = 3;
        int right = 5;
        test(head, left, right);

        head = ListNode.prepareTestData_palindrome(true);
        left = 1;
        right = 3;
        test(head, left, right);
    }

    private static void test(ListNode head, int left, int right) {
        System.out.println("\nList : " + head);
        System.out.println("Reversed the list between( " + left + " and " + right + ") element(inclusive)");
        head = new LinkedListReversal2().reverseBetween_better(head, left, right);
        System.out.println("List : " + head);
    }
}

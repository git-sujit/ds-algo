package com.sks.leetcode.medium;

import com.sks.leetcode.common.ListNode;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 */
public class LinkedListSort {
    /**
     * MERGE SORT
     * Time Complexity : O(logn)
     * Space Complexity: O(n)
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode();
        ListNode tail = temp;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.prepareTestData_1();
        test(head);
    }

    private static void test(ListNode head) {
        System.out.println("\nList : " + head);
        System.out.println("Sorted List : " + new LinkedListSort().sortList(head));
    }
}

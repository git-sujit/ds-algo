package com.sks.leetcode.medium;

import com.sks.leetcode.common.ListNode;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
public class LinkedListMergeKSortedLists {
    /**
     * MERGE SORT
     * Time Complexity : O(logn), N is the total number of nodes.
     * Space Complexity: O(n)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode res = new ListNode(Integer.MIN_VALUE);
        for (ListNode node : lists) {
            merge(res, node);
        }
        return res.next;
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
}

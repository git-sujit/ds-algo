package com.sks.interview_2026;

import com.sks.leetcode.common.ListNode;

public class M_LeetCode_Medium {
    public static void main(String[] args) {
        System.out.println("----- Merge K Sorted LinkedList -----");
        test_kSortedLinkedList();
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode mergedHead = lists[0];
        for (int i = 1; i < lists.length; i++) {
            mergedHead = mergeTwoLists(mergedHead, lists[i]);
            System.out.println("DEBUG: " + mergedHead);
        }
        return mergedHead;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

    public static ListNode mergeTwoLists_NOT_WORKING(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        else if (list1 == null) return list2;
        else if (list2 == null) return list1;
        ListNode mergedList = (list1.val <= list2.val) ? list1 : list2;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                ListNode temp = list1.next;
                list1.next = list2;
                list1 = temp;
            } else {
                ListNode temp = list2.next;
                list2.next = list1;
                list2 = temp;
            }
        }
        return mergedList;
    }

    /**
     * TEST
     */
    private static void test_kSortedLinkedList() {
        ListNode[] lists = ListNode.prepareListOfLinkedList();
        for (ListNode list : lists) {
            System.out.println(list);
        }
        System.out.println("Merged Sorted List = " + mergeKLists(lists));
    }

}

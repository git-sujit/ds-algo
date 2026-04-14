package com.sks.leetcode.common;

import com.sks.leetcode.easy.LinkedListCycle;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        /*-Easier but wont work if Linked List has cycle
        return val + " -> " + next;
        */
        ListNode cycleStart = LinkedListCycle.startOfCycle(this);
        return cycleStart == null ? toString_noCycle(this) : toString_hasCycle(this, cycleStart);
    }

    private String toString_noCycle(ListNode head) {
        return head == null ? "null" : head.val + " -> " + toString_noCycle(head.next);
    }

    private String toString_hasCycle(ListNode head, ListNode cycleStart) {
        StringBuilder out = new StringBuilder();
        boolean isTaken = false;
        while (head != null) {
            if (head == cycleStart) {
                if (isTaken) break;
                isTaken = true;
                out.append("(CycleStart)");
            }
            out.append(head.val + " -> ");
            head = head.next;
        }
        out.append(cycleStart.val);
        return out.toString();
    }

    public static ListNode prepareTestData_1() {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i < 7; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head;
    }

    public static ListNode prepareTestData_2() {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i = 1; i < 5; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head;
    }

    public static ListNode prepareTestData_cycle() {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        head.next = two;
        ListNode curr = two;
        for (int i = 3; i < 7; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
            if (i == 6) {
                curr.next = two;
                break;
            }
        }
        return head;
    }

    public static ListNode prepareTestData_palindrome(boolean oddSize) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= 3; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        if (oddSize) {
            curr.next = new ListNode(4);
            curr = curr.next;
        }
        for (int i = 3; i >= 1; i--) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head;
    }

    public static ListNode prepareTestData_binary() {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i < 8; i++) {
            curr.next = new ListNode(i % 2);
            curr = curr.next;
        }
        return head;
    }

    public static ListNode[] prepareListOfLinkedList() {
        //1,4,5],[1,3,4],[2,6]
        ListNode list1 = prepareLinkedList(new int[]{1, 4, 5});
        ListNode list2 = prepareLinkedList(new int[]{1, 3, 4});
        ListNode list3 = prepareLinkedList(new int[]{2, 6});
        return new ListNode[]{list1, list2, list3};
    }

    public static ListNode prepareLinkedList(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode curr = head;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
        return head;
    }

}

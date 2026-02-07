package com.sks.interview_2026;

import com.sks.leetcode.common.ListNode;

import java.util.Stack;

public class L_LeetCode_Easy {
    public static void main(String[] args) {
        System.out.println("----- LinkedList -----");
        test_linkedList();
    }

    /**
     * CYCLE
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static ListNode startOfCycle = null;

    public static boolean hasCycle_floyd(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                startOfCycle = slow;
                return true;
            }
        }
        return false;
    }

    /**
     * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val,
     * and return the new head.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static ListNode removeElements(ListNode head, int val) {
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
     * MERGE-TWO-SORTED-LinkedLists
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
     * PALINDROME
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isPalindrome_stack(ListNode head) {
        if (head == null) return false;
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        while (slow != null) {
            if (slow.val != stack.pop()) return false;
            slow = slow.next;
        }
        return true;
    }

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

    /**
     * TEST
     */
    private static void test_linkedList() {
        //HAS-CYCLE
        ListNode head = ListNode.prepareTestData_cycle();
        System.out.println("Linked List : " + head);
        System.out.println("[Floyd] Has Cycle : " + hasCycle_floyd(head));
        System.out.println("Cycle Start Node: " + startOfCycle);
        startOfCycle = null;
        head = ListNode.prepareTestData_1();
        System.out.println("Linked List : " + head);
        System.out.println("[Floyd] Has Cycle : " + hasCycle_floyd(head));
        System.out.println("Cycle Start Node: " + startOfCycle);
        startOfCycle = null;

        // REMOVE
        head = ListNode.prepareTestData_1();
        int remove = 3;
        System.out.println("\nOriginal List: " + head);
        head = removeElements(head, remove);
        System.out.println("List after Removing " + remove + " : " + head);

        // REVERSE
        head = ListNode.prepareTestData_1();
        System.out.println("\nOriginal List: " + head);
        head = reverseList(head);
        System.out.println("Reversed List: " + head);

        //PALINDROME
        head = ListNode.prepareTestData_palindrome(true);
        System.out.println("\nList: " + head);
        System.out.println("[Stack] Is Palindrome: " + isPalindrome_stack(head));

        //MERGE TWO SORTED LIST
        ListNode list1 = ListNode.prepareTestData_1();
        ListNode list2 = ListNode.prepareTestData_2();
        System.out.println("\nLinked List 1: " + list1);
        System.out.println("Linked List 2: " + list2);
        System.out.println("Merged Linked List : " + mergeTwoLists(list1, list2));
        System.out.println();

    }
}

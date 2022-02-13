package com.sks.leatcode.easy;

import com.sks.leatcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean hasCycle_floyd(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static ListNode startOfCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return null;
        ListNode n = head;
        while (n != slow) {
            n = n.next;
            slow = slow.next;
        }
        return n;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static boolean hasCycle_buffer(ListNode head) {
        if (head == null) return false;
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head)) return true;
            visited.add(head);
            head = head.next;
        }
        return false;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.prepareTestData_cycle();
        test(head);

        head = ListNode.prepareTestData_1();
        test(head);
    }

    private static void test(ListNode head) {
        System.out.println("\nLinked List : " + head);
        System.out.println("[Buffer] Has Cycle : " + hasCycle_buffer(head));
        System.out.println("[Floyd] Has Cycle : " + hasCycle_floyd(head));
    }
}

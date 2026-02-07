package com.sks.interview_2026.data_structures;

public class LinkedListNode {
    public int val;
    public LinkedListNode next;

    public LinkedListNode() {
    }

    public LinkedListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
    /*-Easier but wont work if Linked List has cycle
    return val + " -> " + next;
    */
        LinkedListNode cycleStart = startOfCycle(this);
        return cycleStart == null ? toString_noCycle(this) : toString_hasCycle(this, cycleStart);
    }

    public static LinkedListNode startOfCycle(LinkedListNode head) {
        if (head == null) return null;
        LinkedListNode slow = head;
        LinkedListNode fast = head;
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
        LinkedListNode n = head;
        while (n != slow) {
            n = n.next;
            slow = slow.next;
        }
        return n;
    }

    private String toString_noCycle(LinkedListNode head) {
        return head == null ? "null" : head.val + " -> " + toString_noCycle(head.next);
    }

    private String toString_hasCycle(LinkedListNode head, LinkedListNode cycleStart) {
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

    public static LinkedListNode prepareTestData_1() {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode curr = head;
        for (int i = 2; i < 7; i++) {
            curr.next = new LinkedListNode(i);
            curr = curr.next;
        }
        return head;
    }

    public static LinkedListNode prepareTestData_cycle() {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode two = new LinkedListNode(2);
        head.next = two;
        LinkedListNode curr = two;
        for (int i = 3; i < 7; i++) {
            curr.next = new LinkedListNode(i);
            curr = curr.next;
            if (i == 6) {
                curr.next = two;
                break;
            }
        }
        return head;
    }

    public static LinkedListNode prepareTestData_palindrome(boolean oddSize) {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode curr = head;
        for (int i = 2; i <= 3; i++) {
            curr.next = new LinkedListNode(i);
            curr = curr.next;
        }
        if (oddSize) {
            curr.next = new LinkedListNode(4);
            curr = curr.next;
        }
        for (int i = 3; i >= 1; i--) {
            curr.next = new LinkedListNode(i);
            curr = curr.next;
        }
        return head;
    }

    public static LinkedListNode prepareTestData_binary() {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode curr = head;
        for (int i = 2; i < 8; i++) {
            curr.next = new LinkedListNode(i % 2);
            curr = curr.next;
        }
        return head;
    }

}

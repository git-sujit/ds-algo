package com.sks.leatcode.easy;

import com.sks.leatcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 * No cycle & retain original structure
 */
public class LinkedListIntersection {
    /**
     * Time Complexity : O(N+M), N, M- length of linked lists
     * Space Complexity: O(N), N- length of list thats stored in Hash Table
     */
    public ListNode getIntersectionNode_better(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    /**
     * Time Complexity : O(N+M), N, M- length of linked lists
     * Space Complexity: O(N), N- length of list thats stored in Hash Table
     */
    public ListNode getIntersectionNode_hashTable(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode_bruteForce(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode hB = headB;
            while (hB != null) {
                if (headA == hB) return headA;
                hB = hB.next;
            }
            headA = headA.next;
        }
        return null;
    }


}

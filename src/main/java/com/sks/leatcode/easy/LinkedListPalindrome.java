package com.sks.leatcode.easy;

import com.sks.leatcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 */
public class LinkedListPalindrome {
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

    public static boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        List<Integer> lst = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            lst.add(curr.val);
            curr = curr.next;
        }
        int front = 0;
        int back = lst.size() - 1;
        while (front < back) {
            if (lst.get(front) != lst.get(back)) return false;
            front++;
            back--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.prepareTestData_palindrome(true);
        test(head);

        head = ListNode.prepareTestData_palindrome(false);
        test(head);

        head = ListNode.prepareTestData_1();
        test(head);
    }

    private static void test(ListNode head) {
        System.out.println("\nList: " + head);
        System.out.println("Is Palindrome: " + isPalindrome(head));
        System.out.println("[Stack] Is Palindrome: " + isPalindrome_stack(head));
    }
}

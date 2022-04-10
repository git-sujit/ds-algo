package com.sks.leatcode.easy;

import com.sks.leatcode.common.ListNode;

public class LinkedListBinaryToDecimal {
    public int getDecimalValue(ListNode head) {
        if (head == null) return 0;
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
        }
        return num;
    }
}

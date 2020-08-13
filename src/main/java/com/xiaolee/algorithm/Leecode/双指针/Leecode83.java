package com.xiaolee.algorithm.Leecode.双指针;

public class Leecode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode right = head.next;
        ListNode left = head;

        while (right != null) {
            if (right.val == left.val) {
                while (right != null && right.val == left.val) {
                    right = right.next;
                }

                if (right == null) {
                    left.next = null;
                    return head;
                } else {
                    left.next = right;
                }
            }

            right = right.next;
            left = left.next;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

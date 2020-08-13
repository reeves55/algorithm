package com.xiaolee.algorithm.Leecode.链表;

public class Leecode206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode root = reverseList(head.next);
        head.next.next = head;
        return root;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

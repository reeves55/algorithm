package com.xiaolee.algorithm.Leecode;

public class Leecode2 {
    public static void main(String[] args) {
        Leecode2 main = new Leecode2();
        ListNode l1 = new ListNode();
        l1.val =1;
        l1.next = null;

        ListNode l2 = new ListNode();
        l2.val = 9;
        ListNode l2Next = new ListNode();
        l2Next.val = 9;
        l2Next.next = null;
        l2.next = l2Next;

        ListNode result = main.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int increase = 0;
        ListNode sentinel = new ListNode();
        sentinel.val = -1;
        ListNode index = sentinel;

        while (l1 != null || l2 != null) {
            int l1Val = (l1 != null)? l1.val : 0;
            int l2Val = (l2 != null)? l2.val : 0;
            int current = (l1Val + l2Val + increase) % 10;
            ListNode node = new ListNode();
            node.val = current;
            index.next = node;
            index = index.next;

            increase = (l1Val + l2Val + increase) / 10;

            l2 = (l2 != null)? l2.next : null;
            l1 = (l1 != null)? l1.next : null;
        }

        if (increase != 0) {
            ListNode node = new ListNode();
            node.val = increase;
            index.next = node;
        }

        return sentinel.next;
    }
}

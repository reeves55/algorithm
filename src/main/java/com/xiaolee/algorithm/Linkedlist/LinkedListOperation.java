package com.xiaolee.algorithm.Linkedlist;

public class LinkedListOperation {
    public static void main(String[] args) {

    }

    class MyLinkedList<K, V> {
        Item<K, V> head;
        Item<K, V> tail;

        MyLinkedList(){
            head = tail = null;
        }

        void addFirst(Item<K, V> item) {
            Item<K, V> h = head;
            head = item;
            if (h != null) {
                head.next = h;
            }


        }

        void removeLast() {
            if (tail != null) {
                tail = tail.pre;
            }


        }
    }

    class Item<K, V> {
        private K key;
        private V value;
        Item<K, V> pre;
        Item<K, V> next;
    }
}

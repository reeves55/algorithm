package com.xiaolee.algorithm.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private int capacity;
    private Map<K, Item<K, V>> map;
    private DoubleDirectLinkedList<K, V> linkedList;

    public LRUCache(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();

        this.capacity = capacity;
        // 保证刚好不扩容
        map = new HashMap<>(Math.round(capacity / 0.75f));
        linkedList = new DoubleDirectLinkedList<>();
    }

    /**
     * 添加元素
     */
    public synchronized V put(K key, V value) {
        Item<K, V> exist = map.get(key);
        if (exist != null) {
            linkedList.remove(exist);
        }

        if (linkedList.size() >= capacity) {
            linkedList.removeLast();
        }

        Item<K, V> newItem = new Item<>(key, value);
        linkedList.addFirst(newItem);
        map.put(key, newItem);

        return value;
    }

    /**
     * 访问元素
     */
    public synchronized V get(K key) {
        if (map.get(key) == null) {
            return null;
        }

        Item<K, V> item = map.get(key);
        linkedList.remove(item);
        linkedList.addFirst(item);
        return item.getValue();
    }

    /**
     * 删除元素
     */
    public synchronized V remove(K key) {
        Item<K, V> item = map.get(key);
        if (item != null) {
            linkedList.remove(item);
            return item.getValue();
        }

        return null;
    }

    public void print() {
        linkedList.print();
        System.out.println();
    }

    class DoubleDirectLinkedList<K, V> {
        Item<K, V> head;
        Item<K, V> tail;
        int count;

        DoubleDirectLinkedList() {
            head = tail = null;
        }

        void remove(Item<K, V> item) {
            Item<K, V> pre = item.pre;
            Item<K, V> next = item.next;

            if (pre == null) {
                head = next;
            } else {
                pre.next = next;
                item.pre = null;
            }

            if (next == null) {
                tail = pre;
            } else {
                next.pre = pre;
                item.next = null;
            }

            count--;
        }

        void addFirst(Item<K, V> item) {
            if (head == null) {
                head = item;
                tail = item;
            } else {
                item.next = head;
                head.pre = item;
                head = item;
            }

            count++;
        }

        void removeLast() {
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.pre;
                tail.next = null;
            }

            count--;
        }

        int size() {
            return count;
        }

        public void print() {
            Item<K, V> pointer = head;
            while (pointer != null) {
                pointer.print();
                pointer = pointer.next;
            }
        }
    }


    class Item<K, V> {
        K key;
        V value;
        Item<K, V> pre;
        Item<K, V> next;

        Item(K key, V value) {
            this.key = key;
            this.value = value;
            pre = next = null;
        }

        public V getValue() {
            return value;
        }

        public void print() {
            System.out.print(" <" + key.toString() + "," + value.toString() + ">");
        }
    }
}

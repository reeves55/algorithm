package com.xiaolee.algorithm.Queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {
    private int capacity;
    private int count;
    private int putIndex;
    private int takeIndex;
    private Object[] items;

    private ReentrantLock lock;
    private Condition notFull;
    private Condition notEmpty;

    public MyBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.putIndex = this.takeIndex = 0;
        this.items = new Object[capacity];
        this.lock = new ReentrantLock();
        this.notFull = lock.newCondition();
        this.notEmpty = lock.newCondition();
    }

    public boolean put(Object item) throws InterruptedException {
        lock.lock();
        try {
            while (count == capacity) {
                notFull.await();
            }
            this.items[putIndex] = item;
            count++;
            if (++putIndex == capacity) {
                putIndex = 0;
            }
            notEmpty.signal();
            return true;
        }finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();

        try {
            while (count == 0) {
                notEmpty.await();
            }
            Object result = this.items[takeIndex];
            count--;
            if (++takeIndex == capacity) {
                takeIndex = 0;
            }
            notFull.signal();
            return result;
        }finally {
            lock.unlock();
        }
    }
}

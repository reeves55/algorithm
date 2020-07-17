package com.xiaolee.algorithm.Thread;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadPool {
    private BlockingQueue<Runnable> tasks;
    private List<Thread> threads;
    private int poolSize;
    private int workCount;
    private ReentrantLock lock;

    public MyThreadPool(int poolSize, int queueSize) {
        this.tasks = new ArrayBlockingQueue<>(queueSize);
        this.poolSize = poolSize;
        this.workCount = 0;
        this.lock = new ReentrantLock();
    }

    public boolean execute(Runnable r) {
        lock.lock();

        try {
            if (workCount < poolSize) {
                MyThread myThread = new MyThread(r);
                threads.add(myThread);
                myThread.start();
            }else {
                if (!tasks.offer(r)) {
                   return false;
                }
            }

            return true;
        }finally {
            lock.unlock();
        }
    }




    class MyThread extends Thread {
        Runnable task;

        MyThread(Runnable r) {
            this.task = r;
        }

        @Override
        public void run() {

            while (true) {
                if (task != null) {
                    task.run();
                }

                try {
                    task = tasks.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

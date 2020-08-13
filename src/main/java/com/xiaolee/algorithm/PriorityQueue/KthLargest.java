package com.xiaolee.algorithm.PriorityQueue;

import java.util.PriorityQueue;

public class KthLargest {
    private int count;
    private PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        count = k;
        queue = new PriorityQueue<>(k);

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (queue.size() < count) {
            queue.offer(val);
        } else {
            if (val > queue.peek()) {
                queue.poll();
                queue.add(val);
            }
        }

        return queue.peek();
    }
}

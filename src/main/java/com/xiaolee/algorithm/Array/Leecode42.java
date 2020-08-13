package com.xiaolee.algorithm.Array;

public class Leecode42 {

    public int maxSubArray(int[] nums) {
        int sum = nums[0];

        int index = 1;
        while (index < nums.length) {
            nums[index] = nums[index-1] > 0 ? nums[index] + nums[index-1] : nums[index];
            if (nums[index] > sum) {
                sum = nums[index];
            }

            index++;
        }

        return sum;
    }
}

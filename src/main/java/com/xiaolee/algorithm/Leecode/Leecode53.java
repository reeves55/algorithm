package com.xiaolee.algorithm.Leecode;

public class Leecode53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int maxVal = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (i == 0) {
                maxVal = Math.max(maxVal, nums[i]);
            }

            if (i > 0) {
                if (nums[i-1] > 0) {
                    nums[i] = nums[i] + nums[i-1];
                }

                maxVal = Math.max(maxVal, nums[i]);
            }
        }

        return maxVal;
    }
}

package com.xiaolee.algorithm.Leecode;

public class Leecode1248 {
    public static void main(String[] args) {
        Leecode1248 main = new Leecode1248();
        int count = main.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2);
        System.out.println(count);
    }

    public int numberOfSubarrays(int[] nums, int k) {
        if (nums.length < k || k == 0) return 0;

        int left = 0;
        int right = 0;

        int count = 0;
        int windowCount = 0;
        while (right < nums.length) {
            if (nums[right] % 2 == 1) {
                windowCount++;
            }

            if (windowCount == k) {
                count++;

                // 移动右指针
                while (++right<nums.length && nums[right] % 2==0) {
                    count++;
                }

                // 开始移动左指针
                while (left < right && nums[left] % 2 == 0) {
                    left++;
                    count++;
                }

                left++;
                windowCount--;
            }

            right++;
        }

        return count;
    }
}

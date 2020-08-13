package com.xiaolee.algorithm.Array;

public class Leecode121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minVal = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minVal) {
                minVal = prices[i];
            } else {
                maxProfit = Math.max((prices[i] - minVal), maxProfit);
            }
        }

        return maxProfit;
    }
}

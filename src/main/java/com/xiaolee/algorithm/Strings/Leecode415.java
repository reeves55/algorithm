package com.xiaolee.algorithm.Strings;


public class Leecode415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder("");
        int num1Index = num1.length() - 1;
        int num2Index = num2.length() - 1;
        int temp = 0;

        while (num1Index >= 0 && num2Index >= 0) {
            int sum = Integer.parseInt(num1.substring(num1Index, num1Index + 1)) + Integer.parseInt(num2.substring(num2Index, num2Index + 1));
            if (sum + temp >= 10) {
                temp = 1;
            } else {
                temp = 0;
            }

            sb.insert(0, String.valueOf(sum - 10));

            num1Index--;
            num2Index--;
        }

        if (num1Index > 0) {
            while (num1Index >= 0) {

                num1Index--;
            }
        }

        if (num2Index > 0) {

        }

        return sb.toString();
    }
}

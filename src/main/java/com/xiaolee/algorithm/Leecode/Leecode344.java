package com.xiaolee.algorithm.Leecode;

public class Leecode344 {

    public void reverseString(char[] s) {
        if (s.length < 2) {
            return;
        }

        int left = 0;
        int right = s.length -1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}

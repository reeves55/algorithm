package com.xiaolee.algorithm.Leecode.回溯法;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字符组合
 */
public class Leecode17 {
    public static void main(String[] args) {
        Leecode17 main = new Leecode17();
        String input = "23";
        System.out.println(main.letterCombinations(input));
    }


    List<String> result = new ArrayList<>();
    // 0->2, 1->3, ...
    char[][] template = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', '0'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }

        search("", digits);
        return result;
    }

    public void search(String temp, String digits) {
        if (digits.length() == 0) {
            result.add(temp);
            return;
        }

        int digit = Integer.parseInt(digits.substring(0, 1)) - 2;
        for (int i = 0; i < template[digit].length; i++) {
            search(temp + template[digit][i], digits.substring(1));
        }
    }


}

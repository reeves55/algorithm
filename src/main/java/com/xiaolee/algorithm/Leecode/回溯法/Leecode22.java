package com.xiaolee.algorithm.Leecode.回溯法;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class Leecode22 {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate("", 0, 0, n);
        return result;
    }

    public void generate(String solution, int left, int right, int n) {
        if (left == n && right == n) {
            result.add(solution);
            return;
        }

        if (left < right) {
            return;
        }

        if (left < n) {
            generate(solution + "(", left + 1, right, n);
        }

        if (right < n) {
            generate(solution + ")", left, right + 1, n);
        }
    }
}

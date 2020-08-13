package com.xiaolee.algorithm.Leecode.回溯法;

import java.util.ArrayList;
import java.util.List;

/**
 * 无重复字符串的排列组合
 */
public class Leecode0807 {
    public List<String> result = new ArrayList<>();

    public String[] permutation(String S) {
        search(S.toCharArray(), "");
        String[] strings = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            strings[i] = result.get(i);
        }

        return strings;
    }

    public void search(char[] chars, String path) {
        if (path.length() == chars.length) {
            result.add(path);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (path.indexOf(chars[i]) == -1) {
                search(chars, path + chars[i]);
            }
        }
    }
}

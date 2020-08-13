package com.xiaolee.algorithm.Leecode;

import java.util.ArrayList;
import java.util.List;

public class Leecode46 {
    public static void main(String[] args) {
        Leecode46 main = new Leecode46();
        System.out.println(main.permute(new int[]{1, 2, 3}));
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> solution = new ArrayList<>();
        search(nums, solution);
        return result;
    }

    public void search(int[] nums, List<Integer> solution) {
        if (solution.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(solution);
            result.add(temp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!solution.contains(nums[i])) {
                solution.add(nums[i]);
                search(nums, solution);
                solution.remove(solution.size() - 1);
            }
        }
    }
}

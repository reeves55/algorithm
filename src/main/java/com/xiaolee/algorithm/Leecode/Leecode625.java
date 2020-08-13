package com.xiaolee.algorithm.Leecode;

public class Leecode625 {
    public static void main(String[] args) {
        Leecode625 main = new Leecode625();
        System.out.println(main.smallestFactorization(27000000));
    }

    public int smallestFactorization(int a) {
        if (a < 2) return a;

        long result = 0;
        long multi = 1;
        for (int i=9; i>=2; i--) {
            while (a % i == 0) {
                a /= i;
                result = i * multi + result;
                multi *= 10;
            }
        }

        return (a < 2 && result > 0 && result <= Integer.MAX_VALUE) ? (int) result : 0;
    }
}

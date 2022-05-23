package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/07/17
 */
public class Solution50 {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) return x == 1 || x == -1 ? 1 : 0;
        if (n < 0) return 1 / myPow(x, -n);
        if (n == 0) return 1;
        if (n % 2 == 0)
            return myPow(x * x, n / 2);
        return myPow(x, n - 1) * x;
    }

    @Test
    void myPowTest() {
        double[] x = {2.0, 2.1, 2.0};
        int[] n = {10, 3, -2};
        for (int i = 0; i < x.length; i++) {
            System.out.println(myPow(x[i], n[i]));
        }

    }
}

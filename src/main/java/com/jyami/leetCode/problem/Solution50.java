package com.jyami.leetCode.problem;

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

}

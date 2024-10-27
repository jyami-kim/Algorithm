package com.jyami.leetCode.problem;


/**
 * Created by jyami on 2020/07/01
 */
public class Solution441 {
    public int arrangeCoins(int n) {
        long temp = 0;
        int increase = 1;
        while (temp <= n && temp <= Integer.MAX_VALUE) {
            temp += increase;
            increase++;
        }
        return increase - 2;
    }
}

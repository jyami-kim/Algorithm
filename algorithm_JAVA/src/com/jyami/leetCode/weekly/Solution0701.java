package com.jyami.leetCode.weekly;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Created by jyami on 2020/07/01
 */
public class Solution0701 {
    public int arrangeCoins(int n) {
        long temp = 0;
        int increase = 1;
        while (temp <= n && temp <= Integer.MAX_VALUE) {
            temp += increase;
            increase++;
        }
        return increase - 2;
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 5, 8})
    void arrangeCoinsTest(int i) {
        System.out.println(arrangeCoins(i));
    }
}

package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/07/05
 */
public class Solution264 {
    public int nthUglyNumber(int n) {

        int[] dp = new int[n];
        dp[0] = 1;

        int ugly, i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < n; i++) {
            ugly = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
            dp[i] = ugly;
            if (ugly == dp[i2] * 2) ++i2;
            if (ugly == dp[i3] * 3) ++i3;
            if (ugly == dp[i5] * 5) ++i5;
        }

        return dp[n-1];
    }

    @Test
    void nthUglyNumberTest() {
        System.out.println(nthUglyNumber(10));
    }
}

package com.jyami.leetCode.problem;

/**
 * Created by jyami on 2020/06/28
 */
public class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int square = 1;
        for (int i = 1; i <= n; i++) {
            if ((square + 1) * (square + 1) <= i) {
                square += 1;
            }
            int min = Integer.MAX_VALUE;
            for (int j = square; j >= 1; j--) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }


}

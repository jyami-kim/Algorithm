package com.jyami.leetCode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void numSquaresTest(int i) {
        System.out.println("num : " + i + " => " + numSquares(i));
    }

}

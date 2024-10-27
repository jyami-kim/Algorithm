package com.jyami.leetCode.problem;

/**
 * Created by jyami on 2020/07/29
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;

        if (prices.length == 2)
            return Math.max(prices[1] - prices[0], 0);

        int days = prices.length;
        int[][] dp = new int[days][2];
        // 0 : 주식이 있다! // 1 : 주식이 없다!

        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[1][0] = Math.max(dp[0][0], dp[0][1] - prices[1]);
        dp[1][1] = Math.max(dp[0][0] + prices[1], dp[0][1]);

        for (int i = 2; i < days; i++) {
            dp[i][0] = Math.max(dp[i - 2][1] - prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }

        return Math.max(dp[days - 1][0], dp[days - 1][1]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 2};
        int i = new Solution309().maxProfit(arr);
        System.out.println(i);
    }


}

package com.jyami.baekjoon;

import java.util.Scanner;

public class Main_9084 {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i=0; i<testCase; i++){
            int coinNum = sc.nextInt();
            int [] coins = new int [coinNum + 1];
            for(int j = 1; j<=coinNum ;j++){
                coins[j] = sc.nextInt();
            }
            int result = sc.nextInt();
            int [] dp = new int[result + 1];
            coinGame(result, coins, dp, coinNum);
        }

        System.out.println(sb);
    }

    public static void coinGame(int result, int[] coins, int[] dp, int coinNum){
        dp[0] = 1;
        for( int i = 1 ; i<= coinNum; i++){
            for(int j = coins[i]; j<= result; j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        sb.append(dp[result]+"\n");
    }
}

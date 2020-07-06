package com.jyami.baekjoon;

import java.util.Scanner;

public class Main_1463 {

    public static int dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input > 3) {
            dp = new int[input + 1];
        } else {
            dp = new int[4];
        }
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= input; i++) {
            int result = i - 1;
            if (i % 3 == 0) {
                int tmp1 = i / 3;
                result = minCheck(result, tmp1);
            }
            if (i % 2 == 0) {
                int tmp2 = i / 2;
                result = minCheck(result, tmp2);
            }
            dp[i] = dp[result] + 1;
        }

        System.out.println(dp[input]);
    }

    public static int minCheck(int tmp1, int tmp2) {
        if (dp[tmp1] > dp[tmp2])
            return tmp2;
        return tmp1;
    }
}

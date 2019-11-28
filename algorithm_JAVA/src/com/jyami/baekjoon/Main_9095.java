package com.jyami.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_9095 {
    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);

        int num = s.nextInt();
        int max = 0;
        List<Integer> list = new ArrayList<>();


        for (int i = 0; i < num; i++) {
            int input = s.nextInt();
            list.add(input);
            if (input > max)
                max = input;
        }

        int dp[] = new int[max + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (Integer integer : list) {
            System.out.println(dp[integer]);
        }

    }
}

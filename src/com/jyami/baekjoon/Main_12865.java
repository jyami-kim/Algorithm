package com.jyami.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main_12865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int itemNum = Integer.parseInt(s[0]);
        int maxWeight = Integer.parseInt(s[1]);
        int[][] dp = new int[itemNum + 1][maxWeight + 1];

        for (int i = 1; i <= itemNum; i++) {  // 처음부분은 따로 설정할 필요없게 비워있는 0인덱스 추가
            String[] ss = br.readLine().split(" ");
            int itemWeight = Integer.parseInt(ss[0]);
            int itemValue = Integer.parseInt(ss[1]);

            for (int j = 0; j <= maxWeight; j++) {
                if(j < itemWeight) {  // 해당 무게 되기전까진 앞의 무게 그대로 사용
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - itemWeight] + itemValue);
            }
        }
        System.out.println(dp[itemNum][maxWeight]);
    }
}
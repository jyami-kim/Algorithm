package com.jyami.codejam.april2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jyami on 2020/04/04
 */
public class Solution1 {
    public static void main(String[] args) throws IOException {

        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] n = new int[t];
        int[][][] m = new int[t][100][100];
        int[] kOut = new int[t];
        int[] r = new int[t];
        int[] c = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = Integer.parseInt(br.readLine());
            for (int j = 0; j < n[i]; j++) {
                String[] row = br.readLine().split(" ");
                for (int k = 0; k < n[i]; k++) {
                    m[i][j][k] = Integer.parseInt(row[k]);
                    if (j == k) {
                        kOut[i] += m[i][j][k];
                    }
                }
            }
        }

        //process
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n[i]; j++) {
                boolean[] rowCheck = new boolean[n[i]];
                boolean[] colCheck = new boolean[n[i]];
                for (int k = 0; k < n[i]; k++) {
                    rowCheck[m[i][j][k]-1] = true; // r
                    colCheck[m[i][k][j]-1] = true; // c
                }
                boolean isR= false, isC = false;
                for (int k = 0; k < n[i]; k++) {
                    if(!rowCheck[k]){
                        isR = true;
                    }
                    if(!colCheck[k]){
                        isC = true;
                    }
                }
                if(isR)
                    r[i]++;
                if(isC)
                    c[i]++;
            }

        }

        //output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(String.format("Case #%d: %d %d %d\n", i + 1, kOut[i], r[i], c[i]));
        }
        System.out.println(sb.toString());

    }
}

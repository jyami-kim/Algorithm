package com.jyami.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1146 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        int index[][] = new int[n][3];
        int result[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            result[0][i] = arr[0][i];
            index[0][i] = i;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
    }

    public static int getIndex(int i, int j) {

        return 1;
    }
}

package com.jyami.ewhaAlgorithm;

import java.util.Scanner;

public class Epper2019Num7 {
    private static int r;
    private static int c;
    private static int zr;
    private static int zc;
    private static Scanner sc;

    public static void main(String args[]) {
        sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();


        char[][] word = new char[r][c];

        zc = sc.nextInt();
        zr = sc.nextInt();

        for (int i = 0; i < r; i++) {
            char[] input = sc.next().toCharArray();
            for (int j = 0; j < c; j++) {
                word[i][j] = input[j];
            }
        }

        for (int i = 0; i < c; i++) {
            String subResult = printRow(word[i]);
            for (int j = 0; j < zc; j++) {
                System.out.println(subResult);
            }
        }
    }

    public static String printRow(char[] word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < zr; j++) {
                sb.append(word[i]);
            }
        }
        return sb.toString();

    }
}

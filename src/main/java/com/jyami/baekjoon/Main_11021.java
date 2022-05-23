package com.jyami.baekjoon;

import java.util.Scanner;

public class Main_11021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.printf("Case #%d: %d\n", i + 1, a + b);
        }
    }
}

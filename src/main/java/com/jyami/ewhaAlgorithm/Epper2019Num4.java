package com.jyami.ewhaAlgorithm;

import java.util.Scanner;

public class Epper2019Num4 {
    private static Scanner sc;

    public static void main(String args[]) {
        sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        int count = 0;
        if (row < col) {
            row--;
            if (row == 0) {
                System.out.println(count);
                return;
            }
            count++;
        }
        while (true) {
            col--;
            if (col == 0) {
                System.out.println(count);
                return;
            }
            count++;
            row--;
            if (row == 0) {
                System.out.println(count);
                return;
            }
            count++;
        }

    }
}

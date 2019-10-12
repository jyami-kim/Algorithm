package com.jyami.ewhaAlgorithm;

import java.util.Scanner;

public class Epper2019Num1 {
    private static Scanner sc;

    public static void main(String args[]) {

        sc = new Scanner(System.in);
        int year = sc.nextInt();
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("T");
        } else {
            System.out.println("F");
        }
    }

}

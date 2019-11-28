package com.jyami.ewhaAlgorithm;

import java.util.Scanner;

public class Epper2019Num2 {
    private static Scanner sc;

    public static void main(String[] args) {

        sc = new Scanner(System.in);


        int number = sc.nextInt();
        int[] score = new int[number];
        int sum = 0;
        double avg = 0;
        int overPeople = 0;

        for (int i = 0; i < number; i++) {
            score[i] = sc.nextInt();
            sum += score[i];
        }


        avg = (double) sum / (double) number;

        for (int i = 0; i < number; i++) {
            if (score[i] > avg) {
                overPeople += 1;
            }
        }

        double result = (double) overPeople / (double) number * 100;

        System.out.printf("%.3f", result);
        System.out.println("%");


    }
}

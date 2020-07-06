package com.jyami.baekjoon;

import java.util.Scanner;

public class Main_1110 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count = 0;

        if (input / 10 == 0 && input != 10) {
            input = input * 10 + input;
        }

        int temp = input;

        do {
            int tenDigit = temp % 10;
            int oneDigit = (temp / 10 + temp % 10) % 10;
            temp = tenDigit * 10 + oneDigit;
            count++;
        } while (temp != input);

        System.out.println(count);
    }
}

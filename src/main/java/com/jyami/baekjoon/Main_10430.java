package com.jyami.baekjoon;

import java.util.Scanner;

public class Main_10430 {
    public static void main(String args[]){
        // (A+B)%C
        // ((A%C) + (B%C))%C
        // (A×B)%C
        // ((A%C) × (B%C))%C
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();

        System.out.println((A+B)%C);
        System.out.println(((A%C) + (B%C))%C);
        System.out.println((A*B)%C);
        System.out.println(((A%C) * (B%C))%C);
    }
}

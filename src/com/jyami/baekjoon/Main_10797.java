package com.jyami.baekjoon;

import java.util.Scanner;

public class Main_10797 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int wrong = 0;
        for(int i=0; i<5; i++){
            if(in.nextInt() == num)
                wrong++;
        }
        System.out.println(wrong);
    }
}

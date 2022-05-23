package com.jyami.baekjoon;

import java.util.Scanner;

public class Main_10039 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int sum = 0;
        for(int i=0; i<5; i++){
            int score = in.nextInt();
            if(score < 40)
                sum += 40;
            else
                sum += score;
        }
        System.out.println(sum/5);
    }
}

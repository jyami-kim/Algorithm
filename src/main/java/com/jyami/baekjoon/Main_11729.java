package com.jyami.baekjoon;

import java.io.*;

public class Main_11729 {

    public static StringBuilder sb = new StringBuilder();
    public static int count =0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        hanoi(number, 1,3,2);
        System.out.println(count);
        System.out.println(sb.toString());

    }

    public static void hanoi(int size,int from, int to, int by){
        if(size == 1){
            sb.append(from+ " " + to+"\n");
            count++;
        }else{
            hanoi(size-1, from, by, to);
            count++;
            sb.append(from+ " " + to+"\n");
            hanoi(size-1, by, to, from);
        }
    }
}

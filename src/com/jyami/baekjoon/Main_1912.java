package com.jyami.baekjoon;

import java.io.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912 {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number =Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int [] a = new int[number];
        int count=0;
        Integer max = null;

        while(st.hasMoreTokens()){
            a[count] = Integer.valueOf(st.nextToken());
            if( count == 0 ){
                max = a[0];
            }
            if(max < a[count]){
                max = a[count];
            }
            count++;
        }

        int dp[] = new int[number];

        dp[0] = a[0];
        for(int i =1 ; i<number; i++){
            if(dp[i-1] + a[i] > a[i]){
                dp[i] = + a[i] + dp[i-1];
            }else{
                dp[i] = a[i];
            }
            if(dp[i] >max){
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}

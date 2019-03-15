package com.jyami;

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

        int b[] = new int[number];

        for(int i=0 ; i< number; i++){
            for(int j = 0; j<number-i; j++){
                b[j] = b[j] + a[i+j];
                if(max < b[j]){
                    max = b[j];
                }
            }
        }

        System.out.println(max);
    }
}

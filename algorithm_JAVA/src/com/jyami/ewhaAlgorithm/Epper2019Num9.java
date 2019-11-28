package com.jyami.ewhaAlgorithm;

import java.util.Scanner;

public class Epper2019Num9 {

    private static Scanner sc;

    public static void main(String args[]){
        sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[][] arr = new int[num][num];

        for(int i =0 ; i<num; i++){
            for(int j =0 ; j<i+1; j++){
                arr[i][j]= sc.nextInt();
            }
        }

        for(int i = num-1; i>0 ; i--){
            for(int j =0 ; j<i; j++){
                int a = arr[i][j];
                int b = arr[i][j+1];
                if(a>b){
                    arr[i-1][j] += a ;
                }else{
                    arr[i-1][j] += b;
                }
            }
        }

        System.out.println(arr[0][0]);

    }
}

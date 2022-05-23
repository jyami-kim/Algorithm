package com.jyami.ewhaAlgorithm;

import java.util.Scanner;

public class Epper2019Num6 {

    private static Scanner sc;

    public static void main(String args[]){
        sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        double y2=0;
        double x2=0;

        double width = 250 * 250 /2;

        if(x + y == 250){
            x2 = 250 - width/y;

            y2 = 250 - width/x;

            if(x2 < 0){
                x2 =0;
            }else{
                y2 =0;
            }

        }else{ // ���� �ִ� ���
            if(y == 0){
                y2 = width/(250-x);
                x2 = 250 - y2;
            }else{
                x2 = width/(250-y);
                y2 = 250 - x2;
            }
        }

        System.out.printf("%.2f %.2f", x2, y2);


    }
}

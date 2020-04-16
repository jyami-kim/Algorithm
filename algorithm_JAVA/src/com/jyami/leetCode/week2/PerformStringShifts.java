package com.jyami.leetCode.week2;

import java.util.Arrays;

/**
 * Created by jyami on 2020/04/15
 */
public class PerformStringShifts {

    public static void main(String[] args) {

        String s = "abcdefg";
//        String s = "abc";
//        int[][] shift = {{0,1},{1,2}};
        int[][] shift = {{1, 1}, {1, 1}, {0, 2}, {1, 3}};
//        int[][] shift = {{0,3}};
//
//        System.out.println(s.substring(1));
//        System.out.println(s.substring(0, 1));
//        System.out.println(s.substring(0, 2));

        String s1 = new PerformStringShifts().stringShift(s, shift);
        System.out.println(s1);
    }

    public String stringShift(String s, int[][] shift) {
        int l = 0;
        int sum = 0;
        for (int i = 0; i < shift.length; i++) {
            if(i == l){
                sum -= shift[i][1];
            }else{
                sum += shift[i][1];
            }
        }
        if(sum > 0){ // r
            return s.substring(s.length()-sum-1) + s.substring(0, sum) ;
        }else{ // l
            sum = -sum;
            return s.substring(sum) + s.substring(0, sum);
        }
    }
}

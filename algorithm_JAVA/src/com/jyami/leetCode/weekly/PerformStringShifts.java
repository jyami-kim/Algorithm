package com.jyami.leetCode.weekly;

/**
 * Created by jyami on 2020/04/15
 */
public class PerformStringShifts {

    public static void main(String[] args) {

        String s = "abcdefg";
//        String s = "abc";
        int[][] shift = {{1, 1}}; // l로 1번 이동.
//        int[][] shift = {{0,1},{1,2}};
//        int[][] shift = {{1, 1}, {1, 1}, {0, 2}, {1, 3}};
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
            if (i == l) {
                sum -= shift[i][1];
            } else {
                sum += shift[i][1];
            }
        }
        String left;
        String right;
        if (sum > 0) { // r
            left = s.substring(s.length() - sum);
            right = s.substring(0, sum + 1);
        } else { // l
            sum = -sum;
            left = s.substring(sum);
            right = s.substring(0, sum);
        }
        System.out.println(left);
        System.out.println(right);
        return left + right;
    }
}

package com.jyami.exam.hackerRank;

import org.junit.jupiter.api.Test;


/**
 * Created by jyami on 2020/06/29
 */
public class KakaoResult1 {

    /*
     * Complete the 'solution' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int CHARACTER_DIFF = 26;  // A = 65 , Z = 90

    public static long solution(String s) {
        long sum = 0;
        int from = 'A';
        for (char to : s.toCharArray()) {
            sum += getDistance(from, to);
            from = to;
        }
        return sum;
    }

    public static int getDistance(int from, int to) {
        int rightDistance = Math.abs(from - to);
        int leftDistance = CHARACTER_DIFF - rightDistance;
        return Math.min(rightDistance, leftDistance);
    }

    @Test
    void solutionTest() {

        long bza = solution("AZGB");
        System.out.println(bza);
    }


}

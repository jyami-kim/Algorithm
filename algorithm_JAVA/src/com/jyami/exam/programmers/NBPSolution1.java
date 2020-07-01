package com.jyami.exam.programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyami on 2020/07/01
 */

public class NBPSolution1 {

    public boolean solution(int[] arrA, int[] arrB) {
        if (arrA.length != arrB.length)
            return false;
        List<Integer> start = new ArrayList<>();
        for (int i = 0; i < arrB.length; i++) {
            if (arrA[0] == arrB[i]) {
                start.add(i);
            }
        }

        if (start.isEmpty())
            return false;


        for (Integer startIndex : start) {
            int i;
            for (i = 0; i < arrA.length; i++) {
                if (arrA[i] != arrB[startIndex]) {
                    break;
                }
                startIndex = (startIndex + 1) % arrB.length;
            }
            if (i == arrA.length)
                return true;
        }
        return false;
    }

    @Test
    public void solution() {
        int[] arrA = {4, 3, 4, 1};
        int[] arrB = {4, 1, 4, 3};
        boolean solution = solution(arrA, arrB);
        System.out.println(solution);
    }

}



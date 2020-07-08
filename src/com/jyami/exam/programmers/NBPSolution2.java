package com.jyami.exam.programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Created by jyami on 2020/07/01
 */
public class NBPSolution2 {

    public int solution(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> duplication = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]))
                duplication.add(i - map.get(arr[i]));
            map.put(arr[i], i);
        }
        if (duplication.isEmpty())
            return -1;
        return Collections.min(duplication);
    }

    @Test
    void solutionTest() {
        int[] arr = {2, 1, 3, 1, 4, 1, 1, 3};
//        int[] arr = {1, 2, 3};
        int solution = solution(arr);
        System.out.println(solution);
    }
}

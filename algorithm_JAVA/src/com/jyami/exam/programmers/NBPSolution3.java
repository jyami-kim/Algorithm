package com.jyami.exam.programmers;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;

/**
 * Created by jyami on 2020/07/01
 */
public class NBPSolution3 {
    public int solution(int[] p) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < p.length; i++) {
            if (!map.containsKey(p[i])) {
                map.put(p[i], 1);
            } else {
                map.put(p[i], map.get(p[i]) + 1);
            }
        }

        Integer max = Collections.max(map.values());
        Integer sum = map.values().stream()
                .reduce(0, Integer::sum);

        return sum - max;
    }

    @Test
    void solutionTest() {
        int[] arr = {103,101,103,103,101,102,100,100,101,104};
        System.out.println(solution(arr));
    }
}

package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jyami on 2020/07/28
 */
public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            if (!map.containsKey(c))
                map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }

        Integer mapMax = map.values().stream()
                .max(Integer::compare).orElse(0);

        int count = (int) map.values().stream()
                .filter(x -> x.equals(mapMax))
                .count() - 1;

        int max = (mapMax * (n + 1)) - n + count;

        return Math.max(tasks.length, max);
    }

    @Test
    void leastIntervalTest(){
        char[] tasks = {'a','a','a','b','b','b'};
//        char[] tasks = {'a','a','a','a','a','a','b','c','d','e','f','g'};
        System.out.println(leastInterval(tasks, 1));
    }
}

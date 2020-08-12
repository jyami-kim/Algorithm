package com.jyami.leetCode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jyami on 2020/08/12
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        int[] prev = new int[rowIndex + 1];
        prev[0] = 1;
        for (int i = 1; i < prev.length; i++) {
            int[] next = new int[rowIndex + 1];
            next[0] = 1;
            int j;
            for (j = 1; j < i; j++) {
                next[j] = prev[j - 1] + prev[j];
            }
            next[j] = 1;
            prev = next;
        }
        return Arrays.stream(prev).boxed()
                .collect(Collectors.toList());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void getRowTest(int i) {
        System.out.println(getRow(i));
    }
}

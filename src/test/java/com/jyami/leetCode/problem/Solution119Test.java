package com.jyami.leetCode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution119Test {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void getRowTest(int i) {
        System.out.println(new Solution119().getRow(i));
    }

}

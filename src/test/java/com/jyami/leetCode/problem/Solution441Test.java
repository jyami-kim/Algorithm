package com.jyami.leetCode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution441Test {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 5, 8})
    void arrangeCoinsTest(int i) {
        System.out.println(new Solution441().arrangeCoins(i));
    }

}

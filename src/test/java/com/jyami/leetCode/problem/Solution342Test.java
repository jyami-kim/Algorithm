package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution342Test {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 4, 5, 16})
    void isPowerOfFourTest(int num) {
        System.out.println(new Solution342().isPowerOfFour(num) + " : " + num);
    }

    @Test
    void test() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " : " + Integer.bitCount(i));
        }
    }

}

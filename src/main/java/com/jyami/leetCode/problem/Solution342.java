package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Created by jyami on 2020/08/04
 */
public class Solution342 {
    public boolean isPowerOfFour(int num) {
        return Integer.bitCount(num) == 1 && Integer.bitCount(num - 1) % 2 == 0;
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 4, 5, 16})
    void isPowerOfFourTest(int num) {
        System.out.println(isPowerOfFour(num) + " : " + num);
    }

    @Test
    void test() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " : " + Integer.bitCount(i));
        }
    }
}

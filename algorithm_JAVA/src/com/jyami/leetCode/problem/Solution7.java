package com.jyami.leetCode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Created by jyami on 2020/06/17
 */
public class Solution7 {
    public int reverse(int x) {

        long result = x % 10;
        x = x / 10;

        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }

        return result < Integer.MIN_VALUE || result > Integer.MAX_VALUE ? 0 : (int)result;
    }

    @ParameterizedTest
    @ValueSource(ints = {1534236469, 123, -123, 120})
    public void reverseTest(int val) {
        System.out.println(reverse(val));
    }

}

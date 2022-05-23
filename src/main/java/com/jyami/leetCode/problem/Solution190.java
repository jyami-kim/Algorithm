package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/07/13
 */
public class Solution190 {
    public int reverseBits(int n) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            if (n != 0) {
                result += n % 2;
                n = n >>> 1;
            }
        }
        return result;
    }

    @Test
    void reverseBitsTest() {
        int i = reverseBits(43261596);
        System.out.println(i);
    }
}

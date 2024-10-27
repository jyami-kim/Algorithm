package com.jyami.leetCode.problem;


/**
 * Created by jyami on 2020/08/04
 */
public class Solution342 {
    public boolean isPowerOfFour(int num) {
        return Integer.bitCount(num) == 1 && Integer.bitCount(num - 1) % 2 == 0;
    }
}

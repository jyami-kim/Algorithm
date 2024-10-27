package com.jyami.leetCode.problem;


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


}

package com.jyami.leetCode.problem;

/**
 * Created by jyami on 2020/08/10
 */
public class Solution171 {

    public static final int NUMBER = 64;

    public int titleToNumber(String s) {
        int sum = 0;
        int length = s.length() - 1;
        for (int i = 0; i <= length; i++) {
            int digit = length - i;
            sum += (s.charAt(i) - NUMBER) * Math.pow(26, digit);
        }
        return sum;
    }
}

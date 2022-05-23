package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Created by jyami on 2020/06/27
 */
public class Solution12 {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < nums.length; i++) {
            while(num >= nums[i]){
                num -= nums[i];
                sb.append(symbol[i]);
            }
        }
        return sb.toString();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 3999})
    void intToRomanTest(int i) {
        String s = intToRoman(i);
        System.out.println(s);
    }
}

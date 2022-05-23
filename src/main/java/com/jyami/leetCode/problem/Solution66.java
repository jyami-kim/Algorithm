package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created by jyami on 2020/07/06
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int index = digits.length - 1;
        while (carry != 0 && index >= 0) {
            int result = digits[index] + carry;
            digits[index--] = result % 10;
            carry = result / 10;
        }
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, result.length - 1);
            return result;
        }
        return digits;
    }

    @Test
    void plusOneTest() {
        int[] input = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(input)));
    }
}

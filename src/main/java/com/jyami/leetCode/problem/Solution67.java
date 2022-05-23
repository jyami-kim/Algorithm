package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/07/20
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;

        while (indexA >= 0 && indexB >= 0) {
            int result = carry + (a.charAt(indexA) - '0') + b.charAt(indexB) - '0';
            carry = result / 2;
            sb.insert(0, result % 2);
            indexA--;
            indexB--;
        }
        while (indexA >= 0) {
            int result = carry + (a.charAt(indexA) - '0');
            carry = result / 2;
            sb.insert(0, result % 2);
            indexA--;
        }
        while (indexB >= 0) {
            int result = carry + (b.charAt(indexB) - '0');
            carry = result / 2;
            sb.insert(0, result % 2);
            indexB--;
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }

    @Test
    void addBinaryTest() {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }
}

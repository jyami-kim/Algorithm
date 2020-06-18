package com.jyami.leetCode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Created by jyami on 2020/06/17
 */
public class Solution11 {

    public int romanToInt(String s) {
        int result = 0;
        int i = 0;
        for (; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            int anInt = getInt(c);
            char nextChar = s.charAt(i + 1);
            if (checkMinus(c, nextChar)) {
                result = result + getInt(nextChar) - anInt;
                i++;
            }else{
                result = result + anInt;
            }
        }
        if(i != s.length()){
            int anInt = getInt(s.charAt(s.length() - 1));
            return result + anInt;
        }
        return result;
    }

    public static boolean checkMinus(char c, char next) {
        if (c == 'I' && (next == 'V' || next == 'X')
                || c == 'X' && (next == 'L' || next == 'C')
                || c == 'C' && (next == 'D' || next == 'M')) {
            return true;
        }
        return false;
    }

    public int getInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    @ParameterizedTest
    @ValueSource(strings = {"III", "IV", "IX", "LVIII", "MCMXCIV"})
    void romanToIntTest(String value) {
        System.out.println(romanToInt(value));
    }
}

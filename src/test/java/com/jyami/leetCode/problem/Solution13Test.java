package com.jyami.leetCode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
class Solution13Test {

    @ParameterizedTest
    @ValueSource(strings = {"III", "IV", "IX", "LVIII", "MCMXCIV"})
    void romanToIntTest(String value) {
        int result = new Solution13().romanToInt(value);
        System.out.println(result);
    }

}

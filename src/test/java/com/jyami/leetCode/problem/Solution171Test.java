package com.jyami.leetCode.problem;

import static org.junit.jupiter.api.Assertions.*;

class Solution171Test {

    @ParameterizedTest
    @ValueSource(strings = {"A", "AB", "ZY", "ABC"})
    void titleToNumberTest(String str) {
        int i = titleToNumber(str);
        System.out.println(i);
    }

}

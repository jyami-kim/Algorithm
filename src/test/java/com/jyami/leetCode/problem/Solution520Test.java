package com.jyami.leetCode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution520Test {

    @ParameterizedTest
    @ValueSource(strings = {"A","Ba","bA","GloBal", "USA", "letter"})
    void detectCapitalUseTest(String str) {
        boolean b = new Solution520().detectCapitalUse(str);
        System.out.println(b);
    }

}

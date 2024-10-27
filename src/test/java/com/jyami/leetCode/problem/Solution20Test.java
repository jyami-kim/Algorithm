package com.jyami.leetCode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution20Test {

    @ParameterizedTest
    @ValueSource(strings = {"]","()","{}[]()","([)]", "{[]}"})
    void isValidTest(String strings){
        System.out.println(new Solution20().isValid(strings));
    }

}

package com.jyami.leetCode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution409Test {

    @ParameterizedTest
    @ValueSource(strings = {"abccccdd", "aaaccccddd"})
    void longestPalindromeTest(String str) {
        System.out.println(new Solution409().longestPalindrome(str));
    }

}

package com.jyami.leetCode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Created by jyami on 2020/06/17
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        String input = String.valueOf(x);
        int len = input.length();
        for(int i = 0; i< len/2; i++){
            if(input.charAt(i) != input.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }

    @ParameterizedTest
    @ValueSource(ints = {121, -121, 10})
    void isPalindromeTest(int val) {
        System.out.println(isPalindrome(val));
    }
}

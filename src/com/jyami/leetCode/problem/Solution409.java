package com.jyami.leetCode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;

/**
 * Created by jyami on 2020/08/14
 */
public class Solution409 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int single = 0;
        for (char c : s.toCharArray()) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }
        for (int num : hashMap.values()) {
            if (num % 2 == 1) {
                single++;
            }
        }
        return single > 1 ? s.length() - single + 1 : s.length();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abccccdd", "aaaccccddd"})
    void longestPalindromeTest(String str) {
        System.out.println(longestPalindrome(str));
    }
}

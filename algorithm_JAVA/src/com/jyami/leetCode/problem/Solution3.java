package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jyami on 2020/06/16
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int result = 1;
        byte[] bytes = s.getBytes();
        for (int i = 2; i <= s.length(); i++) {
            if (calculate(i, bytes)) {
                result = i;
            }
        }
        return result;
    }

    public boolean calculate(int window, byte[] bytes) {
        int len = bytes.length;
        Set<Byte> set = new HashSet<>();
        for (int i = 0; i < len - window; i++) {
            set.clear();
            for (int j = i; j < i + window; j++) {
                if (!set.contains(bytes[j])) {
                    set.add(bytes[j]);
                    if (j == i + window - 1) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }

    @Test
    void lengthOfLongestSubstringTest() {
        int abcabc = lengthOfLongestSubstring("pwwkew");
        System.out.println(abcabc);

    }
}

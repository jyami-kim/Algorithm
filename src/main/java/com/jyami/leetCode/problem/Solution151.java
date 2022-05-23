package com.jyami.leetCode.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Created by jyami on 2020/07/16
 */
public class Solution151 {
    public String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i > 0; i--) {
            if(!strings[i].isEmpty()){
                sb.append(strings[i]).append(" ");
            }
        }
        sb.append(strings[0]);
        return sb.toString();
    }


    @ParameterizedTest
    @ValueSource(strings = {"", "the sky is blue", "  hello world!  ", "a good   example"})
    void reverseWordsTest(String string) {
        String s = reverseWords(string);
        System.out.println(s);
    }
}

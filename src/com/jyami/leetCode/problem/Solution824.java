package com.jyami.leetCode.problem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jyami on 2020/08/19
 */
public class Solution824 {

    List<Character> letter = Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');

    public String toGoatLatin(String S) {
        String[] sentence = S.split(" ");
        for (int i = 0; i < sentence.length; i++) {
            char first = sentence[i].charAt(0);
            if (!letter.contains(first)) {
                sentence[i] = sentence[i].substring(1) + first;
            }
            sentence[i] = sentence[i] + iterateStringA(i + 1);
        }
        return Arrays.stream(sentence).collect(Collectors.joining(" "));
    }

    private String iterateStringA(int iterateNum) {
        StringBuilder sb = new StringBuilder();
        sb.append("ma");
        for (int i = 0; i < iterateNum; i++) {
            sb.append("a");
        }
        return sb.toString();
    }


}

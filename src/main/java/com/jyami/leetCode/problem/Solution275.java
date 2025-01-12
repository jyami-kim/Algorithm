package com.jyami.leetCode.problem;

import java.util.Arrays;

/**
 * Created by jyami on 2020/06/18
 */
public class Solution275 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        // N-h <= h
        // h번 인용한게 h개 이상 있다
        int h = 0;
        int len = citations.length;
        for(int i =0; i<len; i++){
            int num = i+1;
            int citation = citations[len - i -1];
            if(num <= citation){
                h = num;
            }
        }
        return h;

    }
}

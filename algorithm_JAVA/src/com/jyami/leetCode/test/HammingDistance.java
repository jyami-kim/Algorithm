package com.jyami.leetCode.test;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/06/28
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int hamming = 0;
        while (x != 0 && y != 0) {
            if (y % 2 != x % 2) {
                hamming++;
            }
            x = x / 2;
            y = y / 2;
        }
        while (x != 0) {
            if(x % 2 == 1)
                hamming++;
            x = x / 2;
        }
        while (y != 0) {
            if(y % 2 == 1)
                hamming++;
            y = y / 2;
        }
        return hamming;
    }

    @Test
    void hammingDistanceTest(){
        int i = hammingDistance(1, 4);
        System.out.println(i);
    }
}

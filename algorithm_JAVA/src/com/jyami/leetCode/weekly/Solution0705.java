package com.jyami.leetCode.weekly;

/**
 * Created by jyami on 2020/07/05
 */
public class Solution0705 {
    public int hammingDistance(int x, int y) {
        int hamming = 0;
        while (x != 0 && y != 0) {
            if (x % 2 != y % 2)
                hamming++;
            y = y / 2;
            x = x / 2;
        }
        while (x != 0) {
            if (x % 2 == 1)
                hamming++;
            x = x / 2;
        }
        while (y != 0) {
            if (y % 2 == 1)
                hamming++;
            y = y / 2;
        }
        return hamming;
    }
}

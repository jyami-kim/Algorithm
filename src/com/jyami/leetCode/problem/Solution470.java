package com.jyami.leetCode.problem;

import java.util.Random;

/**
 * Created by jyami on 2020/08/28
 */
public class Solution470 {

    public int rand10() {
        int row, col, index;
        do {
            row = rand7();
            col = rand7();
            index = (row - 1) * 7 + col - 1;
        } while (index >= 40);
        return 1 + index % 10;
    }

    private int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }
}

package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/06/26
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                int s = (i - j) * Math.min(height[i], height[j]);
                if (s > max) {
                    max = s;
                }
            }
        }
        return max;
    }

    @Test
    void maxAreaTest() {
        int[] height = {1,2};
        int i = maxArea(height);
        System.out.println(i);
    }
}

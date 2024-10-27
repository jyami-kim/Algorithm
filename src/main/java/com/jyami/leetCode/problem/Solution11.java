package com.jyami.leetCode.problem;

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

}

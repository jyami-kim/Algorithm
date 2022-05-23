package com.jyami.leetCode.problem;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by jyami on 2020/08/22
 */
public class Solution497 {
    int[][] rects;
    int[] range;
    int totalArea = 0; // uniformly 하게 배치하기 위해서 area에 따른 random 가중치를 부여함.
    Random r = new Random();

    public Solution497() {
    }

    public Solution497(int[][] rects) {
        this.rects = rects;
        range = new int[rects.length];
        for (int i = 0; i < rects.length; i++) {
            int area = Math.abs((rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1));
            totalArea += area;
            range[i] = totalArea;
        }
    }

    public int[] pick() {
        int area = r.nextInt(totalArea + 1);

        int index = 0;
        while (index < range.length && range[index] < area) {
            index++;
        }
        int[] rect = rects[index];

        int x = r.nextInt(rect[2] - rect[0] + 1) + rect[0];
        int y = r.nextInt(rect[3] - rect[1] + 1) + rect[1];
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        int[][] rects = {{1, 1, 5, 5}};
        Solution497 solution497 = new Solution497(rects);
        System.out.println(Arrays.toString(solution497.pick()));
    }

}

package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/07/08
 */
public class Solution463 {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                sum++;
            }
            for (int j = 0; j < grid[0].length - 1; j++) {
                if (grid[i][j] + grid[i][j + 1] == 1) {
                    sum++;
                }
            }
            if (grid[i][grid[0].length - 1] == 1) {
                sum++;
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                sum++;
            }
            for (int j = 0; j < grid.length - 1; j++) {
                if (grid[j][i] + grid[j + 1][i] == 1) {
                    sum++;
                }
            }
            if (grid[grid.length - 1][i] == 1) {
                sum++;
            }
        }
        return sum;
    }

    @Test
    void islandPerimeterTest() {
//        int[][] arr = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int[][] arr = {{1,0}};
        int i = islandPerimeter(arr);
        System.out.println(i);

    }
}

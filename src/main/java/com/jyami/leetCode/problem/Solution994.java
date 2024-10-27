package com.jyami.leetCode.problem;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jyami on 2020/08/10
 */
public class Solution994 {
    public int orangesRotting(int[][] grid) {

        int num = 0;
        int row = grid.length;
        int column = grid[0].length;

        if (isClear(grid)){
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            boolean isAvail = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                if ((x != 0) && (grid[x - 1][y] == 1)) { // up
                    grid[x - 1][y] = 2;
                    queue.add(new int[]{x - 1, y});
                    isAvail = true;
                }
                if (((x != row - 1) && (grid[x + 1][y] == 1))) {
                    grid[x + 1][y] = 2;
                    queue.add(new int[]{x + 1, y});
                    isAvail = true;
                } // down
                if ((y != 0) && (grid[x][y - 1] == 1)) {
                    grid[x][y - 1] = 2;
                    queue.add(new int[]{x, y - 1});
                    isAvail = true;
                } // left
                if ((y != column - 1) && (grid[x][y + 1] == 1)) {
                    grid[x][y + 1] = 2;
                    queue.add(new int[]{x, y + 1});
                    isAvail = true;
                } // right
            }
            if(isAvail){
                num++;
            }
        }

        if (isClear(grid))
            return num;
        return -1;
    }

    private boolean isClear(int[][] grid) {
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
//        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
//        int[][] grid = {{0,2}};
//        int[][] grid = {{1},{2},{1},{2}};
        System.out.println(new Solution994().orangesRotting(grid));
    }
}

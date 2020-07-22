package com.jyami.leetCode.notSolved;

/**
 * Created by jyami on 2020/07/22
 */
public class Solution79 {

    public boolean exist(char[][] board, String word) { // 4 x 2
        int i = 0, j = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    break;
                }
            }
        }
        visited[i][j] = true;
        dfs(visited, word, board, i, j, 0);
        return true;
    }

    public void dfs(boolean[][] visited, String word, char[][] board, int i, int j, int length) {
        if (length == word.length()) {
            return;
        }
        visited[i + 1][j] = true;
//        dfs(visited, word, board,);

        visited[i][j] = false;
        if (board[i][j] == word.charAt(++length)) {

        }
    }
}

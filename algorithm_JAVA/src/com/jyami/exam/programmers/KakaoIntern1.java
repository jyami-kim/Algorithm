package com.jyami.exam.programmers;

import java.util.Stack;

public class KakaoIntern1 {
    public static void main(String args[]) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        Solution solution = new Solution();
        int solution1 = solution.solution(board, moves);
        System.out.println(solution1);
    }

    static class Solution {

        static int amount = 0;
        static Stack<Integer> stack = new Stack<>();

        public int solution(int[][] board, int[] moves) {
            stack.add(-1);
            int size = board[0].length;
            for (int move : moves) {
                getDoll(board, move - 1, size);
            }
            return amount;
        }

        private void stackPopCheck(int beforeDoll) {
            Integer peek = stack.peek();
            if (peek == beforeDoll) {
                stack.pop();
                stack.pop();
                amount += 2;
            }
        }

        private void getDoll(int[][] board, int move, int size) {
            for (int i = 0; i < size; i++) {
                int tong = board[i][move];
                if (tong != 0) {
                    Integer beforeDoll = stack.peek();
                    board[i][move] = 0;
                    stack.add(tong);
                    stackPopCheck(beforeDoll);
                    break;
                }
            }
        }


    }
}

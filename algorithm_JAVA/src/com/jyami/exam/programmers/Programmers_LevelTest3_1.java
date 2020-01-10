package com.jyami.exam.programmers;

public class Programmers_LevelTest3_1 {
    public static void main(String args[]) {
        long solution = new Solution().solution(6);
        System.out.println(solution);
    }

    static class Solution {

        public static long[] arr;

        public long solution(int n) {
            if (n == 1) {
                return 4;
            } else if (n == 2) {
                return 6;
            } else {
                arr = new long[n];
                arr[0] = 1;
                arr[1] = 1;
                for (int i = 2; i < n; i++) {
                    arr[i] = arr[i - 1] + arr[i - 2];
                }
                long width = (arr[n - 1] + arr[n - 2]);
                long height = arr[n - 2] + arr[n - 3];
                return 2 * (width + height);
            }
        }
    }
}

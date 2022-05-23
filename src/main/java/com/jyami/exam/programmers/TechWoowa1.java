package com.jyami.exam.programmers;

public class TechWoowa1 {

    public static void main(String args[]) {
        int restaurant[] = {0, 0};
        int riders[][] = {{-700, 0}, {150, 180}, {500, 500}, {150, -800}, {800, 800}, {-900, 500}, {-1100, 900}};
        int k = 1000;

        Solution solution = new Solution();
        int solution1 = solution.solution(restaurant, riders, k);
        System.out.println(solution1);
    }

    static class Solution {
        public int solution(int[] restaurant, int[][] riders, int k) {
            int count = 0;
            for (int[] vector : riders) {
                if (isCircleIn(restaurant, vector, k))
                    count++;
            }
            return count;
        }

        private boolean isCircleIn(int[] restaurant, int[] vector, int k) {
            double calc = (Math.pow((restaurant[0] - vector[0]), 2) + Math.pow((restaurant[1] - vector[1]), 2));
            double bound = Math.pow(k, 2);
            return calc < bound;
        }
    }
}

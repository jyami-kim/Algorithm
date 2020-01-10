package com.jyami.exam.programmers;

public class HackDay2019Winter1 {
    public static void main(String args[]) {
//        int[] input = {2, 1, 3};
//        int[] input = {1, 2, 3};
//        int[] input = {3, 2, 3, 6, 4, 5};
        int[] input = {3, 2, 1};

        int solution = new Solution().solution(input);
        System.out.println(solution);
    }

    static class Solution {
        public int solution(int grade[]) {

            int result = 0;

            for (int i = grade.length - 2; i >= 0; i--) {
                if (grade[i + 1] < grade[i]) {
                    result += grade[i] - grade[i + 1];
                    grade[i] = grade[i + 1];

                }
            }
//            for (int i = 1; i < grade.length; i++) {
//                if (grade[i - 1] > grade[i]) {
//                    result += grade[i - 1] - grade[i];
//                }
//            }

            return result;
        }
    }
}

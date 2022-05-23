package com.jyami.exam.programmers;

public class Programmers_LevelTest1_2 {
    public static void main(String args[]) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        Solution solution = new Solution();
        int solution1 = solution.solution(n, lost, reserve);
        System.out.println(solution1);

    }


    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;

            int[] result = new int[n + 1];

            for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) {
                    if(lost[i] == reserve[j]){
                        lost[i] = -1;
                        reserve[j] = -1;
                    }
                }
            }

            for (int i = 0; i < lost.length; i++) {
                if(lost[i] == -1){
                    continue;
                }
                result[lost[i]] = 1;
                answer++;
            }

            for (int i = 0; i < reserve.length; i++) {
                int index = reserve[i];
                if(index == -1){
                    continue;
                }
                if (index != 0 && result[index - 1] == 1) {
                    result[index - 1] = 0;
                    answer--;
                    continue;
                } else if (index != n && result[index + 1] == 1) {
                    result[index + 1] = 0;
                    answer--;
                    continue;
                }
            }

            return n - answer;
        }
    }

}

package com.jyami.programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by jyami on 2020/01/06
 * K번째 수
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class KthNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] solution1 = solution.solution(array, commands);
        System.out.println(Arrays.toString(solution1));
    }

    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            int i = 0;

            /*
                copyOfRange(array, start, end) : start-inclusive, end-exclusive
                {2,5,3} 일 때,
                2번째는 index 1을 의미하므로 -- 해주기
                5번째는 index 5를 포함하지 않으므로 그대로
                3번째 수는 inedx 2를 의미하므로 -- 해주기
             */

            for(int[] com : commands){
                int[] result = Arrays.copyOfRange(array, --com[0], com[1]);
                Arrays.sort(result);
                answer[i++] = result[--com[2]];
            }

            return answer;
        }
    }


}

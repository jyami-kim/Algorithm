package com.jyami.programmers.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jyami on 2020/01/07
 * H-index
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class Hindex {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] citations = {3,0,6,1,5};
//        int[] citations = {10,8,4,5,3};
        int[] citations = {25,8,5,1,1};
        int solution1 = solution.solution(citations);
        System.out.println(solution1);
    }

    static class Solution {
        public int solution(int[] citations) {
            List<Integer> list = Arrays.stream(citations)
                    .boxed()
                    .sorted()
                    .collect(Collectors.toList());

            int m = citations.length;
            int h = 0;
            for(int i = 0; i<citations.length; i++){
                int k = list.get(i);
                // cond1 : h 번 이상 인용된 논문이 h 편 이상이고 length-i (h포함 상위 논문 개수)
                // cond2 : 나머지 논문이 h편 이하 인용 i(인덱스 = h 제외 하위 논문 개수)
                if(citations.length - i >= k && k >= i){
                    h = k;
                }
                //만약 인용 논문의 개수가 엄청 많다면? length 기준으로 하나씩 빼줘야함
                // ex ) 테스트 케이스 [43,42] = 2
                if(m>k){
                    m--;
                }
            }

            return Math.max(h, m);
        }
    }
}

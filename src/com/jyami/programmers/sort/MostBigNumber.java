package com.jyami.programmers.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jyami on 2020/01/06
 * 가장 큰 수
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */
public class MostBigNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] ar = {40,403};

        String sol = solution.solution(ar);
        System.out.println(sol);

        int[][] array = {{1,2,3},
                {6,10,2},
                {3, 30, 34, 5, 9},
                {998,9,999},
                {20,200,20},
                {12,121},
                {0,0,0},
                {10,100,1000}};

        for(int[] arr : array){
            String solution1 = solution.solution(arr);
            System.out.println(solution1);
        }

    }

    static class Solution {
        public String solution(int[] numbers) {
            StringBuilder sb = new StringBuilder();
            List<String> collect = Arrays.stream(numbers)
                    .mapToObj(String::valueOf)
                    .sorted(new BigComparator())
                    .collect(Collectors.toList());

            if(collect.get(0).startsWith("0")){
                return "0";
            }
            for(String i : collect){
                sb.append(i);
            }
            return sb.toString();
        }


        class BigComparator implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                String l1 = o1 + o2;
                String l2 = o2 + o1;
                return l2.compareTo(l1);
            }
        }
    }
}

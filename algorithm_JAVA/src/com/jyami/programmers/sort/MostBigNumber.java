package com.jyami.programmers.sort;

import com.sun.tools.corba.se.idl.toJavaPortable.InterfaceGen;

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
                {20,200,20}, //이
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
            List<Integer> collect = Arrays.stream(numbers)
                    .mapToObj(x -> {
                        return Integer.toString(x).chars().map(c -> c - '0').toArray();
                    }).sorted(new BigComparator())
                    .map(this::makeInt)
                    .collect(Collectors.toList());
            if(collect.get(0) == 0){
                return "0";
            }
            for(int i : collect){
                sb.append(i);
            }
            return sb.toString();
        }

        public int makeInt(int[] arr){
            int result = 0;
            for(int i : arr){
                result = result*10 + i;
            }
            return result;
        }

        class BigComparator implements Comparator<int[]> {
            @Override
            public int compare(int[] o1, int[] o2) {
                int i1 = 0;
                int i2 = 0;
                while(true){
                    int l1 = o1.length - i1;
                    int l2 = o2.length - i2;
                    if(l1 > 0 && l2 > 0){
                        if(o1[i1] > o2[i2]){
                            return -1;
                        }else if(o1[i1] < o2[i2]) {
                            return 1;
                        }else{
                            i1++;
                            i2++;
                        }
                    }else if(l1 < l2){ // 1번이 더 짧을 때
                        if(o1[i1-1] > o2[i2]){ // 2번의 다음자리 수가 더 작음
                            return -1;
                        }else if(o1[i1-1] < o2[i2]){ // 2번의 다음자리수가 더
                            return 1;
                        }else{
                            i2++;
                        }
                    }else if(l2 < l1){ // 2번이 더 짧을 때
                        if(o2[i2-1] > o1[i1]){
                            return 1; // 2가 앞에니까 1은 -1
                        }else if(o2[i2-1] < o1[i1]){
                            return -1;
                        }else{
                            i1++;
                        }
                    }else{
                        return Integer.compare(o1.length, o2.length);
                    }
                }
            }
        }
    }
}

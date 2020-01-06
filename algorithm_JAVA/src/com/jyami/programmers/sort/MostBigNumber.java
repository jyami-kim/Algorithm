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
        int[] array = {6, 10, 2};
        int[] array2 = {3, 30, 34, 5, 9};
        int[] array3 = {998,9,999};

        String solution1 = solution.solution(array2);
        System.out.println(solution1);
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
                    if(o1[i1] > o2[i2]){
                        return -1;
                    }else if(o1[i1] < o2[i2]){
                        return 1;
                    }else{
                        if(i1 < o1.length && i2 < o2.length){
                            i1++;
                            i2++;
                        }else if(i1 >= o1.length){ // 1번이 더 짧을 때
                            if(o1[i1-1] > o2[i2+1]){ // 2번의 다음자리 수가 더 작음
                                return 1;
                            }else if(o1[i1-1] > o2[i2+1]){ // 2번의 다음자리수가 더
                                return -1;
                            }else{
                                i2++;
                            }
                        }else if(i2 >= o2.length){ // 2번이 더 짧을 때
                            if(o2[i2-1] > o1[i1+1]){
                                return 1;
                            }else if(o2[i2-1] > o1[i1+1]){
                                return -1;
                            }else{
                                i1++;
                            }
                        }else{
                            return 0;
                        }
                    }
                }
            }
        }
    }
}

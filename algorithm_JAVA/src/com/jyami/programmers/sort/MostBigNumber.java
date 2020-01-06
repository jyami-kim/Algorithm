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

        String solution1 = solution.solution(array3);
        System.out.println(solution1);
    }

    static class Solution {
        public String solution(int[] numbers) {
            StringBuilder sb = new StringBuilder();

            List<Integer> list = Arrays.stream(numbers)
                    .boxed()
                    .collect(Collectors.toList());

            list.sort(new BigComparator());
            for(int i : list){
                sb.append(i);
            }
            return sb.toString();
        }

        class BigComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer i1, Integer i2){
                int num1 = i1;
                int num2 = i2;
                while(true){
                    int l1 = num1 < 10 ? num1 : num1/10;
                    int l2 = num2 < 10? num2 : num2/10;
                    //주의 reverseSort를 해야함
                    if(l1 > l2){
                        return -1;
                    }else if(l1 < l2){
                        return 1;
                    }else{
                        int b1 = num1%10;
                        int b2 = num2%10;
                        if(num1 < 10){ // 1자리 수일 경우

                            return Integer.compare(num1, b2);
                        }
                        if(num2 < 10){ // 1자리 수일 경
                            return Integer.compare(num2, b1);
                        }
                        num1 = num1%10;
                        num2 = num2%10;
                    }
                }
            }


        }
    }
}

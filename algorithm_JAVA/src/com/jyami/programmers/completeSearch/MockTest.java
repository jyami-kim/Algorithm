package com.jyami.programmers.completeSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jyami on 2020/01/07
 * 모의고사
 * https://programmers.co.kr/learn/courses/30/lessons/42840#
 */
public class MockTest {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5,1,2,3,4,5};
        int[] answers2 = {5};
        int[] solution = new Solution().solution(answers);
        System.out.println(Arrays.toString(solution));
    }

    static class Solution {
        public int[] solution(int[] answers) {
            int[] p1 = {1,2,3,4,5};
            int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            int c1 =0, c2 =0, c3 =0;
            for(int i = 0; i<answers.length; i++ ){
                if(answers[i] == p1[i%5]) c1++;
                if(answers[i] == p2[i%8]) c2++;
                if(answers[i] == p3[i%10]) c3++;
            }
            int max = Math.max(Math.max(c1, c2), c3);
            List<Integer> list = new ArrayList<>();
            if(c1 == max) list.add(1);
            if(c2 == max) list.add(2);
            if(c3 == max) list.add(3);


            int[] a = new int[list.size()];
            for(int i =0; i<a.length;i++){
                a[i] = list.get(i);
            }
            return a;
        }
    }
}

package com.jyami.programmers.hash;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * Created by jyami on 2020/01/05
 * 위장
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */

public class Camouflage {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int solution1 = solution.solution(clothes);
        System.out.println(solution1);
    }

    static class Solution {

        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String, Integer> map = new HashMap();
            for(String[] cloth : clothes){
                int count = map.getOrDefault(cloth[1], 0);
                map.put(cloth[1], ++count);
            }

            List<Integer> values =  new ArrayList<>(map.values());
            for(int value : map.values()){
                answer *= (value+1);
            }

            return answer-1;
        }

        // 팁 순서가 있는 순열과 마찬가지 이기 때문에 가능하다.
        // 상의 : A가지 // 하의 : B가지 // 모자 : C가지
        // (A+1)(B+1)(C+1)-1
        // +1을 하는 이유는 벗는 경우가 있기 때문이다. -1을 하는 이유는 아무것도 안입으면 안되기 때문이다.

    }
}

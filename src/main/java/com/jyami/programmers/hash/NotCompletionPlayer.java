package com.jyami.programmers.hash;

import java.util.*;

/**
 * 해시 - 완주하지 못한 선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */


public class NotCompletionPlayer {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] participant = {"a","b","c", "a"};
        String[] completion = {"a","c", "a"};
        solution.solution(participant, completion);
        System.out.println();
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            HashMap<String,Integer> map = new HashMap();

            for(String part : participant){
                Integer num = map.getOrDefault(part, 0);
                map.put(part, ++num);
            }

            for(String comp : completion){
                Integer num = map.get(comp);
                if(num == 1){
                    map.remove(comp);
                    continue;
                }
                map.put(comp, --num);
            }

            return map.keySet().iterator().next();
        }
    }
}

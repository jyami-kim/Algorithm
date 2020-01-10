package com.jyami.exam.codility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jyami on 2020/01/10
 */
public class Naver_Intern_Codility_2 {
    public static void main(String[] args) {
        String[] s = {
                "aaaaa aaaaa aaa a",
                "aaaaa a aaaaa a aaaaa",
                "a a a a",
                "aaa aaaaa aaa aaaaa aaaaaa a aaa aaaaaaaaaaaa",
                "aaa aaaaa aaa aaaaa aaaaaa a aaa",
                "aaa aaaaa aaa aaaaa aaaaaa a",
                "aaa aaaaa aaa aaaaa aaaaaa",
                "aaa aaaaa aaa aaaaa",
                "aaa aaaaa aaa",
        };
        int[] k= {
                5, 7, 1, 12,
                12, 12,12,12,12};
        for(int i =0; i<s.length; i++){
            System.out.println(new Solution().solution(s[i], k[i]));
        }
        //3 3 4 4 3 3 3 2 2
    }

    static class Solution {
        public int solution(String S, int K) {
            String[] s = S.split(" ");

            List<Integer> collect = Arrays.stream(s)
                    .map(String::length)
                    .collect(Collectors.toList());

            int sum = collect.get(0);
            int result =1;
            for(int i =1 ;i < collect.size(); i++){
                if(sum + collect.get(i) + 1 <= K){
                    sum = sum + collect.get(i) + 1;
                }else {
                    sum = collect.get(i);
                }
                if(sum == collect.get(i)){
                    result++;
                }
            }

            return result;
        }
    }
}

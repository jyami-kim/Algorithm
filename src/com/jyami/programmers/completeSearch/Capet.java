package com.jyami.programmers.completeSearch;

import java.util.Arrays;

/**
 * Created by jyami on 2020/01/22
 * 카펫
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 */
public class Capet {


    public static void main(String[] args) {
        int[] brown = {10, 8 , 24};
        int[] red = {2, 1, 24};
        for(int i =0; i< 3; i++){
            System.out.println(Arrays.toString(new Solution().solution(brown[i], red[i])));
        }
    }

    static class Solution {
        public int[] solution(int brown, int red) {
            int[] answer = new int[2];

            int halfBrown = brown/2;
            int a = 1;
            int b = halfBrown - 2 - a;
            while(a <= b){
                if(a*b == red){
                    answer[0] = b + 2;
                    answer[1] = a + 2;
                }
                a++;
                b = halfBrown - 2 - a;
            }
//             brown 이 n 이면? n/2 해두기
//             red의 개수는 a * b일 때
//             n/2 = (a + 1) + (b + 1)
//             12
//             2 10 / 3 9 / 4 8 / 5 7 /

            return answer;
        }
    }
}

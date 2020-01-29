package com.jyami.exam.codility;

/**
 * Created by jyami on 2020/01/29
 */
public class Naver_AI_HACK_3 {

    public static void main(String[] args) {
        int[] arr = {0,1,1,0};
        int solution = new Solution().solution(arr);
        System.out.println(solution);

    }

    static class Solution {
        public int solution(int[] A) {
            // write your code in Java SE 8
            int min=A.length;
            for(int i=0;i<2;i++) { // 2회 반복
                int num=0;
                for(int j=0;j<A.length;j++) {
                    if(A[j]!=(i+j)%2) num++;
                }
                if(min>num) min=num;
            }
            return min;
        }
    }
}

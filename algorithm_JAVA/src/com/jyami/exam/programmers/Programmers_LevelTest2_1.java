package com.jyami.exam.programmers;

public class Programmers_LevelTest2_1 {
    public static void main(String args[]) {
        int n = 6;
        int solution = new Solution().solution(n);
        System.out.println(solution);

    }

    static class Solution {

        public int solution(int n) {

            int result = 1;

            while(n != 1){
                if(n%2 == 0){
                    n = n/2;
                }else{
                    n = n-1;
                    result ++;
                }
            }

            return result;
        }
    }
}

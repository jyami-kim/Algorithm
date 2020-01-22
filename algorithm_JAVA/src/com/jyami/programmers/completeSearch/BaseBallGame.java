package com.jyami.programmers.completeSearch;

/**
 * Created by jyami on 2020/01/22
 * 숫자야구
 * https://programmers.co.kr/learn/courses/30/lessons/42841
 */
public class BaseBallGame {
    public static void main(String[] args) {
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        System.out.println(new Solution().solution(baseball));
    }

    static class Solution {
        public int solution(int[][] baseball) {
            // 1 부터 9 까지

            int count =0;
            for (int correct = 123; correct <= 987; correct++) {
                if(isPass(correct)){
                    continue;
                }
                boolean check = true;
                for (int[] ball : baseball) {
                    int[] ints = get(ball[0], correct);
                    if(ball[1] != ints[0] || ball[2] != ints[1]){
                        check =false;
                    }
                }
                if(check){
                    count++;
                }
            }
            return count;
        }

        public boolean isPass(int num){
            int a = num / 100; int b = num%100/10; int c = num%10;
            if(a == b || b==c || a == c || a == 0 || b== 0 || c==0){
                return true;
            }
            return false;
        }

        public int[] get(int collect, int question) {
            // 0 : strike // 1 : ball
            int[] col = new int[3];
            int[] que = new int[3];

            col[0] = collect / 100; col[1] = collect%100/10; col[2] = collect%10;
            que[0] = question / 100; que[1] = question%100/10; que[2] = question%10;

            int result[] = new int[2];
            int strNum = 0;
            int bolNum = 0;

            for(int k =0; k<3; k++){
                for(int j =0; j<3; j++){
                    if( col[k] == que[j]){
                        if(k == j){
                            strNum++;
                        }else{
                            bolNum++;
                        }
                    }
                }
            }

            result[0] = strNum;
            result[1] = bolNum;

            return result;
        }
    }
}

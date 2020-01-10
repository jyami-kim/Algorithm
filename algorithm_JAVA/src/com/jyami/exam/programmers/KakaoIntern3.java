package com.jyami.exam.programmers;

import java.util.Stack;

public class KakaoIntern3 {
    public static void main(String args[]) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        Solution solution = new Solution();
        int solution1 = solution.solution(user_id, banned_id);
        System.out.println(solution1);
    }

    static class Solution {
        public int solution(String[] user_id, String[] banned_id) {
            int answer = 0;
            for(String user : banned_id){

            }
            return answer;
        }

        private void checkDupleUser(String[] userId, String bann){

        }
    }


}

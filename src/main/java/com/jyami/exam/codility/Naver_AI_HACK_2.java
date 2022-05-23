package com.jyami.exam.codility;

/**
 * Created by jyami on 2020/01/29
 */
public class Naver_AI_HACK_2 {

    public static void main(String[] args) {
        String[] input ={"?ab??a", "bab??a", "?a?"};
        for(String str : input){
            String solution = new Solution().solution(str);
            System.out.println(solution);
        }
    }

    static class Solution {
        public String solution(String str) {
            char[] chars = str.toCharArray();
            int len = str.length();
            int s = 0;
            int f = len-1;

            while(s <= f){
                char a = chars[s];
                char b = chars[f];

                if(a != '?' && b != '?'){ // 둘다 문자일 때
                    if(a != b){
                        return "NO";
                    }
                }else if(a == '?' && b == '?'){ // 둘다 ? 일때
                    chars[s] = 'a';
                    chars[f] = 'a';
                }
                else{ // 하나만 ? 일 때
                    if(a == '?'){
                        chars[s] = chars[f];
                    }else{
                        chars[f] = chars[s];
                    }
                }
                s++;
                f--;
            }

            return String.valueOf(chars);
        }
    }

}

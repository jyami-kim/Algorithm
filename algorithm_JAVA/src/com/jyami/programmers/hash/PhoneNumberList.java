package com.jyami.programmers.hash;

/**
 * Created by jyami on 2020/01/05
 * 해시 - 전화번호 목록
 * https://programmers.co.kr/learn/courses/30/lessons/42577?language=java
 */
public class PhoneNumberList {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] phoneBook = {"119", "97674223", "1195524421"};
        solution.solution(phoneBook);
        System.out.println();
    }

    static class Solution {
        public boolean solution(String[] phoneBook) {
            for(int i =0; i<phoneBook.length; i++){
                for(int j =0; j<phoneBook.length; j++){
                    if(i == j) continue;
                    if(phoneBook[i].startsWith(phoneBook[j])){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

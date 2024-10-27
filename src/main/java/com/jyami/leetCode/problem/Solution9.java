package com.jyami.leetCode.problem;

/**
 * Created by jyami on 2020/06/17
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        String input = String.valueOf(x);
        int len = input.length();
        for(int i = 0; i< len/2; i++){
            if(input.charAt(i) != input.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }

}

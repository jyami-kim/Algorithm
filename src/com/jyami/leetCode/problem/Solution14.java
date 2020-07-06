package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/06/18
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        int minLength;
        if(strs.length == 0){
            minLength = 0;
        }else{
            minLength = strs[0].length();
        }
        for(String str : strs){
            if( str.length() < minLength ){
                minLength = str.length();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < minLength; i++){
            char c = strs[0].charAt(i);
            for(String str: strs){
                if(c != str.charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    @Test
    public void longestCommonPrefix(){
        String[] strs = {};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
}

package com.jyami.exam.codility;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by jyami on 2020/01/10
 */
public class Naver_Intern_Codility_3 {
    public static void main(String[] args) {
        String s = "cbcana";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public int solution(String S) {
            char[] chars = S.toCharArray();
            int prev = 0;
            int count =0;
            for(int i=1; i<chars.length; i++){
                if(chars[i-1] >chars[i]){
                    if(chars[prev]> chars[i]){
                        count++;
                    }
                    count++;
                    prev = i;
                }

            }
            return count;
        }
    }


    static class MyComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            String replace1 = o1.replace("-", "");
            String replace2 = o2.replace("-", "");
            return replace1.compareTo(replace2);
        }
    }
}

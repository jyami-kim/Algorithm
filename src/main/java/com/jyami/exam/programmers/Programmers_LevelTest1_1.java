package com.jyami.exam.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Programmers_LevelTest1_1 {

    public static void main(String args[]) {
        String [] strings = {"sun", "bed", "car"};
        int n = 1;
        Solution solution = new Solution();
        String[] solution1 = solution.solution(strings, n);
        for(String s: solution1){
            System.out.println(s);
        }
    }

    static class Solution {
        public String[] solution(String[] strings, int n) {

            Arrays.sort(strings, new CustomCompartor(n));

            return strings;
        }
    }

    static class CustomCompartor implements Comparator<String> {

        int index = 0;

        public CustomCompartor(int index) {
            this.index = index;
        }

        @Override
        public int compare(String o1, String o2) {
            return o1.charAt(index) > o2.charAt(index) ? 1 : o1.charAt(index) < o2.charAt(index) ? -1 :
                    o1.compareTo(o2);
        }
    }



}


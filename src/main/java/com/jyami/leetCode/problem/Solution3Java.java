package com.jyami.leetCode.problem;

public class Solution3Java {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int result = maxLength(s, i);
            max = Math.max(max, result);
        }
        return max;
    }

    private int maxLength(String s, int startIndex) {
        boolean[] charArray = new boolean[128];
        int index = startIndex;
        int count = 0;
        while(index < s.length()){
            char c = s.charAt(index++);
            if(charArray[c]){
                return count;
            }else{
                charArray[c] = true;
            }
            count++;
        }
        return count;
    }
}

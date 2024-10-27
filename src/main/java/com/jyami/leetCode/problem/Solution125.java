package com.jyami.leetCode.problem;


/**
 * Created by jyami on 2020/08/04
 */
public class Solution125 {

    public boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;

        while (low <= high && low < s.length() && high >= 0) {
            if(!Character.isLetterOrDigit(s.charAt(low))){
                low++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(high))) {
                high--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(high)) != Character.toLowerCase(s.charAt(low)))
                return false;
            low++;
            high--;
        }
        return true;
    }

}

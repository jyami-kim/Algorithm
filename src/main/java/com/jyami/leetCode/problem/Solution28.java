package com.jyami.leetCode.problem;

/**
 * Created by jyami on 2020/06/24
 */
public class Solution28 {

    static String input;
    static int needleLen;

    public int strStr(String haystack, String needle) {
        input = needle;
        needleLen = needle.length();
        byte[] bytes = haystack.getBytes();
        for (int i = 0; i <= haystack.length() - needleLen; i++) {
            if (checkIsSame(bytes, i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkIsSame(byte[] bytes, int start) {
        for(int i = 0; i<needleLen; i++){
            if(input.charAt(i) != bytes[start+i])
                return false;
        }
        return true;
    }

}

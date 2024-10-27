package com.jyami.leetCode.problem;

/**
 * Created by jyami on 2020/06/25
 */
public class Solution6 {
    public String convert(String s, int numRows) {

        if(numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i =0; i<numRows; i++){
            int index = i;
            while(index < len){
                if(i == 0 || i == numRows - 1){
                    sb.append(s.charAt(index));
                    index += 2*(numRows-1);
                }else{
                    sb.append((s.charAt(index)));
                    index += 2*(numRows-1-i);
                    if(index < len){
                        sb.append((s.charAt(index)));
                        index += 2*(i);
                    }
                }
            }
        }

        return sb.toString();
    }

}

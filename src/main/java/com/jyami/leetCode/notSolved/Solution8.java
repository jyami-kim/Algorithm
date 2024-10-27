package com.jyami.leetCode.notSolved;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jyami on 2020/06/25
 */
public class Solution8 {

    static Pattern pattern = Pattern.compile("(-?\\d+)");

    public int myAtoi(String str) {
        str = str.trim().split(" ")[0];
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            long l = Long.parseLong(matcher.group());
            if (l > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(l<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else
                return (int) l;
        }
        return 0;
    }
}


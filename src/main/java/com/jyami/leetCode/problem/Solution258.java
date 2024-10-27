package com.jyami.leetCode.problem;


/**
 * Created by jyami on 2020/07/26
 * Article : https://leetcode.com/articles/add-digits/
 */
public class Solution258 {
    public int addDigits(int num) {
        while (num / 10 != 0) {
            int result = 0;
            while (num != 0) {
                result += num % 10;
                num = num / 10;
            }
            num = result;
        }
        return num;
    }

}

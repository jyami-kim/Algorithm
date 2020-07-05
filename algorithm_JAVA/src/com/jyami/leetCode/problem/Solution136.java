package com.jyami.leetCode.problem;

import java.util.Arrays;

/**
 * Created by jyami on 2020/04/08
 */
class Solution136 {
    public static void main(String[] args) {
        int[] a = {17, 12, 5, -6, 12, 4, 17, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6};
        int i = new Solution136().singleNumber(a);
        System.out.println(i);
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int num1 = nums[2 * i];
            int num2 = nums[2 * i + 1];
            if (num1 != num2) {
                return num1;
            }
        }
        return nums[nums.length - 1];
    }
}

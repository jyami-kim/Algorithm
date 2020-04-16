package com.jyami.leetCode.week1;

import java.util.Arrays;

/**
 * Created by jyami on 2020/04/08
 */
class SingleNumber {
    public static void main(String[] args) {
        int[] a = {17, 12, 5, -6, 12, 4, 17, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6};
        int i = new SingleNumber().singleNumber(a);
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

package com.jyami.leetCode.problem;

public class Solution189 {
    public void rotate(int[] nums, int k) {
        int rotate = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, rotate-1 );
        reverse(nums, rotate, nums.length-1 );
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++; end--;
        }
    }
}

package com.jyami.leetCode.problem;


import java.util.Arrays;

/**
 * Created by jyami on 2020/06/25
 */
public class Solution287 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }
}

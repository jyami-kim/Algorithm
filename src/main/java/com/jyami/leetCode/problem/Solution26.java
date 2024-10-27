package com.jyami.leetCode.problem;

/**
 * Created by jyami on 2020/06/24
 */
public class Solution26 {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int index = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[index] = nums[i+1];
                index++;
            }
        }
        return index;
    }

}

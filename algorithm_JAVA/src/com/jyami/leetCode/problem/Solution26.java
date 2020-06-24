package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

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

    @Test
    void removeDuplicatesTest() {
        int i = removeDuplicates(new int[]{0,0});
        System.out.println(i);

    }
}

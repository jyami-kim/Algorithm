package com.jyami.leetCode.weekly;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created by jyami on 2020/06/25
 */
public class Solution0625 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }

    @Test
    void findDuplicateTest() {
        int duplicate = findDuplicate(new int[]{1, 2, 3, 4, 4});
        System.out.println(duplicate);
    }
}

package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/07/25
 */
public class Solution154 {
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            if (nums[i - 1] > nums[i]) {
                break;
            }
        }
        return min;
    }

    @Test
    void findMinTest() {
//        int[] arr = {1, 3, 5};
        int[] arr = {2,2,2,0,1};
        int min = findMin(arr);
        System.out.println(min);
    }
}

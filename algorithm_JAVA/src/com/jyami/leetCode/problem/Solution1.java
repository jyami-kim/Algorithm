package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created by jyami on 2020/06/16
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    @Test
    void twoSum() {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] solution = twoSum(nums, target);
        System.out.println(Arrays.toString(solution));

    }
}

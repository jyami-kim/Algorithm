package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/07/25
 */
public class Solution154 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[low]) {
                high = mid;
                low++;
            } else {
                high--;
            }
        }
        return nums[low];
    }

    @Test
    void findMinTest() {
//        int[] arr = {3, 1};
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
//        int[] arr = {2,2,2,2};
        int min = findMin(arr);
        System.out.println(min);
    }
}

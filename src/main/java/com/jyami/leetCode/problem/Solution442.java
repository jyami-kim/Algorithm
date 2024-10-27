package com.jyami.leetCode.problem;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyami on 2020/08/06
 */
public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (nums[abs - 1] < 0) {
                list.add(abs);
            }
            nums[abs - 1] = -1 * nums[abs - 1];
        }
        return list;
    }


    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(new Solution442().findDuplicates(nums));
    }
}

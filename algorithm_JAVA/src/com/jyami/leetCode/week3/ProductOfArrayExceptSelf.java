package com.jyami.leetCode.week3;

import java.util.Arrays;

/**
 * Created by jyami on 2020/04/15
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {9,0,-2};
        int[] ints = new ProductOfArrayExceptSelf().productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }

    public int[] productExceptSelf(int[] nums) {
        int all = 1;
        boolean zero = false;
        for (int i = 0; i < nums.length; i++) {
            all *= nums[i];
            if(nums[i] == 0){
                zero = true;
            }
        }
        if(zero){
            int [] result = new int[nums.length];
            for(int i =0; i< nums.length; i++){
                result[i] = 1;
            }
            for(int i =0; i< nums.length; i++){
                for(int j =0 ; j<nums.length; j++){
                    if(i != j){
                        result[i] *= nums[j];
                    }
                }
            }
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = all / nums[i];
        }
        return nums;
    }

}

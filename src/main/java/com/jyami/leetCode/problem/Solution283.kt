package com.jyami.leetCode.problem

class Solution283 {
    fun moveZeroes(nums: IntArray): Unit {
        var nonZero = 0
        for(i in nums.indices){
            if (nums[i] != 0){
                nums[nonZero++] = nums[i]
            }
        }
        for(i in nonZero until nums.size){
            nums[i] = 0
        }
    }
}
package com.jyami.leetCode.problem

class Solution704 {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val pivot = (left + right) / 2
            if (target == nums[pivot]){
                return pivot
            }
            if(target > nums[pivot]){
                left = pivot + 1
            }else{
                right = pivot -1
            }
        }
        return -1
    }
}
package com.jyami.leetCode.problem

class Solution35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        while(low <= high){
            val mid = (low + high) / 2
            if(nums[mid] == target) return mid
            else if (nums[mid] > target) high = mid - 1
            else low = mid + 1
        }
        return low
    }
}
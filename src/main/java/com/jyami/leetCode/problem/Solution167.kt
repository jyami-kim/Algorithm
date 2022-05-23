package com.jyami.leetCode.problem

class Solution167 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var low = 0
        var high = numbers.size-1
        while(low<=high){
            if(numbers[low]+numbers[high] == target){
                return intArrayOf(low+1, high+1)
            }
            if(numbers[low]+numbers[high] < target){
                low++
            }else{
                high--
            }
        }
        return intArrayOf(-1, -1)
    }
}
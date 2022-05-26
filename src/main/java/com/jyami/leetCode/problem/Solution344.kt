package com.jyami.leetCode.problem

class Solution344 {
    fun reverseString(s: CharArray): Unit {
        var low = 0
        var high = s.size - 1
        while(low < high){
            val tmp = s[low]
            s[low] = s[high]
            s[high] = tmp
            low++
            high--
        }
    }
}
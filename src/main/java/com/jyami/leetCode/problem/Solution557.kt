package com.jyami.leetCode.problem

class Solution557 {
    fun reverseWords(s: String): String {
        return s.split(" ")
            .map{reverse(it)}
            .joinToString(" ")
    }

    fun reverse(s: String): String{
        var array = s.toCharArray()
        var low = 0
        var high = array.size-1
        while(low < high){
            val tmp = array[low]
            array[low] = array[high]
            array[high] = tmp
            low++
            high--
        }
        return String(array)
    }
}
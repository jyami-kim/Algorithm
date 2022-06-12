package com.jyami.leetCode.problem

class Solution567 {
    fun checkInclusion(s1: String, s2: String): Boolean {
        for (i in 0..(s2.length - s1.length)) {
            if (findLength(s1, s2, i)) {
                return true
            }
        }
        return false
    }

    private fun findLength(s1: String, s2: String, startIdx: Int): Boolean {
        val array = IntArray(26)
        for (i in s1.indices) {
            array[s1[i].toInt() - 97]++
        }
        for (i in startIdx until startIdx + s1.length) {
            val charIdx = s2[i].toInt() - 97
            if (array[charIdx] == 0) {
                return false
            }else{
                array[charIdx]--
            }
        }
        for(i in s1.indices){
            if(array[s1[i].toInt() - 97] != 0){
                return false
            }
        }
        return true
    }
}
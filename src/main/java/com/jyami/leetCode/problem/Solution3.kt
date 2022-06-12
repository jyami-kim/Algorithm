package com.jyami.leetCode.problem

class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        for (i in s.indices) {
            val maxLength = maxLength(s, i)
            if(max < maxLength){
                max = maxLength
            }
        }
        return max
    }

    private fun maxLength(s: String, startIdx: Int): Int {
        val charArray = BooleanArray(128) { false }
        var idx = startIdx
        var max = 0
        while (idx < s.length) {
            val code = s[idx++].code
            if(charArray[code]){
                return max
            }else{
                charArray[code] = true
            }
            max++
        }
        return max
    }
}
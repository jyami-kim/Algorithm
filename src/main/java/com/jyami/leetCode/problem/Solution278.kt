package com.jyami.leetCode.problem



class Solution278: VersionControl {
    override fun firstBadVersion(n: Int) : Int {
        var good : Int = 1
        var bad :Int = n

        while(good < bad){
            val mid: Int = (bad - good) / 2 + good
            if( isBadVersion(mid) ){
                bad = mid
            } else {
                good = mid + 1
            }
        }
        return bad
    }
}

interface VersionControl : Version{
    fun isBadVersion(version: Int) : Boolean{
        return true // api로 제공
    }
}

interface Version{
    fun firstBadVersion(n: Int): Int
}
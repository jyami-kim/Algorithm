package com.jyami.leetCode

class Solution1545 {
    fun findKthBit(n: Int, k: Int): Char {
        var prev = "0"
        for(i in 1..n){
            prev = makeS(prev)
            println(prev)
        }
        return prev.toCharArray()[k-1]
    }

    fun makeS(prev: String): String{
        return prev + "1" + invert(prev).reversed()
    }

    fun invert(str: String): String{
        return str.map{
            if (it == '0'){
                '1'
            }else{
                '0'
            }
        }.toString()
    }
}
fun main(){
    val solution1545 = Solution1545()
    println(solution1545.findKthBit(4, 11))
}

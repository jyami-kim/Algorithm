package com.jyami.leetCode

import java.util.*

class Soultion1106 {

    val stack = Stack<Char>()

    fun parseBoolExpr(expression: String): Boolean {

        for(c in expression){
            if(c == ')'){
                val result = cacl()
                val push = if(result){
                    't'
                }else{
                    'f'
                }
                stack.push(push)
            } else {
                stack.push(c)
            }
        }
        return stack.pop() == 't'
    }

    fun cacl() : Boolean{
        var pop = stack.pop()
        val bools = mutableListOf<Boolean>()
        while(pop != '('){
            if(pop == 't'){
                bools.add(true)
            }else if(pop=='f'){
                bools.add(false)
            }
            // else : case ,
            pop = stack.pop()
        }
        val op = stack.pop()
        if(op == '&'){
            for(b in bools){
                if(!b){
                    return true
                }
            }
            return false
        }
        if(op == '|'){
            for(b in bools){
                if(b){
                    return true
                }
            }
            return false
        }
        if(op == '!'){
            val b = bools[0]
            return !b
        }
        return false
    }
}

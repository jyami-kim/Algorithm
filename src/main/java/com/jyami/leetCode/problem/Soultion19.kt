package com.jyami.leetCode.problem

class Soultion19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val nodeArray : Array<ListNode?> = arrayOfNulls(30)
        var length = 0
        var start = head
        var current = head
        while(current != null){
            nodeArray[length++] = current
            current = current.next
        }
        val removeNode = nodeArray[length - n]
        if(length - n > 0 ) {
            nodeArray[length - n - 1]?.next = removeNode?.next
        }else{
            start = start?.next
        }
        return start
    }
}
package com.jyami.leetCode.problem;

/**
 * Created by jyami on 2020/06/18
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode line = head;
        while (l1 != null || l2 != null) {
            if(l1 == null){
                line.next = l2;
                line = l2;
                l2 = l2.next;
            }else if(l2 == null){
                line.next = l1;
                line = l1;
                l1 = l1.next;
            }else{
                if (l2.val > l1.val) {
                    line.next = l1;
                    line = l1;
                    l1 = l1.next;
                } else {
                    line.next = l2;
                    line = l2;
                    l2 = l2.next;
                }
            }
        }
        return head.next;
    }


}


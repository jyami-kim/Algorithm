package com.jyami.leetCode.problem;

/**
 * Created by jyami on 2020/07/21
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode root = head;
        ListNode prev = root;
        while (root != null && root.val == val) {
            prev = root;
            root = root.next;
        }
        // 1 1 2
        ListNode now = prev.next;
        while (now != null) {
            if (now.val == val) {
                prev.next = now.next;
            }else{
                prev = now;
            }
            now = now.next;
        }
        return root;
    }

}

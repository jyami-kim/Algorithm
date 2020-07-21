package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

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

    @Test
    void removeElementsTest() {
        // 1->2->6->3->4->5->6
//        ListNode listNode = new ListNode(1, new ListNode(1));
//        ListNode listNode = new ListNode(1, new ListNode(2));
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode listNode1 = removeElements(listNode, 2);
    }
}
package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/06/16
 */
public class Solution2 {

    static int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        boolean first = true;
        ListNode prevNode = new ListNode();
        while (l1 != null || l2 != null) {
            ListNode nowNode = new ListNode();
            int result = 0;
            if (l1 != null && l2 != null) {
                result = addValue(l1.val, l2.val);
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                result = addValue(l2.val, 0);
                l2 = l2.next;
            } else {
                result = addValue(l1.val, 0);
                l1 = l1.next;
            }
            nowNode.val = result;
            prevNode.next = nowNode;
            prevNode = nowNode;
            if(first){
                head = nowNode;
                first = false;
            }
        }
        if(carry == 1){
            prevNode.next = new ListNode(1);
        }
        return head;
    }

    public static int addValue(int val1, int val2) {
        int result = val1 + val2 + carry;
        if (result / 10 == 0){
            carry = 0;
        }else{
            carry = 1;
        }
        return result % 10;
    }

    @Test
    void addTwoNumbers(){
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode listNode = addTwoNumbers(l1, l2);

    }
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}


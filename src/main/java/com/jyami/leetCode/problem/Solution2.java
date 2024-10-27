package com.jyami.leetCode.problem;

/**
 * Created by jyami on 2020/06/16
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode h = new ListNode();
        ListNode node = h;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int val = n1 + n2 + carry;
            carry = val / 10;
            node.next = new ListNode(val % 10);
            if (l1 != null && l2 != null) {
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                l2 = l2.next;
            } else {
                l1 = l1.next;
            }
            node = node.next;
        }
        if(carry == 1){
            node.next = new ListNode(1);
        }
        return h.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode listNode = new Solution2().addTwoNumbers(l1, l2);

    }

}


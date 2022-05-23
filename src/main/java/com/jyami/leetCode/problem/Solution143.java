package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * Created by jyami on 2020/08/20
 */
public class Solution143 {

    public void reorderList(ListNode head) {
        if (head == null)
            return;
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        tmp = head;
        ListNode next;
        while (true) {
            ListNode pop = stack.pop();
            next = tmp.next;
            if (pop == tmp || pop == next) {
                pop.next = null;
                break;
            }
            tmp.next = pop;
            pop.next = next;
            tmp = next;
        }
        stack.clear();
        System.out.println(head);
    }

    @Test
    void reorderListTest() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList(null);
    }
}

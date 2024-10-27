package com.jyami.leetCode.problem;

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

}

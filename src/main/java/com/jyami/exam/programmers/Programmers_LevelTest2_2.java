package com.jyami.exam.programmers;

import java.util.EmptyStackException;
import java.util.Stack;

public class Programmers_LevelTest2_2 {

    public static void main(String args[]) {
        String a = "(())()";
        boolean solution = new Solution().solution(a);
        System.out.println(solution);
    }

    static class Solution {

        boolean solution(String s) {

            Stack stack = new Stack();

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    try {
                        stack.pop();
                    } catch (EmptyStackException e) {
                        return false;
                    }
                }
            }
            if (!stack.empty()) {
                return false;
            }
            return true;
        }


    }
}

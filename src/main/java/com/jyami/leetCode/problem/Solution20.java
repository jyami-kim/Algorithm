package com.jyami.leetCode.problem;


import java.util.Stack;

/**
 * Created by jyami on 2020/06/18
 */
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '[':
                case '{':
                case '(':
                    stack.push(c);
                    break;
                case ']':
                case '}':
                case ')':
                    if(stack.size() ==0)
                        return false;
                    Character pop = stack.pop();
                    if(!((c == ']' && pop == '[') || (c == '}' && pop =='{') || (c == ')' && pop=='('))){
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        if(stack.size() != 0)
            return false;
        return true;
    }
}

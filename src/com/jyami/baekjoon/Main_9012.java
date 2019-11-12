package com.jyami.baekjoon;

import java.util.Scanner;
import java.util.Stack;


public class Main_9012 {

    public static StringBuilder stringBuilder = new StringBuilder();


    public static boolean check(String str) {
        Stack<Character> stack = new Stack<Character>();
        char[] word = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            word[i] = str.charAt(i);
        }
        for (int i = 0; i < word.length; i++) {

            if (word[i] == '(')
                stack.push('(');
            if (word[i] == ')') {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String args[]) {
        int num;
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        for (int i = 0; i < num; i++) {
            String str = in.next();
            if (check(str))
                stringBuilder.append("YES\n");
            else
                stringBuilder.append("NO\n");
        }
        System.out.print(stringBuilder);
    }
}

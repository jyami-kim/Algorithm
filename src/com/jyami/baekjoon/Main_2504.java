package com.jyami.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_2504 {
    public static void main(String args[]){
        Scanner in = new Scanner (System.in);

        Stack<Character> brank = new Stack<Character>();
        Stack<Integer>calc = new Stack<Integer>();
        StringBuilder stringBuilder = new StringBuilder();

        String str = in.next();
        char []words = new char[str.length()];
        for(int i=0; i<str.length();i++){
            words[i] = str.charAt(i);
        }

        for(int i=0; i< words.length; i++){
            switch (words[i]){
                case'(': case '[':
                    brank.push(words[i]);
                    break;
                case')': case ']':
                    if(brank.peek()==')' && words[i]=='('||
                    brank.peek()=='}' && words[i]=='}'){
                        System.out.println(0);
                        return;
                    }
                    break;
            }
        }
        if(!brank.isEmpty()){
            System.out.println(0);
            return;
        }
        System.out.println("OK");
    }
}

package com.jyami.codejam.april2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by jyami on 2020/04/04
 */
public class Solution2 {

    static  BRACKET[] bracket = BRACKET.values();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        String[] input = new String[t];
        for (int i = 0; i < t; i++) {
            input[i] = br.readLine();
            result.append(String.format("Case #%d: %s\n",i+1, process(input[i])));
        }
        System.out.println(result);
    }

    public static String process(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stacks = new Stack<>();
        char[] chars = str.toCharArray();
        int init = chars[0] - '0';
        stackPushTo(stacks, init);
        sb.append(bracket[init].open).append(init);
        for (int i = 1; i < str.length(); i++) {
            int now = chars[i] - '0';
            if(now < stacks.size()){
                sb.append(bracket[stacks.size()-now].close).append(now);
                stackPopTo(stacks, now);
            }else{
                sb.append(bracket[now-stacks.size()].open).append(now);
                stackPushTo(stacks, now);
            }
        }
        sb.append(bracket[stacks.size()].close);
        return sb.toString();
    }

    public static void stackPushTo(Stack<String> stacks, int a){
        int count = a - stacks.size();
        for(int i =0; i<count; i++){
            stacks.add("(");
        }
    }

    public static void stackPopTo(Stack<String> stacks, int a){
        int count = stacks.size()-a;
        for(int i =0; i<count; i++){
            stacks.pop();
        }
    }

    enum BRACKET {
        ZERO("", ""),
        ONE("(", ")"),
        TWO("((", "))"),
        THREE("(((", ")))"),
        FOUR("((((", "))))"),
        FIVE("(((((", ")))))"),
        SIX("((((((", "))))))"),
        SEVEN("(((((((", ")))))))"),
        EIGHT("((((((((", "))))))))"),
        NIGHT("(((((((((", ")))))))))");

        String open;
        String close;

        BRACKET(String open, String close) {
            this.open = open;
            this.close = close;
        }
    }
}



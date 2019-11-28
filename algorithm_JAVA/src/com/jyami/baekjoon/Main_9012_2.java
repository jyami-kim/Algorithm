package com.jyami.baekjoon;

import java.util.Scanner;

public class Main_9012_2 {

    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int t = scanner.nextInt();
//        sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String result = calcResult(scanner.next());
//            sb.append(re)
            System.out.println(result);
        }
    }

    public static String calcResult(String str) {
        int stackSize = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stackSize++;
            } else {
                if (stackSize == 0) { // ')' 이 와서 pop을 해야하는 상태인데 할게 없을 때
                    return "NO";
                }
                stackSize--;
            }
        }
        if (stackSize != 0) { // 'loop'를 전부 도았는데 ( 가 남아있는 상태
            return "NO";
        }
        return "YES"; //loop를 전부 돌아서 stack size가 0인 상태
    }
}

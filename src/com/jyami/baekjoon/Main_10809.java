package com.jyami.baekjoon;

import java.util.Scanner;

public class Main_10809 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char[] word = sc.next().toCharArray();
        //ASCII 문자 a는 97
        Integer[] characters = new Integer[26];

        for (int i = 0; i < word.length; i++) {
            int index = word[i] - 97;
            if (characters[index] == null) {
                characters[index] = i;
            }
        }

        for (int i = 0; i < characters.length; i++) {
            int result = characters[i] == null ? -1 : characters[i];
            System.out.print(result + " ");
        }

    }
}

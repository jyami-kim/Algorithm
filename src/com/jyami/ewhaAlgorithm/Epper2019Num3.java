package com.jyami.ewhaAlgorithm;

import java.util.HashMap;
import java.util.Scanner;

public class Epper2019Num3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        HashMap<Character, Integer> hs = new HashMap();

        char[] first = sc.next().toLowerCase().toCharArray();
        char[] second = sc.next().toLowerCase().toCharArray();

        if (first.length != second.length)
            System.out.println("F");

        for (int i = 0; i < first.length; i++) {
            if (hs.containsKey(first[i])) {
                int count = hs.get(first[i]);
                hs.put(first[i], count++);
            } else {
                hs.put(first[i], 1);
            }
        }


        for (int i = 0; i < second.length; i++) {
            if (hs.containsKey(second[i])) {
                int count = hs.get(second[i]);
                hs.put(first[i], --count);
            } else {
                System.out.println("F");
                return;
            }
        }

        for (int num : hs.values()) {
            if (num != 0) {
                System.out.println("F");
                return;
            }
        }

        System.out.println("T");


    }
}

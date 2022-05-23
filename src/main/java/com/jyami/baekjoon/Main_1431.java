package com.jyami.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_1431 {
    public static void main(String args[]) {

        String str = "안녕1234";
        String replace = str.replace("1234", "");

        String replaceAll = str.replaceAll("\\d", "");

        System.out.println(replace);
        System.out.println(replaceAll);

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        List<Item> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(new Item(sc.next()));
        }

        Collections.sort(list);

        for (Item item : list) {
            System.out.println(item.text);
        }

    }
}


class Item implements Comparable<Item> {
    int size;
    String text;
    int number;

    public Item(String text) {
        this.text = text;
        this.size = text.length();
        this.number = findNumber(text);
    }

    private int findNumber(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sum += str.charAt(i) - '0';
            }
        }
        return sum;
    }

    @Override
    public int compareTo(Item o) {
        return this.size > o.size ? 1 : this.size < o.size ? -1 :
                this.number > o.number ? 1 : this.number < o.number ? -1 :
                        this.text.compareTo(o.text);
    }
}

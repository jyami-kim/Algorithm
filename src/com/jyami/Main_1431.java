package com.jyami;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_1431 {
    public static void main(String args[]) {
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

    private int parsing(String str) {
        try {
            int number = Integer.parseInt(str);
            return number;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private int findNumber(String str) {
        String replace = str.replaceAll("\\D", "");
        int num = parsing(replace);

        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    @Override
    public int compareTo(Item o) {
        return this.size > o.size ? 1 : this.size < o.size ? -1 :
                this.number > o.number ? 1 : this.number < o.number ? -1 :
                        this.text.compareTo(o.text) > 0 ? 1 : this.text.compareTo(o.text) < 0 ? -1 : 0;
    }
}

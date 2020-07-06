package com.jyami.ewhaAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Epper2019Num5 {
    private static Scanner sc;

    public static void main(String args[]) {
        sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        String[] result = new String[n];

        HashMap<Character, ArrayList<Word>> hs = new HashMap();

        for (int i = 0; i < k; i++) {
            String word = sc.next();
            char first = word.charAt(0);
            ArrayList<Word> list;
            if (hs.containsKey(first)) {
                list = hs.get(first);

            } else {
                list = new ArrayList();
            }
            list.add(new Word(word));
            hs.put(first, list);
        }

        for (int i = 0; i < n; i++) {
            char ch = sc.next().charAt(0);
            ArrayList<Word> list = hs.get(ch);
            Collections.sort(list);
            Word w = list.get(0);
            result[i] = w.getName();
            w.addNumber();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }
}

class Word implements Comparable<Word> {
    String name;
    int number;

    public Word(String name) {
        this.name = name;
        this.number = 0;
    }

    public void addNumber() {
        this.number++;
    }


    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }


    @Override
    public int compareTo(Word word) {
        if (this.number > word.getNumber()) {
            return 1;
        } else if (this.number < word.getNumber()) {
            return -1;
        } else {
            return this.name.compareTo(word.getName());
        }
    }
}

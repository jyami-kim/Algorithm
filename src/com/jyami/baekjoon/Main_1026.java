package com.jyami.baekjoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main_1026 {


    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < arrSize; i++) {
            a.add(scanner.nextInt());
        }

        for (int i = 0; i < arrSize; i++) {
            b.add(scanner.nextInt());
        }

        a.sort(Comparator.naturalOrder());
        b.sort(Comparator.reverseOrder());

        for (int i = 0; i < arrSize; i++) {
            int mult = a.get(i) * b.get(i);
            sum += mult;
        }

        System.out.println(sum);

    }

}

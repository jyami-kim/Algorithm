package com.jyami.kickStart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoundF2019TeachMe2 {
    public static Scanner sc;

    public static void main(String args[]) {
        sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            int teacherNumber = sc.nextInt();
            int skillMax = sc.nextInt();

            List<List<Integer>> teachers = new ArrayList<>();

            for (int j = 0; j < teacherNumber; j++) {
                int skillNumberSize = sc.nextInt();
                List<Integer> skillNumber = new ArrayList<>();
                for (int k = 0; k < skillNumberSize; k++) {
                    skillNumber.add(sc.nextInt());
                }
                teachers.add(skillNumber);
            }

            int count = 0;

            for (int j = 0; j < teacherNumber; j++) {
                List<Integer> t1 = teachers.get(i);
                for (int k = 0; k < teacherNumber; k++) {
                    List<Integer> t2 = teachers.get(j);
                    if (t1.equals(t2))
                        continue;
                    List<Integer> skillNumberA = new ArrayList<>(t1);
                    List<Integer> skillNumberB = new ArrayList<>(t2);
                    skillNumberA.removeAll(skillNumberB);
                    if (skillNumberA.size() != 0) {
                        count++;
                    }
                }
            }

            sb.append("Case #" + (i + 1) + ": " + count + "\n");
        }

        System.out.println(sb);
    }
}

package com.jyami.kickStart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoundF2019TeachMe {
    public static Scanner sc;

    public static void main(String args[]) {
        sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            TeachMe teachMe = new TeachMe();
            int combination = teachMe.combination();
            sb.append("Case #" + (i + 1) + " : " + combination + "\n");
        }

        System.out.println(sb);
    }


    static class TeachMe {

        List<Teacher> teachers = new ArrayList<>();
        int teacherNumber;
        int skillMax;

        TeachMe() {
            teacherNumber = sc.nextInt();
            skillMax = sc.nextInt();
            for (int i = 0; i < teacherNumber; i++) {
                teachers.add(new Teacher());
            }
        }

        int combination() {
            int count = 0;

            for (Teacher t1 : teachers) {
                for (Teacher t2 : teachers) {
                    if (t1.equals(t2))
                        continue;
                    List<Integer> skillNumberA = new ArrayList<>(t1.skillNumber);
                    List<Integer> skillNumberB = new ArrayList<>(t2.skillNumber);
                    skillNumberA.removeAll(skillNumberB);
                    if (skillNumberA.size() != 0) {
                        count++;
                    }
                }
            }

            return count;
        }

    }

    static class Teacher {
        int skillNumberSize;
        List<Integer> skillNumber = new ArrayList<>();

        Teacher() {
            skillNumberSize = sc.nextInt();
            for (int i = 0; i < skillNumberSize; i++) {
                skillNumber.add(sc.nextInt());
            }
        }
    }
}

package com.jyami.exam.hackerRank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jyami on 2020/06/29
 */
public class KakaoResult2 {

    static class Digit implements Comparable<Digit> {
        int index;
        List<Integer> digitList;

        public Digit(int index, List<Integer> digitList) {
            this.index = index;
            this.digitList = digitList;
        }

        @Override
        public int compareTo(Digit o) {
            for (int i = 0; i < this.digitList.size(); i++) {
                int compare = Integer.compare(o.digitList.get(i), this.digitList.get(i));
                if (compare != 0)
                    return compare;
            }
            return 0;
        }
    }

    public static List<Integer> solution(List<List<Integer>> arr) {

        List<Digit> digits = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).sort(Comparator.reverseOrder());
            digits.add(new Digit(i, arr.get(i)));
        }

        Collections.sort(digits);

        return digits.stream()
                .map(x -> x.index)
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(Arrays.asList(0, 2), Arrays.asList(2, 3), Arrays.asList(2, 1));
        System.out.println(solution(list));
    }
}

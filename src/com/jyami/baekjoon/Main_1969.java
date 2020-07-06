package com.jyami.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        char[][] matrix = new char[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = br.readLine().toCharArray();
        }


        StringBuilder sb = new StringBuilder();

        int resultHammingDistance = 0;

        for (int j = 0; j < col; j++) {
            DnaSet dnaSet = new DnaSet();
            for (int i = 0; i < row; i++) {
                char dnaValue = matrix[i][j];
                dnaSet.pushSet(dnaValue);
            }

            Collections.sort(dnaSet.dnas);

            DNA hamming = dnaSet.dnas.get(0);

            resultHammingDistance += (row - hamming.count);
            sb.append(hamming.name);
        }


        System.out.println(sb);
        System.out.println(resultHammingDistance);
    }

    static class DnaSet {
        List<DNA> dnas = new ArrayList<>();

        public static final char[] DNA_VALUES = {'A', 'C', 'G', 'T'};

        public DnaSet() {
            for (int i = 0; i < 4; i++) {
                dnas.add(new DNA(DNA_VALUES[i]));
            }
        }

        public void pushSet(char dnaName) {
            switch (dnaName) {
                case 'A':
                    dnas.get(0).addCount();
                    break;
                case 'C':
                    dnas.get(1).addCount();
                    break;
                case 'G':
                    dnas.get(2).addCount();
                    break;
                case 'T':
                    dnas.get(3).addCount();
                    break;
            }
        }

        public DNA getHammingDistance(int num) {

            int count = 0;
            for (int i = 1; i < 4; i++) {
                count += dnas.get(i).count;
            }

            return new DNA(dnas.get(0).name, count);
        }

    }

    static class DNA implements Comparable<DNA> {
        private char name;
        private int count = 0;


        public DNA(char name) {
            this.name = name;
        }

        public DNA(char name, int count) {
            this.name = name;
            this.count = count;
        }


        public void addCount() {
            this.count += 1;
        }

        @Override
        public int compareTo(DNA o) {
            if (this.count < o.count) {
                return 1;
            } else if (this.count > o.count) {
                return -1;
            } else {
                if (this.name > o.name) {
                    return 1;
                } else if (this.name < o.name) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

}

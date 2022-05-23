package com.jyami.exam.programmers;

import java.util.HashMap;
import java.util.HashSet;

public class HackDay2019Winter2 {
    public static void main(String args[]) {
//        String[] input = {"..........", "AAACC.....", ".AAA.....Z", "..AAAA..C.", "...BBBBB..", "....BBB...", "...ZBBB...", "ZZZZAAAC..", ".....CCCC.", "QQ......C.", ".........."};
//        String[] input = {"A.B.C.D", ".B.C.D."};
//        String[] input = {"AAAAAAA", "A.....A", "A.BC..A", "A.....A", "AAAAAAA"};
//        String[] input = {"AA.AAAA", "A.D...A", "A.BCD.A", "A.D.D.A", "AAAA.AA"};
        String[] input = {"AB"};
//        String[] input = {"AA", "BC"};

        int[] solution = new Solution().solution(input);
        System.out.println(solution[0]);
        System.out.println(solution[1]);

    }

    static class Solution {

        int row = 0;
        int col = 0;
        HashMap<Character, HashSet<Character>> hashSetHashMap = new HashMap<>();

        public int[] solution(String[] maps) {
            row = maps.length + 2;
            col = maps[0].length() + 2;

            char[][] littleMap = makeCharMap(maps);

            for (int i = 1; i < row - 1; i++) {
                for (int j = 1; j < col - 1; j++) {
                    char my = littleMap[i][j];
                    if (my == '.') {
                        continue;
                    } else {
                        exeCharacter(my, littleMap, i, j);
                    }
                }
            }

            int allCount = 0;
            int maxCount = 0;

            for (Character c : hashSetHashMap.keySet()) {
                int size = hashSetHashMap.get(c).size();
                allCount += size;
                if (maxCount < size) {
                    maxCount = size;
                }
            }

            int[] output = {allCount / 2, maxCount};

            return output;
        }

        void exeCharacter(char my, char[][] littleMap, int i, int j) {
            char down = littleMap[i + 1][j]; //아래
            char up = littleMap[i - 1][j]; //위
            char right = littleMap[i][j + 1]; //오른쪽
            char left = littleMap[i][j - 1]; //왼쪽
            putLogic(down, my);
            putLogic(up, my);
            putLogic(right, my);
            putLogic(left, my);
        }

        void putLogic(char direction, char my) {
            if (direction != '.' && direction != '0' && direction != my) {
                HashSet<Character> characters = hashSetHashMap.get(my);
                if (characters != null) {
                    characters.add(direction);
                } else {
                    characters = new HashSet<>();
                    characters.add(direction);
                }
                hashSetHashMap.put(my, characters);
            }
        }

        char[][] makeCharMap(String[] maps) {
            char[][] littleMap = new char[row][col];

            for (int i = 0; i < maps.length; i++) {
                System.arraycopy(maps[i].toCharArray(), 0, littleMap[i + 1], 1, col - 2);
            }
            for (int i = 0; i < col; i++) {
                littleMap[0][i] = '0';
                littleMap[row - 1][i] = '0';
            }

            for (int i = 0; i < row; i++) {
                littleMap[i][0] = '0';
                littleMap[i][col - 1] = '0';
            }
            return littleMap;
        }
    }
}

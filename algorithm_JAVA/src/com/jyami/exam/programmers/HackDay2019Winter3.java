package com.jyami.exam.programmers;

import java.util.regex.Pattern;

public class HackDay2019Winter3 {
    public static void main(String args[]) {
//        String command = "<v>AB^CYv^XAZ";
//        String[] buttons = {"v>AB^CYv^XA", "<v>A", "^XAZ", "Yv^XA", ">AB^"};
//        int[] scores = {50, 18, 20, 30, 25};

        String command = "abab";
        String[] buttons = {"ab", "aba"};
        int[] scores = {20, 30};
//        String command = "ABCXYZ";
//        String[] buttons = {"BCXY"};
//        int[] scores = {2};
//        String command = "ABCXYZAB"; // 3 + 3 + 2 = 8 / 3+3+4 =10
//        String[] buttons = {"CXYZ", "AB"};
//        int[] scores = {2, 3};

        int solution = new Solution().solution(command, buttons, scores);
        System.out.println(solution);
    }


    static class Solution {

        String[] commandButtons;
        int[] commandScores;
        int max;

        public void replaceString(String replace, int score) {

            for (int j = 0; j < commandButtons.length; j++) {
                if (replace.contains(commandButtons[j])) {
                    String replaceNext = replace.replaceFirst(Pattern.quote(commandButtons[j]), "*");

//                    System.out.print(commandButtons[j] + " " + commandScores[j]);
                    //score 계산
                    int nowScore = score + commandScores[j];
                    String result = replaceNext.replace("*", "");
                    int addScore = nowScore + result.length();
                    if (addScore > max) {
                        max = addScore;
                    }
//                    System.out.print("   " + replaceNext);
//                    System.out.print("max : " + max + "   addScore : " + addScore);
                    replaceString(replaceNext, nowScore); //깊게 들어가기
//                    System.out.println();
                }
            }
        }

        public int solution(String command, String[] buttons, int[] scores) {
            commandButtons = buttons;
            commandScores = scores;

            max = command.length(); //아무것도 안눌럿을 때
            replaceString(command, 0);


            return max;
        }
    }
}

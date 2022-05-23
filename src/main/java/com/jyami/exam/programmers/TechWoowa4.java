package com.jyami.exam.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TechWoowa4 {

    public static void main(String args[]) {
        String[] infos = {"kim password", "lee abc"};
        String[] actions = {
                "ADD 30",
                "LOGIN kim abc",
                "LOGIN lee password",
                "LOGIN kim password",
                "LOGIN kim password",
                "ADD 30",
                "ORDER",
                "ORDER",
                "ADD 40",
                "ADD 50"};

        Solution solution = new Solution();
        boolean[] solution1 = solution.solution(infos, actions);
        for (boolean sol : solution1) {
            System.out.print(sol + " ");
        }

    }

    static class Solution {

        public static List<String> cart = new ArrayList<>();
        public static String currentUser = null;

        public boolean[] solution(String[] infos, String[] actions) {
            boolean[] result = new boolean[actions.length];
            for (int i = 0; i < actions.length; i++) {
                boolean actionResult = commandCheck(actions[i], infos);
                result[i] = actionResult;
            }
            return result;

        }

        private boolean login(String[] infos, String idAndPassword) {
            if (currentUser != null) {
                return false;
            }

            boolean userInInfos = Arrays.asList(infos).contains(idAndPassword);

            if (userInInfos) {
                currentUser = idAndPassword;
                return true;
            }
            return false;
        }

        private boolean inputCart(String userInput) {
            if (currentUser == null) {
                return false;
            }
            cart.add(userInput);
            return true;
        }

        private boolean order() {
            if (currentUser == null)
                return false;
            if (cart.isEmpty())
                return false;
            cart.clear();
            return true;
        }

        private boolean commandCheck(String action, String[] infos) {
            String command = action.split(" ")[0];
            String userInput = action.replace(command + " ", "");
            boolean result = false;
            switch (command) {
                case "LOGIN":
                    result = login(infos, userInput);
                    break;
                case "ADD":
                    result = inputCart(userInput);
                    break;
                case "ORDER":
                    result = order();
                    break;
            }
            return result;
        }


    }

}

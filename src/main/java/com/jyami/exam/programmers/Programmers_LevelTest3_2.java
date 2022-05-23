package com.jyami.exam.programmers;

import java.util.PriorityQueue;

public class Programmers_LevelTest3_2 {

    public static void main(String args[]) {

        String[] input = {"I 653", "I -45", "I -45", "D -1"};
        int[] solution = new Solution().solution(input);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    static class Solution {
        public static PriorityQueue<Integer> queue;


        public int[] solution(String[] operations) {


            queue = new PriorityQueue<>();

            for (String oper : operations) {
                exe(oper);
            }

            if (queue.isEmpty()) {
                int[] answer = {0, 0};
                return answer;
            }

            Integer[] arr = new Integer[queue.size()];
            queue.toArray(arr);
            int max = arr.length - 1;
            int[] answer = {arr[max], arr[0]};

            return answer;
        }

        public void exe(String s) {
            Integer num = Integer.valueOf(s.substring(2));

            if (s.charAt(0) == 'I') {
                queue.add(num);
            } else if (!queue.isEmpty()) {
                if (num == 1) { // 최대값삭제
                    Integer[] arr = new Integer[queue.size()];
                    queue.toArray(arr);
                    int max = arr[arr.length - 1];
                    queue.remove(max);
                } else { // 최소값 삭제
                    queue.poll();
                }
            }

        }
    }
}

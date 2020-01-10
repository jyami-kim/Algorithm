package com.jyami.exam.programmers;

public class TechWoowa2 {

    public static void main(String args[]) {
        String log = "2019/05/01 00:59:19\n" +
                "2019/06/01 01:35:20\n" +
                "2019/08/01 02:01:22\n" +
                "2019/08/01 02:01:23\n" +
                "2019/08/02 03:02:35\n" +
                "2019/10/03 04:05:40\n" +
                "2019/10/04 06:23:10\n" +
                "2019/10/10 08:23:20\n" +
                "2019/10/12 08:42:24\n" +
                "2019/10/23 08:43:26\n" +
                "2019/11/14 08:43:29\n" +
                "2019/11/01 10:19:02\n" +
                "2019/12/01 11:23:10";

        Solution solution = new Solution();
        int[] solution1 = solution.solution(log);
        for (int sol : solution1) {
            System.out.print(sol + " ");
        }

    }

    static class Solution {
        static final int LOG_TIME_START_INDEX = 11;
        static final int LOG_TIME_END_INDEX = 13;
        static final int UTC_KOREA = 9;

        public int[] solution(String logs) {
            int[] answer = new int[24];
            String[] split = logs.split("\n");

            for (String oneLog : split) {
                String hourString = oneLog.substring(LOG_TIME_START_INDEX, LOG_TIME_END_INDEX);
                int hour = Integer.valueOf(hourString) + UTC_KOREA % 24;
                answer[hour]++;
            }
            return answer;
        }

    }
}

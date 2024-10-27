package com.jyami.leetCode.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jyami on 2020/08/26
 */
public class Solution983 {

    int[] cost;
    Set<Integer> days = new HashSet<>();
    Integer[] date = new Integer[366];

    public int mincostTickets(int[] days, int[] costs) {
        this.cost = costs;
        for (int d : days) {
            this.days.add(d);
        }
        return dp(1);
    }

    public int dp(int day) {
        if (day > 365)
            return 0;
        if (date[day] != null)
            return date[day];
        int answer;
        if (this.days.contains(day)) {
            answer = Math.min(dp(day + 1) + cost[0], dp(day + 7) + cost[1]);
            answer = Math.min(answer, dp(day + 30) + cost[2]);
        } else {
            answer = dp(day + 1);
        }
        date[day] = answer;
        return answer;
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(new Solution983().mincostTickets(days, costs));
    }

}

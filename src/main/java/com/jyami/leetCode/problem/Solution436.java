package com.jyami.leetCode.problem;

/**
 * Created by jyami on 2020/08/27
 */
public class Solution436 {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int index = -1;
            int diff = Integer.MAX_VALUE;
            for (int j = 0; j < intervals.length; j++) {
                if (intervals[i][1] <= intervals[j][0] && intervals[j][0] - intervals[i][1] < diff) {
                    index = j;
                    diff = intervals[j][0] - intervals[i][1];
                    if(diff == 0){
                        break;
                    }
                }
            }
            result[i] = index;
        }
        return result;
    }
}

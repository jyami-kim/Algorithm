package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by jyami on 2020/08/16
 */
public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        int result = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                end = Math.min(end, intervals[i][1]);
                result++;
            } else {
                end = intervals[i][1];
            }
        }
        return result;
    }

    @Test
    void eraseOverlapIntervalsTest() {
        int[][] intervals = {{1, 2}, {1, 2}, {1, 2}};
        int i = eraseOverlapIntervals(intervals);
        System.out.println(i);
    }
}

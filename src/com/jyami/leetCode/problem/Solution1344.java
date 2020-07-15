package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/07/15
 */
public class Solution1344 {

    private static final int MINUTES_DEGREE = 6;
    private static final int ONE_HOUR_DEGREE = 30;
    private static final double HOUR_DEGREE = 0.5;

    public double angleClock(int hour, int minutes) {
        double hourDegree = ONE_HOUR_DEGREE * (hour % 12) + HOUR_DEGREE * (minutes % 60);
        int minutesDegree = MINUTES_DEGREE * (minutes % 60);

        double degree = Math.abs(hourDegree - minutesDegree);
        double otherDegree = 360-degree;

        return Math.min(degree, otherDegree);
    }

    @Test
    void angleClockTest(){
        double v = angleClock(1, 57);
        System.out.println(v);
    }

}

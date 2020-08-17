package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created by jyami on 2020/08/17
 */
public class Solution575 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] nowPeople = new int[num_people];
        int index = 0;
        int nowCandies = 1;
        while (candies > 0) {
            if (candies > nowCandies) {
                nowPeople[index] += nowCandies;
            } else {
                nowPeople[index] += candies;
            }
            index = (index + 1) % num_people;
            candies -= nowCandies++;
        }
        return nowPeople;
    }

    @Test
    void distributeCandiesTest() {
        System.out.println(Arrays.toString(distributeCandies(10, 3)));

    }
}

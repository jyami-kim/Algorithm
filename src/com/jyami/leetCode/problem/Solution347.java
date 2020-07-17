package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Created by jyami on 2020/07/17
 */
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            count++;
            if (nums[i] != nums[i + 1]) {
                pq.add(new int[]{count, nums[i]});
                count = 0;
            }
        }
        pq.add(new int[]{++count, nums[nums.length-1]});
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[1];
        }
        return result;
    }

    @Test
    void topKFrequent(){
        int[] nums = {1,2,2};
        int k = 1;
        int[] ints = topKFrequent(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}

package com.jyami.leetCode.problem;

import java.util.*;

/**
 * Created by jyami on 2020/08/18
 */
public class Solution963 {
    public int[] numsSameConsecDiff(int N, int K) {
        Queue<Integer> list = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            list.offer(i);
        }
        if (N == 1)
            list.offer(0);
        for (int i = 1; i < N; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                Integer poll = list.poll();
                int digitNum = poll % 10;
                if (digitNum + K < 10)
                    list.offer(poll * 10 + (digitNum + K));
                if (digitNum - K >= 0 && K != 0)
                    list.offer(poll * 10 + (digitNum - K));
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Solution963().numsSameConsecDiff(2, 0);
        System.out.println(Arrays.toString(ints));
    }
}

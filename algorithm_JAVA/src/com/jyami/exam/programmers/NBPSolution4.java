package com.jyami.exam.programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyami on 2020/07/01
 */
public class NBPSolution4 {

    static class Memo implements Comparable<Memo> {
        List<Integer> comb = new ArrayList<>();
        int count = 0;

        public Memo(List<Integer> comb, int count) {
            this.comb = comb;
            this.count = count;
        }

        public Memo(int count) {
            this.count = count;
        }

        @Override
        public int compareTo(Memo o) {
            return Integer.compare(this.count, o.count);
        }
    }

    public int solution(int n, int capacity, int[] files) {
        Memo[][] dp = new Memo[files.length + 1][capacity + 1];
        for (int i = 0; i <= files.length; i++) {
            dp[i][0] = new Memo(0);
        }
        for (int i = 0; i <= capacity; i++) {
            dp[0][i] = new Memo(0);
        }
        for (int i = 1; i <= files.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < files[i - 1]) {
                    dp[i][j] = dp[i - 1][files[i - 1]];
                } else {
                    Memo now = dp[i - 1][j - files[i - 1]];
                    Memo prev = dp[i - 1][files[i - 1]];
                    if (1 + now.count >= prev.count) {
                        Memo memo = dp[i - 1][j - files[i - 1]];
                        List<Integer> list = new ArrayList<>(memo.comb);
                        list.add(files[i - 1]);
                        dp[i][j] = new Memo(list, 1 + now.count);
                    } else {
                        dp[i][j] = prev;
                    }
                }
            }
        }
        return dp[files.length][capacity].count;
    }

    @Test
    void solutionTest() {
        int solution = solution(1, 3, new int[]{2,2,2,2,2});
        System.out.println(solution);
    }
}

package com.jyami.leetCode.weekly;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/06/24
 */
public class Solution0624 {

    public int numTrees(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            int result = 0;
            for (int j = 0; j < i; j++) {
                result += arr[i - j-1] * arr[j];
            }
            arr[i] = result;
        }
        return arr[n];
    }

    @Test
    void numTreesTest() {
        int i = numTrees(1);
        System.out.println(i);
    }

}

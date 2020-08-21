package com.jyami.leetCode.problem;

/**
 * Created by jyami on 2020/08/21
 */
public class Solution905 {
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int right = 0;
        int left = A.length - 1;
        for (int i = 0; A.length > i; i++) {
            if (A[i] % 2 == 0) {
                result[right++] = A[i];
            } else {
                result[left--] = A[i];
            }
        }
        return result;
    }
}

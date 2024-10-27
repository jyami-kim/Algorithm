package com.jyami.leetCode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jyami on 2020/07/23
 */
public class Solution260 {
    public int[] singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.contains(num)) {
                list.remove(Integer.valueOf(num));
            } else {
                list.add(num);
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

}

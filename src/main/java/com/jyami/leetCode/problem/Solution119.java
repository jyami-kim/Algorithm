package com.jyami.leetCode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyami on 2020/08/12
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < i; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
}

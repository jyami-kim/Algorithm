package com.jyami.leetCode.weekly;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jyami on 2020/07/04
 */
public class Solution0703 {

    static int diff = 14;

    public int[] prisonAfterNDays(int[] cells, int N) {

        Map<Integer, String> map = new HashMap<>();
        int[] result = new int[cells.length];
        result[0] = 0;
        result[cells.length - 1] = 0;

        for (int i = 0; i < diff; i++) {
            for (int j = 1; j < cells.length - 1; j++) {
                result[j] = checkStatus(cells[j - 1], cells[j + 1]);
            }
            cells = result.clone();
            String resultString = Arrays.toString(result);
            map.put(i, resultString);
        }

        Integer index = (N-1) % diff;
        String value = map.get(index);
        String[] split = value.substring(1, value.length() - 1).split(",");
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i].trim());
        }
        return result;
    }

    public int checkStatus(int before, int after) {
        return before == after ? 1 : 0;
    }

    @Test
    void prisonAfterNDaysTest() {
        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        int[] ints = prisonAfterNDays(cells, 7);
        System.out.println(Arrays.toString(ints));

    }

}

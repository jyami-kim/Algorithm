package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyami on 2020/07/11
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> additionalList = new ArrayList<>();
            for (List<Integer> subList : resultList) {
                List<Integer> sub = new ArrayList<>(subList);
                sub.add(num);
                additionalList.add(sub);
            }
            resultList.addAll(additionalList);
        }
        return resultList;
    }

    @Test
    void subsetsTest(){
        int[] nums = {1,2,3,4};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }
}

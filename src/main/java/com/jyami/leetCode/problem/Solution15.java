package com.jyami.leetCode.problem;

import java.util.*;

/**
 * Created by jyami on 2020/07/09
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int n = 0; n < nums.length - 2; n++) {
            if (n == 0 || nums[n] != nums[n - 1]) {
                int sum = -nums[n];
                int low = n + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if (sum == nums[low] + nums[high]) {
                        result.add(Arrays.asList(-sum, nums[low], nums[high]));
                        List<Integer> list = new ArrayList<>();
                        while ((low < high) && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while ((low < high) && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (sum > nums[low] + nums[high]) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }


    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new Solution15().threeSum(input);
        System.out.println(lists);
    }
}

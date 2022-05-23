package com.jyami.exam.programmers;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TechWoowa3 {

    public static void main(String args[]) {
//        int prices[] = {13000, 88000, 10000};
//        int discounts[] = {30, 20};

        int prices[] = {13000, 88000, 10000};
        int discounts[] = {30, 20};

        Solution solution = new Solution();
        int solution1 = solution.solution(prices, discounts);
        System.out.println(solution1);
    }

    static class Solution {
        public int solution(int[] prices, int[] discounts) {
            List<Integer> sortedPrice = intArrayToList(prices);
            List<Integer> sortedDiscounts = intArrayToList(discounts);

            int index = 0;
            int result = 0;
            int discountSize = sortedDiscounts.size();
            for (Integer price : sortedPrice) {
                if (index < discountSize) {
                    double multipleRate = 100 - sortedDiscounts.get(index++);
                    double calculate = price * multipleRate / 100;
                    result += calculate;
                } else {
                    result += price;
                }
            }
            return result;
        }

        private List<Integer> intArrayToList(int[] array) {
            return Arrays.stream(array)
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());
        }

    }
}

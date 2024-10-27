package com.jyami.leetCode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyami on 2020/08/26
 */
public class Solution412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0)
                result.add("FizzBuzz");
            else if (i % 3 == 0)
                result.add("Fizz");
            else if (i % 5 == 0)
                result.add("Buzz");
            else
                result.add(Integer.toString(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution412().fizzBuzz(15));
    }
}

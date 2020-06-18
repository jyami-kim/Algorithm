package com.jyami.leetCode.weekly;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jyami on 2020/04/08
 */
public class HappyNumber {
    public static void main(String[] args) {
        boolean happy = new HappyNumber().isHappy(19);
        System.out.println(happy);
    }

    public boolean isHappy(int n) {
        Set<Integer> integers = new HashSet<>();
        int num = result(n);
        while(num != 1){
            if(integers.contains(num)){
                return false;
            }
            integers.add(num);
            num = result(num);
        }
        return true;
    }

    public int result(int n){
        int temp = n;
        int sum = 0;
        while (temp != 0) {
            int num = temp % 10;
            sum += Math.pow(num, 2);
            temp = temp / 10;
        }
        return sum;
    }
}

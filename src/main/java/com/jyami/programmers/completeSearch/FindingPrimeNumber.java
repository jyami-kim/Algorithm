package com.jyami.programmers.completeSearch;

import java.util.*;

/**
 * Created by jyami on 2020/01/15
 * 소수찾기
 * https://programmers.co.kr/learn/courses/30/lessons/42839?language=java
 */
public class FindingPrimeNumber {

    public static void main(String[] args) {
        String numbers = "001";
        System.out.println(new Solution().solution(numbers));
    }

    static class Solution {
        public int solution(String numbers) {
            char[] chars = numbers.toCharArray();
            Arrays.sort(chars);
            int[] integers = new int[10];
            StringBuilder maxNumString = new StringBuilder();
            for(int i=chars.length-1; i>=0; i--){
                integers[chars[i]-'0'] += 1;
                maxNumString.append(chars[i] - '0');
            }
            int maxNumber = Integer.parseInt(maxNumString.toString());

            if(maxNumber == 0){
                return 0;
            }

            boolean[] notPrime = primCount(maxNumber);
            int count = 0;

            for(int i =0; i<maxNumber+1; i++){
                if(!notPrime[i] && haveSameNumbers(integers, String.valueOf(i))){
                    count++;
                }
            }

            return count;
        }

        public boolean haveSameNumbers(int[] corrects, String primeNumber){
            int[] numbers = new int[10];
            for(char c : primeNumber.toCharArray()){
                numbers[c-'0'] += 1;
            }
            for(int i =0; i<numbers.length; i++){
                if(numbers[i] > corrects[i])
                    return false;
            }
            System.out.println(primeNumber);
            return true;
        }

        public boolean[] primCount(int maxNumber){
            boolean[] notPrime = new boolean[maxNumber + 1];
            notPrime[0] = true;
            notPrime[1] = true;
            int index = 2;
            while(index < notPrime.length){
                if(!notPrime[index]){
                    int i = index + index;
                    while(i < notPrime.length){
                        notPrime[i] = true;
                        i += index;
                    }
                }
                index++;
            }
            return notPrime;

        }
    }
}

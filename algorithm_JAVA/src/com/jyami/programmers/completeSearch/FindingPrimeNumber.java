package com.jyami.programmers.completeSearch;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jyami on 2020/01/15
 */
public class FindingPrimeNumber {

    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(new Solution().solution(numbers));
    }

    static class Solution {
        public int solution(String numbers) {
            char[] chars = numbers.toCharArray();
            Set<Integer> set = new HashSet<>();
            for (int r = 1; r <= chars.length; r++) { // 사용할 숫자의 개수
                boolean[] visited = new boolean[chars.length];
                combination(visited, 0, chars.length, r, set, chars);
            }
            List<Integer> collect = set.stream().sorted().collect(Collectors.toList());
            Integer max = collect.get(collect.size() - 1);
            boolean[] notPrim = primCount(new boolean[max+1]);

            int count = 0;
            for(int a : collect){
                if(!notPrim[a])
                    count++;
            }
            return count;
        }

        public boolean[] primCount(boolean[] notPrime){
            notPrime[0] = true;
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


        public int makeNumber(boolean[] comb, char[] chars){
            StringBuilder result = new StringBuilder();
            for(int i =0; i<chars.length; i++){
                if(comb[i]){
                    result.append(chars[i]);
                }
            }
            String answer = result.toString();
            if(answer.equals("")){
                return 0;
            }
            return Integer.parseInt(answer);
        }

        public void combination(boolean[] visited, int start, int n, int r, Set<Integer> result, char[]chars){
            if(r==0){
                result.add(makeNumber(visited, chars));
            }else{
                for(int i=start; i<n; i++){
                    visited[i] = true;
                    combination(visited, i+1, n, r-1, result, chars);
                    visited[i] = false;
                }
            }
        }
    }
}

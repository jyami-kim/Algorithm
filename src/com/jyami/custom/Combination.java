package com.jyami.custom;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jyami on 2020/01/05
 * Java에는 왜 조합 라이브러리가 없을까 스스로 구현해봄
 */
public class Combination {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        boolean[] visitied = new boolean[4];

        System.out.println("combination backtracking");
        for(int i =0; i< 4; i++){
            combinationBackTracking(integers, visitied, 0, 4, i);
        }
        System.out.println("===\n");

        System.out.println("combination recursion");
        for(int i =0; i< 4; i++){
            combinationRecursion(integers, visitied, 0, 4, i);
        }

    }

    static void combinationBackTracking(List<Integer> arr, boolean[] visited, int start, int n, int r){
        if(r == 0){
            print(arr, visited);
        } else {
            for(int i =start; i<n; i++){
                visited[i] = true;
                combinationBackTracking(arr, visited, i+1, n, r-1);
                visited[i] = false;
            }
        }
    }

    static void combinationRecursion(List<Integer> arr, boolean[] visited, int depth, int n, int r){
        if(r == 0 && depth ==n){
            print(arr, visited);
        }
        if(depth == n){
            return ;
        }else{
            visited[depth] = true;
            combinationRecursion(arr, visited, depth + 1, n , r-1);
            visited[depth] = false;
            combinationRecursion(arr, visited, depth + 1, n , r);
        }
    }

    static void print(List<Integer> arr, boolean[] visited){
        for(int i =0; i < arr.size(); i++){
            if(visited[i])
                System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }
}

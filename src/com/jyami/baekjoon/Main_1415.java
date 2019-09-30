package com.jyami.baekjoon;

import java.util.Scanner;

public class Main_1415 {

    public static int[] primeArr = new int[10001];

    public static void main(String args[]) {

        primeArrInit();

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] userInput = new int[size];
        boolean[] userInputVisited = new boolean[size];
        for (int i = 0; i < size; i++) {
            userInput[i] = scanner.nextInt();
        }

        for (int i = 1; i <= size; i++) {
            combination(userInput, userInputVisited, 0, size, i);
        }


//        System.out.println("result: " + getResultFromPrimArr());
        System.out.println(getResultFromPrimArr());
    }

    static int getResultFromPrimArr() {
        int total = 0;
        for (int i = 0; i < 10001; i++) {
            if (primeArr[i] == 2) {
                total++;
            }
        }
        return total;
    }

    static int getCombinationSum(int[] arr, boolean[] visited, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += arr[i];
            }
        }
        return sum;
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int combinationSum = getCombinationSum(arr, visited, n);
            if (primeArr[combinationSum] != 1) {
                primeArr[combinationSum] = 2; //합으로 인정되는 소수! : hash 개념
            }
        } else {
            for (int i = start; i < n; i++) {
                visited[i] = true;
                combination(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }

    static void primeArrInit() {
        for (int i = 2; i <= 10000; i++) {
            if (primeArr[i] == 1) // 체크 되면 배수인 것
                continue;
            for (int j = i + i; j <= 10000; j += i) {
                primeArr[j] = 1; //배수에 체크!
            }
        }
    }

}

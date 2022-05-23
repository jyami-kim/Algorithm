package com.jyami.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1676 {
    public static void main(String[] args) throws IOException {
        //n!에서 뒤에서부터 처음 0이아닌 숫자가 나올l 때까지 0의 개수를 구하는 프로그램을 작성하시오 : 곱셈임 2*5의 쌍을 찾기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int two = 0;
        int five = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;

            while (temp % 2 == 0) {
                temp = temp / 2;
                two++;
            }
            temp = i;
            while (temp % 5 == 0) {
                temp = temp / 5;
                five++;
            }
        }

        int count = Math.min(two, five);
        System.out.println(count);

    }
}

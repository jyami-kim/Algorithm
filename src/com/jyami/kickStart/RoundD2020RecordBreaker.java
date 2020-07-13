package com.jyami.kickStart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by jyami on 2020/07/12
 */
public class RoundD2020RecordBreaker {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            sb.append(recordBreaker(i + 1, br)).append("\n");
        }
        System.out.println(sb);
    }

    public static String recordBreaker(int caseNum, BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] collect = new int[n];
        for (int i = 0; i < n; i++) {
            collect[i] = Integer.parseInt(s[i]);
        }

        int count = 0;
        int max = collect[0];
        int size = collect.length;

        if (size == 1) {
            count++;
        }

        if (size > 1 && max > collect[1]) {
            count++;
        }

        for (int i = 1; i < size - 1; i++) {
            if (max < collect[i] && collect[i] > collect[i + 1]) {
                count++;
            }
            if (collect[i] > max) {
                max = collect[i];
            }
        }
        if (size > 1 && max < collect[size - 1]) {
            count++;
        }

        return String.format("Case #%d: %d", caseNum, count);
    }

}

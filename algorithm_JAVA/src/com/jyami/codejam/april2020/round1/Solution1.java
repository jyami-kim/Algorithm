package com.jyami.codejam.april2020.round1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jyami on 2020/04/11
 */
public class Solution1 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String answer = answer(n);
            sb.append(String.format("CASE #%d: %s\n", i + 1, answer));
        }
        System.out.println(sb);
    }

    public static String answer(int n) throws IOException {
        String[] arr = new String[n];
        arr[0] = br.readLine().replace("*", "");
        String key = arr[0];
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            arr[i] = br.readLine().replace("*", "");
            if (arr[i].contains(key)) {
                key = arr[i];
                for (int j = 0; j < i; j++) {
                    if (!key.contains(arr[j])) {
                        return "*";
                    }
                }
            } else if (key.contains(arr[i])) {
                flag = true;
            } else {
                return "*";
            }
        }
        if (flag) {
            return key;
        } else {
            return "*";
        }
    }
}

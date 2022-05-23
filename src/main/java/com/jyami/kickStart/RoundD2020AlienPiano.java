package com.jyami.kickStart;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jyami on 2020/07/12
 */
public class RoundD2020AlienPiano {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {

            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] collect = new int[n];
            for (int j = 0; j < n; j++) {
                collect[j] = Integer.parseInt(s[j]);
            }

            sb.append(alienPiano(i + 1, collect)).append("\n");
        }
        System.out.println(sb);
    }

    public static String alienPiano(int caseNum, int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 0;

        int count = 0;
        int min = 0, max = 0;

        for (int i = 1; i < nums.length; i++) {
            int compare = Integer.compare(nums[i], nums[i - 1]);
            result[i] = result[i - 1] + compare;

            if (result[i] < min)
                min = result[i];
            if (result[i] > max)
                max = result[i];
            if (max - min > 3) {
                count++;
                min = result[i];
                max = result[i];
            }

        }

        return String.format("Case #%d: %d", caseNum, count);
    }

    @Test
    void alienPianoTest() {
        int[] nums = {1, 5, 500, 100, 6, 1};
        String s = alienPiano(1, nums);
        System.out.println(s);
    }

}

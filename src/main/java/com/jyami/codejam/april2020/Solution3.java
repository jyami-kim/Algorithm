package com.jyami.codejam.april2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by jyami on 2020/04/05
 */
public class Solution3 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i<t; i++){
            sb.append(String.format("Case #%d: %s\n",i+1, process()));
        }
        System.out.println(sb.toString());
    }

    public static String process() throws IOException {

        int n = Integer.parseInt(br.readLine());

        boolean[][] schedule = new boolean[1440][2];
        char result[] = new char[n];

        Time[] times = new Time[n];
        for (int i = 0; i < n; i++) {
            String[] in = br.readLine().split(" ");
            int start = Integer.parseInt(in[0]);
            int end = Integer.parseInt(in[1]);
            times[i] = new Time(start, end, i);
        }

        Arrays.sort(times, Comparator.comparingInt(o -> o.start));

        for (int i = 0; i < n; i++) {
            boolean cameron = true;
            boolean jamie = true;

            for (int j = times[i].start; j < times[i].end; j++) {
                if (schedule[j][0]) {
                    cameron = false;
                }
            }

            if (cameron) {
                for (int j = times[i].start; j < times[i].end; j++) {
                    schedule[j][0] = true;
                }
                result[times[i].index] = 'C';
            }else{
                for (int j = times[i].start; j < times[i].end; j++) {
                    if (schedule[j][1]) {
                        jamie = false;
                    }
                }

                if (jamie) {
                    for (int j = times[i].start; j < times[i].end; j++) {
                        schedule[j][1] = true;
                    }
                    result[times[i].index] = 'J';
                } else {
                    return "IMPOSSIBLE";
                }
            }

        }

        return String.valueOf(result);

    }
}

class Time{
    int start;
    int end;
    int index;

    public Time(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

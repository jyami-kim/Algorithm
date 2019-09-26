package com.jyami;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main_1026 {

    public static BufferedReader bufferedReader;

    public static void main(String args[]) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        int arrSize = bufferedReader.read();

        List<Integer> a = getArrayFromInput();
        List<Integer> b = getArrayFromInput();

        a.sort(Comparator.naturalOrder());
        a.sort(Comparator.reverseOrder());

        for (int i = 0; i < arrSize; i++) {
            int mult = a.get(i) * b.get(i);
            result += mult;
        }

        System.out.println(result);

    }

    public static List<Integer> getArrayFromInput() throws IOException {
        String[] integersInString = bufferedReader.readLine().split(" ");
        Integer array[] = new Integer[integersInString.length];
        for (int i = 0; i < integersInString.length; i++) {
            array[i] = Integer.parseInt(integersInString[i]);
        }
        return Arrays.asList(array);
    }


}

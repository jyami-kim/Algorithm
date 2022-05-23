package com.jyami.ewhaAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Epper2019Num8 {
    public static int n;
    public static int m;
    private static Scanner sc;

    public static void main(String args[]) {
        sc = new Scanner(System.in);

        List<Tomato> list = new ArrayList();

        n = sc.nextInt();
        m = sc.nextInt();

        int[][] result = new int[n + 2][m + 2];
        for (int i = 0; i < m + 2; i++) {
            result[0][i] = 2;
            result[n + 1][i] = 2;
        }

        for (int i = 0; i < n + 2; i++) {
            result[i][0] = 2;
            result[i][m + 1] = 2;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = sc.nextInt();
                result[i + 1][j + 1] = num;
                if (num == 1) {
                    list.add(new Tomato(i + 1, j + 1));
                }
            }
        }

        int count = 0;

        while (!list.isEmpty()) {
            for (Tomato t : list) {
                count++;

                int row = t.getRow();
                int col = t.getCol();

                t.make(result);
                if (row - 1 != 0) {
                    Tomato up = new Tomato(row - 1, col);
                    if (up.checkEmptyAround(result)) {
                        list.add(up);
                    }
                }

                if (row + 1 != n + 1) {
                    Tomato down = new Tomato(row + 1, col);
                    if (down.checkEmptyAround(result)) {
                        list.add(down);
                    }
                }

                if (col - 1 != 0) {
                    Tomato left = new Tomato(row, col - 1);
                    if (left.checkEmptyAround(result)) {
                        list.add(left);
                    }
                }

                if (col + 1 != m + 1) {
                    Tomato right = new Tomato(row, col + 1);

                    if (right.checkEmptyAround(result)) {
                        list.add(right);
                    }
                }

                list.remove(t);
            }
        }

        System.out.println(count);

    }


}

class Tomato {
    int row;
    int col;

    public Tomato(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean checkEmptyAround(int arr[][]) {
        if (row - 1 != 2 && col != 2) {
            int up = arr[row - 1][col];
            if (up == 0)
                return true;
        }

        if (row + 1 != 2 && col != 2) {
            int down = arr[row + 1][col];
            if (down == 0)
                return true;
        }

        if (row != 2 && col - 1 != 2) {
            int left = arr[row][col - 1];
            if (left == 0)
                return true;
        }

        if (row != 2 && col + 1 != 2) {
            int right = arr[row][col + 1];

            if (right == 0)
                return true;
        }

        return false;
    }

    public void make(int arr[][]) {
        int up = arr[row - 1][col];
        int down = arr[row + 1][col];
        int left = arr[row][col - 1];
        int right = arr[row][col + 1];

        if (up != -1 && up != 2) {
            arr[row - 1][col] = 1;
        }
        if (down != -1 && down != 2) {
            arr[row + 1][col] = 1;
        }
        if (left != -1 && left != 2) {
            arr[row][col - 1] = 1;
        }
        if (right != -1 && right != 2) {
            arr[row][col + 1] = 1;
        }


    }

}

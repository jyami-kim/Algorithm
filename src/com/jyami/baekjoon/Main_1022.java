package com.jyami.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1022 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int r1 = Integer.parseInt(input[0]);
        int c1 = Integer.parseInt(input[1]);
        int r2 = Integer.parseInt(input[2]);
        int c2 = Integer.parseInt(input[3]);


        int rowSize = r2 - r1 + 1;
        int colSize = c2 - c1 + 1;

        int rowIndex = r1;
        int colIndex = c1;

        int map[][] = new int[rowSize][colSize];

        //max len size도 찾는 방법이 있을 것 같은데...

        int max = 0;

        for (int i = 0; i < rowSize; i++, rowIndex++, colIndex = c1) {
            for (int j = 0; j < colSize; j++, colIndex++) {
                int myNum = Hurricane.getMyNum(rowIndex, colIndex);
                map[i][j] = myNum;
                if (myNum > max) {
                    max = myNum;
                }
            }
        }
        int maxLength = String.valueOf(max).length();

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                appendPrintValue(map[i][j], maxLength);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void appendPrintValue(int value, int max) {
        int length = String.valueOf(value).length();
        for (int i = 0; i < max - length; i++) {
            sb.append(" ");
        }
        sb.append(value + " ");
    }

    enum Hurricane {
        SUB_PLUS_MAIN_PLUS(1, 1, 1, 0) {
            @Override
            int getHurricaneValue(int mainValue, int subValue) {
                if (mainValue == subValue) {
                    return getDiagonalValue(mainValue + 1);
                }
                return hurricaneValueCalcFirst(0, mainValue, subValue);
            }
        },
        SUB_MINUS_MAIN_PLUS(1, -1, 1, 0) {
            @Override
            int getHurricaneValue(int mainValue, int subValue) {

                return hurricaneValueCalcSecond(1, mainValue, subValue);
            }
        },
        MAIN_MINUS_SUB_PLUS(-1, 1, 0, 1) {
            @Override
            int getHurricaneValue(int mainValue, int subValue) {
                return hurricaneValueCalcFirst(2, mainValue, subValue);
            }
        },
        MAIN_MINUS_SUB_MINUS(-1, -1, 0, 1) {
            @Override
            int getHurricaneValue(int mainValue, int subValue) {
                return hurricaneValueCalcSecond(3, mainValue, subValue);
            }
        },
        SUB_MINUS_MAIN_MINUS(-1, -1, 1, 0) {
            @Override
            int getHurricaneValue(int mainValue, int subValue) {
                return hurricaneValueCalcFirst(4, mainValue, subValue);

            }
        },
        SUB_PLUS_MAIN_MINUS(-1, 1, 1, 0) {
            @Override
            int getHurricaneValue(int mainValue, int subValue) {
                return hurricaneValueCalcSecond(5, mainValue, subValue);
            }
        },
        MAIN_PLUS_SUB_MINUS(1, -1, 0, 1) {
            @Override
            int getHurricaneValue(int mainValue, int subValue) {
                return hurricaneValueCalcFirst(6, mainValue, subValue);

            }
        },
        MAIN_PLUS_SUB_PLUS(1, 1, 0, 1) {
            @Override
            int getHurricaneValue(int mainValue, int subValue) {
                return hurricaneValueCalcSecond(7, mainValue, subValue);
            }
        };

        int mainFlag;   // 마이너스 플러스 플래그 값 : -1 1
        int subFlag;    // 마이너스 플러스 플래그 값 : -1 1
        int mainLocation;   // 메인값의 위치 0 1
        int subLocation;    // 서브값의 위치 0 1

        Hurricane(int mainFlag, int subFlag, int mainLocation, int subLocation) {
            this.mainFlag = mainFlag;
            this.subFlag = subFlag;
            this.mainLocation = mainLocation;
            this.subLocation = subLocation;
        }

        static int getMyNum(int row, int col) {

            int main;
            int mainLocation;
            int sub;
            int subLocation = 0;
            int mainFlag = 1;
            int subFlag = 1;

            if (Math.abs(row) > Math.abs(col)) {
                main = row;
                mainLocation = 0;
                sub = col;
                subLocation = 1;
            } else {
                main = col;
                mainLocation = 1;
                sub = row;
                subLocation = 0;
            }

            if (main < 0) {
                mainFlag = -1;
            }
            if (sub < 0) {
                subFlag = -1;
            }

            int finalSubFlag = subFlag;
            int finalMainFlag = mainFlag;
            int finalMainLocation = mainLocation;
            int finalSubLocation = subLocation;


            Hurricane hurricane = Arrays.stream(Hurricane.values())
                    .filter(h ->
                            h.subFlag == finalSubFlag && h.mainFlag == finalMainFlag && h.mainLocation == finalMainLocation && h.subLocation == finalSubLocation
                    ).findFirst()
                    .get();

            return hurricane.getHurricaneValue(main, sub);

        }

        abstract int getHurricaneValue(int mainValue, int subValue);

        int hurricaneValueCalcFirst(int weight, int mainValue, int subValue) {
            int absoluteMain = mainValue * this.mainFlag;
            int absoluteSub = subValue * this.subFlag;
            return getDiagonalValue(absoluteMain) + absoluteMain * weight + (absoluteMain - absoluteSub);
        }

        int hurricaneValueCalcSecond(int weight, int mainValue, int subValue) {
            int absoluteMain = mainValue * this.mainFlag;
            int absoluteSub = subValue * this.subFlag;
            return getDiagonalValue(absoluteMain) + absoluteMain * weight + absoluteSub;
        }

        int getDiagonalValue(int diagonal) {
            return (2 * diagonal - 1) * (2 * diagonal - 1);
        }

    }

}

package com.jyami.ewhaAlgorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlgoReport2 {

    public static final String DEFAULT_DIR = "testData";

    public static void main(String args[]) {

        String fileName = "graph6.txt";
        String line = null;

        int n = 0;     // vertex의 개수
        int start = 0; // 시작 vertex의 번호

        List<List<Integer>> weight = null; //stream()문법으로
        // parsing을 빠르게 하기 위해 Array 대신 List 클래스 사용

        try {
            FileReader fileReader = new FileReader(DEFAULT_DIR + "/" + fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int count = 0;

            while ((line = bufferedReader.readLine()) != null) { //파일 한줄 씩 읽어오기.
                if (count == 0) { //맨 첫 줄에는 파일입력에 대한 정보가 들어있으므로 조건문으로 분기
                    n = Integer.valueOf(line.split(" ")[0]);
                    start = Integer.valueOf(line.split(" ")[1]);
                } else {

                    List<Integer> integers = Arrays.asList(line.split(" ")).stream()
                            .map(s -> Integer.valueOf(s))
                            .collect(Collectors.toList());
                    integers.add(0, 0); // 각 배열의 인덱스를 1부터 시작하기 위함
                }
                count++;
            }

            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }

        int[] touch = new int[n + 1];    // 연결된 vertex 저장 배열 (후에 path를 유추할 수 있다.)
        int[] length = new int[n + 1];   // 집합 F에서 각 vertex까지의 길이
        int[] result = new int[n];     // 연결된 vertex들의 최소 길이 배열 저장
        int vnear = 0;

        for (int i = 1; i <= n; i++) {
            if (i != start) {
                touch[i] = start;
                length[i] = weight.get(start).get(i);
                // 초기 집합 F에 start vertex만 존재하므로
                // length는 start vertex와 다른 vertex들 사이의 거리
            }
        }

        result[start - 1] = 0; // start -> start 사이거리는 0이므로 추가

        for (int count = 1; count < n; count++) {
            int min = Integer.MAX_VALUE; // 2^31-1

            // 방문한 vertex들의 집합 F에서 방문하지 않은 vertex들의 거리값을 저장한 length 배열에서
            // 가장 최솟값을 찾아 다음에 방문할 vertex로 지정한다 (= vnear )
            for (int i = 1; i <= n; i++) {
                if (i != start) {
                    if (0 <= length[i] && length[i] < min) {
                        min = length[i];
                        vnear = i;
                    }
                }
            }

            // MAX일땐 방문하면 안되므로 예외 처리 (안하면 overflow)
            // vnear이 F로 들어오면 집합 F에 따른 vertex들의 거리값이 달라지므로 length, touch 배열을 수정한다.
            for (int i = 1; i <= n; i++) {
                if (i != start && weight.get(vnear).get(i) != Integer.MAX_VALUE) {
                    if (length[vnear] + weight.get(vnear).get(i) < length[i]) {
                        length[i] = length[vnear] + weight.get(vnear).get(i);
                        touch[i] = vnear;
                    }
                }
            }

            result[vnear - 1] = min;  // 방문한 vertex 하나가 추가될 때마다. 해당 vertex의 값을 result에 저장
            length[vnear] = -1;     // 방문한 vertex에 대한 표시로 음수값 지정
        }

        // 출력 형식 포맷팅
        String resultArray = Arrays.toString(result).replace("[", "(").replace("]", ")");

        System.out.println("입력파일 " + fileName);
        System.out.println("정점 v" + start + "(으)로부터 각 정점까지의 최단경로 = " + resultArray);


    }
}

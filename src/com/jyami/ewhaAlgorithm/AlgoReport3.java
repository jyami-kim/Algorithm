package com.jyami.ewhaAlgorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class AlgoReport3 {

    public static void main(String args[]) {
        //파일 입출력 : 파일 읽기 후 입력데이터 객체 저장
        FileIO inputData = new FileIO("p2data6.txt");
        System.out.println();

        // DP knapsack을 구현한 클래스, 입력데이터를 객체 멤버변수로 저장 (생성자)
        // DP knapsack 진행 후 결과 출력 (run 메소드)
        DPKnapsack dpKnapsack = new DPKnapsack(inputData);
        dpKnapsack.runDPKnapSack();
        System.out.println();

        // Backtracking knapsack을 구현한 클래스, 입력데이터를 객체 멤버 변수로 저장 (생성자)
        // Backtracking knapsack 진행 후 결과 출력 (run 메소드)
        BacktrackingKnapsack backtrackingKnapsack = new BacktrackingKnapsack(inputData);
        backtrackingKnapsack.runBacktrackingKnapsack();
        System.out.println();
    }

    //Vector 출력 format 제공을 위한 static method 제공 (각 run 메소드에서 사용)
    public static String printVectorForm(int[] vectorInclude) {
        String result = "(";
        int n = vectorInclude.length - 1;
        for (int i = 1; i < n; i++) {
            result = result + vectorInclude[i] + ",";
        }
        return result + vectorInclude[n] + ")";
    }
}

class FileIO {
    // 파일의 내용을 읽고, knapsack 입력데이터로 저장,
    // 각 데이터의 특성에 맞는 멤버변수 이름을 할당하였다.

    int n;          //object의 크기
    int[] price;    // pi (물건 t에 대한 이윤)
    int[] weight;   // wi (물건 t에 대한 무게)
    int capacity;   // knapsack의 용량 (M)

    FileIO(String fileName) {
        getInstanceFromFile(fileName);
    }

    // 객체 생성시 실행되는 메소드 (외부 접근 불가 private)
    // Scanner 대신 BufferedReader를 활용하여 입출력 시간 최소화 하였다.

    private void getInstanceFromFile(String fileName) {
        try {
            // line 수가 적고, 띄어쓰기가 많은 데이터이기 때문에
            // Scanner의 next() 메소드 대신
            // BufferedReader의 readLine() 메소드 사용

            FileReader fileReader = new FileReader("testData/" + fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            System.out.println("file name = " + fileName);

            this.n = Integer.valueOf(bufferedReader.readLine());
            System.out.println("n = " + n);

            String prices = bufferedReader.readLine();
            System.out.println("pi = " + prices);
            this.price = getIntegersFromFile(prices);

            String weights = bufferedReader.readLine();
            System.out.println("wi = " + weights);
            this.weight = getIntegersFromFile(weights);

            //pi, wi 배열을 바로 계산하여 출력 (pricePerWeight 메소드)
            System.out.println("pi/wi = " + pricePerWeight());

            this.capacity = Integer.valueOf(bufferedReader.readLine());
            System.out.println("M = " + capacity);

            bufferedReader.close();

            //Exception 관리
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    // line 입력 후 정수 배열로 저장되는 데이터는 따로 메소드를 이용하여 데이터 할당하였다.
    // 변환 과정 : readLine() -> String -> getIntegersFromFile()메소드 -> int[]
    // 교재의 유사코드를 활용할 때, index 가 1로 시작하는 경우를 고려해야해서,
    // inputData 자체의 크기를 n + 1 로 만들었다.
    private int[] getIntegersFromFile(String input) {
        String[] inputArray = input.split(" ");
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = Integer.parseInt(inputArray[i - 1]);
        }
        return result;
    }

    // price, weight 배열을 할당 한 후, 각 배열의 원소에 접근하여 나눗셈을 진행한다.
    // fractional knapsack 의 upperbound 계산에 필요한 pi/wi를 보여주기위한 결과를 return 하는 함수이다.
    private String pricePerWeight() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            stringBuilder.append((double) price[i] / (double) weight[i] + " ");
        }
        return stringBuilder.toString();
    }
}

//Dynamic Programming(DP)를 이용한 knapsack문제를 구현한 클래스이다.
class DPKnapsack {

    // 입력 데이터 (FileIO의 멤버 변수)
    // 입력 데이터 외에 객체내 여러 메소드에서 공유되어야 할 변수가 없었다.
    int n;
    int capacity;
    int[] weight;
    int[] price;

    DPKnapsack(FileIO fileIO) {
        this.n = fileIO.n;
        this.capacity = fileIO.capacity;
        this.weight = fileIO.weight;
        this.price = fileIO.price;
    }

    public void runDPKnapSack() {

        long start = System.nanoTime(); //실행시간 측정 시작 (nano)

        int dp[][] = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) { // 주어진 object의 개수가 n개 이므로 (index 고려한) n 회 반복
            for (int w = 0; w <= capacity; w++) { // index 가 0인 경우도 고려하여 표(2차원 배열)를 그리므로 n + 1회 반복
                if (weight[i] <= w)
                    dp[i][w] = Math.max(dp[i - 1][w], price[i] + dp[i - 1][w - weight[i]]);
                else
                    dp[i][w] = dp[i - 1][w];
                // if object의 무게를 고려해야할 때이다.
                //    (경우 1) 해당 object를 넣었을 때, (dp[i-1, M-weight]) - 새로운 profit
                //    (경우 2) 해당 object를 넣지 않았을 때, (dp[i-1, M]) - 이전 profit 적용
                // else
                // 용량이 w (kg) 일 때, object의 무게가 더 크면 아예 + 고려 할 필요 없다 > 이전 profit 적용
            }
        }

        // 헤벡터를 구하기 위한 코드 : DP를 거꾸로 생각 (뒤에서부터 찾아감)
        int backDPPrice = dp[n][capacity];
        int backDPWeight = capacity;
        int vectorInclude[] = new int[n + 1];

        for (int i = n; i > 0 && backDPPrice > 0; i--) {
            if (backDPPrice == dp[i - 1][backDPWeight]) {   // 해당 weight 의 이전 profit 값과 같으면,
                vectorInclude[i] = 0;                       // i번째 object 는 사용되지 않았다는 의미이다.
            } else {
                vectorInclude[i] = 1;                       // 해당 weight 의 profit 값과 같지 않으면,
                backDPPrice -= price[i];                    // i번째 object 는 사용되었다는 의미이며
                backDPWeight -= weight[i];                  // i번째 object 의 price, weight 값을 전체에서 빼고 생각
            }
        }

        long end = System.nanoTime(); //실행시간 측정 끝 (nano)
        // 1 nano = 0.001 micro

        System.out.println("(1) Dynamic Programming");
        System.out.println("The maximum price is " + dp[n][capacity]);
        System.out.println("The solution vector X = " + AlgoReport3.printVectorForm(vectorInclude));
        System.out.println("The execution time is " + (end - start) / (double) 1000 + " microseconds");

    }
}

// Backtracking Knapsack에서 중요한 점은,
// 각 물체의 price와 weight와 pricePerWeight 값을 한번에 관리하는 것이었다.
// 따라서 InputNode라는 하나의 객체로 묶은후, int index(원래 input시 입력 순차) 값을 멤버변수로 저장하여
// pricePerWeight에 따른 정렬에도 세가지 배열값을 조정하지 않으며, 기존 입력 순차를 빠르게 접근한다.
class InputNode {
    int price;
    int weight;
    double pricePerWeight;
    int index;

    public InputNode() { //empty Node
    }

    public InputNode(int price, int weight, double pricePerWeight, int index) {
        this.price = price;
        this.weight = weight;
        this.pricePerWeight = pricePerWeight;
        this.index = index;
    }

    //test시 사용했던 메소드 : toString 메소드를 오버라이딩하여 (quick정렬이 잘 되었는지) 간단히 확인
    @Override
    public String toString() {
        return "[ " + index + " ] pricePerWeight = " + pricePerWeight;
    }
}

// Backtracking Knapsack을 전 데이터 정제를 위한 sort 알고리즘 구현
// quick 정렬을 이용하였다.
// 정렬의 기준이되는 key값은 pricePerweight이다.
class QuickSortWithInputNode {

    //QuickSort class를 외부에서 사용할 수 있는 method (비즈니스 로직에 맞게 한정지음)
    public static void sortInputNodeList(List<InputNode> inputNodes) {
        quickSort(inputNodes, 0, inputNodes.size() - 1);
    }

    //quick 정렬 테스트시 사용했던 메소드 : 외부 접근을 쉽게 하였다.
    public static void printSortedList(List<InputNode> inputNodes) {
        sortInputNodeList(inputNodes);
        for (int i = 0; i < inputNodes.size(); i++) {
            System.out.println(inputNodes.get(i).toString());
        }
    }

    // quick 정렬의 in-place sorting이란 특징으로 인해, swap 메소드 구현
    // 이때, InputNode의 자료형에 주의하며, List에 할당해야한다.
    // InputNode 객체 자체를 이동하여 price, weight, pi/wi를 정렬하고 헤벡터를 찾는 코드를 간단히 함
    private static void swap(List<InputNode> nodes, int a, int b) {
        InputNode tmp = nodes.get(a);
        nodes.set(a, nodes.get(b));
        nodes.set(b, tmp);
    }

    // quick Sort 오름차순 정렬일 때, 위쪽정렬 후 아래쪽 정렬일 때 시간복잡도가 낮았다.
    // 따라서 내림차순 정렬에서는 아래 정렬후 위 정렬을 했다.
    private static void quickSort(List<InputNode> inputNodes, int start, int end) {
        if (start < end) { // 내림차순 정렬에 따른 부등호 방향 주의
            int p = partition(inputNodes, start, end);
            quickSort(inputNodes, start, p - 1);    //p 기준 아래쪽 정렬
            quickSort(inputNodes, p + 1, end);      //p 기준 위쪽 정렬
        }
    }

    // pivot을 기준으로 분리된 배열을 정렬한다. (swap을 이용한 in-place sort)
    private static int partition(List<InputNode> inputNodes, int start, int end) {
        double pivot = inputNodes.get(end).pricePerWeight; // 기준이되는 pivot의 값은 pricePerWieght = 정렬 기준
        int idx = start - 1;
        for (int i = start; i < end; i++) {
            if (inputNodes.get(i).pricePerWeight > pivot)
                swap(inputNodes, ++idx, i);
        }
        swap(inputNodes, ++idx, end);
        return idx;
    }

    //quickSort의 또다른 구현 방법 (not use recursion - but using stack) : not description
    private static void quickSortIter(List<InputNode> inputNodes, int low, int high) {
        Stack<Integer> stack = new Stack();

        stack.push(low);
        stack.push(high);

        while (!stack.empty()) {
            high = stack.pop();
            low = stack.pop();

            int p = partition(inputNodes, low, high);

            if (p - 1 > low) {
                stack.push(low);
                stack.push(p - 1);
            }

            if (p + 1 < high) {
                stack.push(p + 1);
                stack.push(high);
            }
        }
    }
}

class BacktrackingKnapsack {

    //메소드간 공유되는 변수 (인자로 넣어도 되지만, 인자 수를 최대한 줄이기 위하여)
    int bestSet[];
    int include[];
    int maxProfit = 0;
    // 기본 입력 데이터
    int n;
    int capacity;
    List<InputNode> inputNodes;

    public BacktrackingKnapsack(FileIO fileIO) {
        this.inputNodes = makeDataToNode(fileIO); // inputNode 객체를 생성하고 동시에 pi/wi값을 기준으로 퀵정렬한다.
        this.n = fileIO.n;
        this.bestSet = new int[n + 1];
        this.include = new int[n + 1];
        this.capacity = fileIO.capacity;
    }

    //private 접근 지정하여 외부에서 생성하는 것을 제한한다.
    private List<InputNode> makeDataToNode(FileIO fileIO) {
        List<InputNode> inputNodes = new ArrayList<>();
        for (int i = 1; i <= fileIO.n; i++) {
            inputNodes.add(new InputNode(fileIO.price[i], fileIO.weight[i],
                    (double) fileIO.price[i] / (double) fileIO.weight[i], i));
        }
        QuickSortWithInputNode.sortInputNodeList(inputNodes); // 위에서 구현한 InputNode 기반 Quick sort 메소드 사용
        inputNodes.add(0, new InputNode()); // inputData의 배열과 크기 일치 (index가 n까지 있음)
        return inputNodes;
    }

    public void runBacktrackingKnapsack() {
        long start = System.nanoTime(); // 1 nano = 0.001 micro
        knapsack(0, 0, 0);
        long end = System.nanoTime();

        System.out.println("(2) Backtracking (or FIFO Branch-and-Bound)");
        System.out.println("The maximum profit is " + maxProfit);
        System.out.println("The solution vector X = " + AlgoReport3.printVectorForm(bestSetArrangeOrigin()));
        System.out.println("The execution time is " + (end - start) / (double) 1000 + " microseconds");
    }

    private void knapsack(int index, int profit, int weight) {
        //  결과 변수 갱신
        //  - 이때, 주어진 profit이 그동안의 탐색에서의 profit 최대값보다 크면
        //  - 도출되는 결과 변수인 maxProfit, bestSet[] 값을 갱신해 주어야한다.

        //이전에 include 된 노드들의 무게 합은 반드시 주어진 용량(M) 보다 작아야한다.
        if (weight <= capacity && profit >= maxProfit) {
            maxProfit = profit;
            System.arraycopy(include, 0, bestSet, 0, n + 1);
        }
        if (promising(index, profit, weight)) { // backtracking 여부를 판정
            // object가 포함되는 경우 (pi/wi로 의해 정렬된 InputNode 객체 중 1개)
            // profit과 weight는 해당 object가 가진 값을 더해서 갱신되어야한다.
            include[index + 1] = 1;
            knapsack(index + 1, profit + inputNodes.get(index + 1).price,
                    weight + inputNodes.get(index + 1).weight);
            //object가 포함되지 않는경우
            include[index + 1] = 0;
            knapsack(index + 1, profit, weight);
        }
    }

    // promising이 false이면 knapsack의 recursion 에서 벗어나 backtracking한다.
    private boolean promising(int index, int profit, int weight) {
        // 지금까지 체크한 모든 node중에서 best solution에 대한 제약조건
        // = 해당 object의 아래에 있는 object들을 모두 포함한다고 가정했을 때,
        //   이때 계산한 fractional knapsack 값은 upper bound가 된다.
        //   따라서 max profit이 upperbound보다 크면 탐색의 의미가 없기 때문에, backtracking한다.
        int j, k;
        if (weight >= capacity) //용량 자체를 넘어간 경우 backtracking
            return false;
        else {
            // fractional knapsack을 구하기 위해 pi를 더하는 과정
            j = index + 1;
            int bound = profit;
            int totWeight = weight;
            while (j <= n && totWeight + inputNodes.get(j).weight <= capacity) {
                totWeight += inputNodes.get(j).weight;
                bound += inputNodes.get(j).price;
                j++;
            }
            k = j;
            // fractional knapsack을 구하기 위해 pi/wi의 비율에 맞게 더하는 과정정
            if (k <= n)
                bound += (capacity - totWeight) * inputNodes.get(k).pricePerWeight;
            return bound > maxProfit; // upperbound보다 넘어서는 경우 backtracking
        }
    }

    // 헤 벡터를 원래 위치대로 나타내기 위해, inputNodes 객체의 멤버변수인 index를 이용하여,
    // 헤 벡터의 위치로 bestSet을 재 배치하는 과정
    private int[] bestSetArrangeOrigin() {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int location = inputNodes.get(i).index;
            result[location] = (bestSet[i] == 1) ? 1 : 0;
        }
        return result;
    }
}







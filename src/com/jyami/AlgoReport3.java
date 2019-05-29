package com.jyami;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class AlgoReport3 {

    public static void main(String args[]) {
        FileIO inputData = new FileIO("p2data6.txt");
        System.out.println();
        DPKnapsack dpKnapsack = new DPKnapsack(inputData);
        dpKnapsack.runDPKnapSack();
        System.out.println();
        BacktrackingKnapsack backtrackingKnapsack = new BacktrackingKnapsack(inputData);
        System.out.println();
        backtrackingKnapsack.runBacktrackingKnapsack();
    }


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
    int n;
    int[] price;
    int[] weight;
    int capacity;

    FileIO(String fileName) {
        getInstanceFromFile(fileName);
    }

    private int[] getIntegersFromFile(String input) {
        String[] inputArray = input.split(" ");
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = Integer.parseInt(inputArray[i - 1]);
        }
        return result;
    }

    private String pricePerWeight() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            stringBuilder.append((double) price[i] / (double) weight[i] + " ");
        }
        return stringBuilder.toString();
    }

    private void getInstanceFromFile(String fileName) {
        try {
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
            System.out.println("pi/wi = " + pricePerWeight());

            this.capacity = Integer.valueOf(bufferedReader.readLine());
            System.out.println("M = " + capacity);
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }
}

class DPKnapsack {

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

        long start = System.nanoTime();

        int dp[][] = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weight[i] <= w)
                    dp[i][w] = Math.max(dp[i - 1][w], price[i] + dp[i - 1][w - weight[i]]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        int backDPPrice = dp[n][capacity];
        int backDPWeight = capacity;
        int vectorInclude[] = new int[n + 1];

        for (int i = n; i > 0 && backDPPrice > 0; i--) {
            if (backDPPrice == dp[i - 1][backDPWeight]) {
                vectorInclude[i] = 0;
            } else {
                vectorInclude[i] = 1;
                backDPPrice -= price[i];
                backDPWeight -= weight[i];
            }
        }

        long end = System.nanoTime();

        System.out.println("(1) Dynamic Programming");
        System.out.println("The maximum price is " + dp[n][capacity]);
        System.out.println("The solution vector X = " + AlgoReport3.printVectorForm(vectorInclude));
        System.out.println("The execution time is " + (end - start)/(double)1000000 + " milliseconds");
    }
}

class QuickSortWithInputNode {

    public static void sortInputNodeList(List<InputNode> inputNodes) {
        quickSort(inputNodes, 0, inputNodes.size() - 1);
    }

    public static void printSortedList(List<InputNode> inputNodes) {
        sortInputNodeList(inputNodes);
        for (int i = 0; i < inputNodes.size(); i++) {
            System.out.println(inputNodes.get(i).toString());
        }
    }

    private static void swap(List<InputNode> nodes, int a, int b) {
        InputNode tmp = nodes.get(a);
        nodes.set(a, nodes.get(b));
        nodes.set(b, tmp);
    }

    private static void quickSort(List<InputNode> inputNodes, int start, int end) {
        if (start < end) {
            int p = partition(inputNodes, start, end);
            quickSort(inputNodes, start, p - 1);
            quickSort(inputNodes, p + 1, end);
        }
    }

    private static int partition(List<InputNode> inputNodes, int start, int end) {
        double pivot = inputNodes.get(end).pricePerWeight;
        int idx = start - 1;
        for (int i = start; i < end; i++) {
            if (inputNodes.get(i).pricePerWeight > pivot)
                swap(inputNodes, ++idx, i);
        }
        swap(inputNodes, ++idx, end);
        return idx;
    }

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
    List<InputNode> inputNodes;
    int bestSet[];
    int include[];
    int n;
    int capacity;
    int maxProfit = 0;

    public BacktrackingKnapsack(FileIO fileIO) {
        this.inputNodes = makeDataToNode(fileIO);
        this.n = fileIO.n;
        this.bestSet = new int[n + 1];
        this.include = new int[n + 1];
        this.capacity = fileIO.capacity;
    }

    public void runBacktrackingKnapsack() {
        long start = System.nanoTime();
        knapsack(0, 0, 0);
        long end = System.nanoTime();

        System.out.println("(2) Backtracking (or FIFO Branch-and-Bound)");
        System.out.println("The maximum profit is " + maxProfit);
        System.out.println("The solution vector X = " + AlgoReport3.printVectorForm(bestSetArrangeOrigin()));
        System.out.println("The execution time is " + (end - start)/(double)1000000 + " milliseconds");
    }

    private int[] bestSetArrangeOrigin() {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int location = inputNodes.get(i).index;
            result[location] = (bestSet[i] == 1) ? 1 : 0;
        }
        return result;
    }

    private void knapsack(int index, int profit, int weight) {
        if (weight <= capacity && profit >= maxProfit) {
            maxProfit = profit;
            System.arraycopy(include, 0, bestSet, 0, n + 1);
        }
        if (promising(index, profit, weight)) {
            include[index + 1] = 1;
            knapsack(index + 1, profit + inputNodes.get(index + 1).price, weight + inputNodes.get(index + 1).weight);
            include[index + 1] = 0;
            knapsack(index + 1, profit, weight);
        }
    }

    private boolean promising(int index, int profit, int weight) {
        int j, k;
        if (weight >= capacity)
            return false;
        else {
            j = index + 1;
            int bound = profit;
            int totWeight = weight;
            while (j <= n && totWeight + inputNodes.get(j).weight <= capacity) {
                totWeight += inputNodes.get(j).weight;
                bound += inputNodes.get(j).price;
                j++;
            }
            k = j;
            if (k <= n)
                bound += (capacity - totWeight) * inputNodes.get(k).pricePerWeight;
            return bound > maxProfit;
        }
    }

    private List<InputNode> makeDataToNode(FileIO fileIO) {
        List<InputNode> inputNodes = new ArrayList<>();
        for (int i = 1; i <= fileIO.n; i++) {
            inputNodes.add(new InputNode(fileIO.price[i], fileIO.weight[i],
                    (double) fileIO.price[i] / (double) fileIO.weight[i], i));
        }
        QuickSortWithInputNode.sortInputNodeList(inputNodes);
        inputNodes.add(0, new InputNode());
        return inputNodes;
    }
}

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

    @Override
    public String toString() {
        return "[ " + index + " ] pricePerWeight = " + pricePerWeight;
    }
}





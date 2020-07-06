package com.jyami.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_10845 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int rear = -1;
        int front = -1;

        int size = in.nextInt();

        ArrayList<Integer> queue= new ArrayList<Integer>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<size; i++){
            String str = in.next();
            switch(str){
                case "push":
                    int value = in.nextInt();
                    queue.add(value);
                    rear++;
                    break;
                case "front":
                    if(front == rear){
                        stringBuilder.append(-1).append("\n");
                    }else{
                        stringBuilder.append(queue.get(front+1)).append("\n");
                    }
                    break;
                case "back":
                    if(front==rear){
                        stringBuilder.append(-1).append("\n");
                    }else{
                        stringBuilder.append(queue.get(rear)).append("\n");
                    }
                    break;
                case "size":
                    stringBuilder.append(rear-front).append("\n");
                    break;
                case "pop":
                    if(front==rear){
                        stringBuilder.append(-1).append("\n");
                    }else{
                        stringBuilder.append(queue.get(++front)).append("\n");
                    }
                    break;
                case "empty":
                    if(front==rear){
                        stringBuilder.append(1).append("\n");
                    }else{
                        stringBuilder.append(0).append("\n");
                    }
                    break;
            }
        }
        System.out.print(stringBuilder);
    }
}

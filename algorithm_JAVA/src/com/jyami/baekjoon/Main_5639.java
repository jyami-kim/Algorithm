package com.jyami.baekjoon;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main_5639 {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        Node root;
        try{
            root = new Node(in.nextInt());
            while(in.hasNextInt()){
                Node n = new Node(in.nextInt());
                root.insert(n);
            }
            root.postorder();
        }catch (NoSuchElementException ex){
            System.out.println();
        }
    }
}

class Node{
    public Node left;
    public Node right;
    public int data;

    public Node(int data){
        this.left = null;
        this.right = null;
        this.data = data;
    }

    void insert(Node newNode){
        if(data > newNode.data){ //left 넣기
            if(left!=null)
                left.insert(newNode);
            else
                left = newNode;
        }else{ //right 넣기
            if(right != null)
                right.insert(newNode);
            else
                right = newNode;
        }
    }

    void postorder(){
        if(left != null)
            left.postorder();
        if(right !=null)
            right.postorder();
        System.out.println(data);
    }
}
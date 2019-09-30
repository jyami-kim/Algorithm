package com.jyami.baekjoon;

import java.util.*;

public class Main_1260 {

    public static ArrayList<Integer>[] adj;
    public static Queue<Integer> q;

    public static boolean[] dfs_visite;
    public static boolean[] bfs_visite;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();
        int start = sc.nextInt();

        adj = (ArrayList<Integer>[])new ArrayList[node+1];
        for(int i=1; i<=node; i++){
            adj[i] = new ArrayList<>();
        }
        q = new LinkedList<>();

        for(int i =0; i<edge; i++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            adj[m].add(n);
            adj[n].add(m);
        }

        for(int i=1; i<=node; i++){
            Collections.sort(adj[i]);
        }

        dfs_visite = new boolean[node+1];
        bfs_visite = new boolean[node+1];

        dfs(start);
        System.out.println();
        bfs(start);
    }

    public static void dfs(int root){
        System.out.print(root+" ");
        dfs_visite[root] = true;
        for(Integer a : adj[root]){
            if(dfs_visite[a] != true){
                dfs(a);
            }
        }
    }

    public static void bfs(int root){
        q.add(root);
        bfs_visite[root] = true;
        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");
            for(Integer a : adj[x]){
                if(bfs_visite[a]!=true){
                    bfs_visite[a] = true;
                    q.add(a);
                }
            }
        }
    }

}

package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyami on 2020/07/24
 */
public class Solution797 {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        list = new ArrayList<>();
        int now = 0;
        boolean[] visited = new boolean[graph.length];
        List<Integer> nowList = new ArrayList<>();
        dfs(graph, visited, now, nowList);
        return list;
    }

    public void dfs(int[][] graph, boolean[] visited, int now, List<Integer> nowList) {
        System.out.println(now);
        visited[now] = true;
        nowList.add(now);
        boolean isMiddle = false;
        for (int other : graph[now]) {
            if (!visited[other]) {
                isMiddle = true;
                dfs(graph, visited, other, nowList);
            }
        }
        if (!isMiddle) {
            list.add(new ArrayList<>(nowList));
        }
        visited[now] = false;
        nowList.remove(Integer.valueOf(now));
    }

    @Test
    public void allPathSourceTargetTest() {
        int[][] arrays = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> lists = allPathsSourceTarget(arrays);
        System.out.println(lists);

    }
}

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
        List<Integer> nowList = new ArrayList<>();
        dfs(graph, now, nowList);
        return list;
    }

    public void dfs(int[][] graph, int now, List<Integer> nowList) {
        System.out.println(now);
        nowList.add(now);
        if (graph[now].length == 0) {
            list.add(nowList);
        }
        for (int other : graph[now]) {
            dfs(graph, other, new ArrayList<>(nowList));
        }
    }

    @Test
    public void allPathSourceTargetTest() {
        int[][] arrays = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> lists = allPathsSourceTarget(arrays);
        System.out.println(lists);

    }
}

package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jyami on 2020/08/07
 */
public class Solution987 {
    TreeMap<Integer, List<VerticalNode>> treeMap;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        treeMap = new TreeMap<>();
        traversal(new VerticalNode(0, 0, root));

        for (List<VerticalNode> verticalNodes : treeMap.values()) {
            List<Integer> collect = verticalNodes.stream()
                    .sorted(Comparator.comparingInt(VerticalNode::getY).reversed()
                            .thenComparingInt(VerticalNode::getNum))
                    .map(x -> x.treeNode.val)
                    .collect(Collectors.toList());
            result.add(collect);
        }

        return result;
    }

    public void traversal(VerticalNode root) {
        List<VerticalNode> list;
        if (treeMap.containsKey(root.x)) {
            list = treeMap.get(root.x);
        } else {
            list = new ArrayList<>();
        }
        list.add(root);
        treeMap.put(root.x, list);

        if (root.treeNode.left != null) {
            traversal(new VerticalNode(root.x - 1, root.y - 1, root.treeNode.left));
        }
        if (root.treeNode.right != null) {
            traversal(new VerticalNode(root.x + 1, root.y - 1, root.treeNode.right));
        }
    }

    public static class VerticalNode {
        int x;
        int y;
        TreeNode treeNode;

        public VerticalNode(int x, int y, TreeNode treeNode) {
            this.x = x;
            this.y = y;
            this.treeNode = treeNode;
        }

        public int getY() {
            return y;
        }

        public Integer getNum() {
            return treeNode.val;
        }
    }

    @Test
    void verticalTraversalTest() {
//        TreeNode treeNode = new TreeNode(1,
//                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
//                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
//
        TreeNode treeNode = new TreeNode(0, new TreeNode(2,
                new TreeNode(3, new TreeNode(4, null, new TreeNode(7, new TreeNode(10), new TreeNode(8))),
                        new TreeNode(5, new TreeNode(6, new TreeNode(11), new TreeNode(9)), null)),null),
                new TreeNode(1));

        List<List<Integer>> lists = verticalTraversal(treeNode);
        System.out.println(lists);
    }

}

package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Created by jyami on 2020/07/02
 */
public class Solution107 {

    static class Node {
        int depth;
        TreeNode treeNode;

        public Node(int depth, TreeNode treeNode) {
            this.depth = depth;
            this.treeNode = treeNode;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        queue.offer(new Node(1, root));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            TreeNode poll = node.treeNode;

            if (poll != null) {
                if (result.size() < node.depth) {
                    result.add(new ArrayList<>());
                }
                result.get(node.depth - 1).add(poll.val);

                if (poll.left != null) {
                    queue.add(new Node(node.depth + 1, poll.left));
                }
                if (poll.right != null) {
                    queue.add(new Node(node.depth + 1, poll.right));
                }
            }
        }
        Collections.reverse(result);

        return result;
    }

    @Test
    void levelOrderBottom() {
//        TreeNode root = new TreeNode(3);
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null), null), null);

        List<List<Integer>> lists = levelOrderBottom(root);
        System.out.println(lists);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

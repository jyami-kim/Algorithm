package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jyami on 2020/07/10
 */
public class Solution662 {

    static class Node {
        private TreeNode treeNode;
        private int index;

        public Node(TreeNode treeNode, int index) {
            this.treeNode = treeNode;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 1));
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = 0, max = 0;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i == 0) {
                    min = node.index;
                }
                if (i == size - 1) {
                    max = node.index;
                }
                if (node.treeNode.left != null) {
                    queue.offer(new Node(node.treeNode.left, node.index * 2));
                }
                if (node.treeNode.right != null) {
                    queue.offer(new Node(node.treeNode.right, node.index * 2 + 1));
                }
            }
            result = Math.max(result, max - min);
        }
        return result + 1;
    }

    @Test
    void widthOfBinaryTreeTest() {
//        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode root = new TreeNode(1,
                new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null),
                new TreeNode(2, null, new TreeNode(9, null, new TreeNode(7))));
        System.out.println(widthOfBinaryTree(root));
    }

}

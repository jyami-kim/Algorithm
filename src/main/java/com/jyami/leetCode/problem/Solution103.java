package com.jyami.leetCode.problem;

import java.util.*;

/**
 * Created by jyami on 2020/07/22
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        boolean left = true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode;
                if (left) {
                    treeNode = deque.pollFirst();
                } else {
                    treeNode = deque.pollLast();
                }
                list.add(treeNode.val);
                if (left) {
                    if (treeNode.left != null)
                        deque.addLast(treeNode.left);
                    if (treeNode.right != null)
                        deque.addLast(treeNode.right);
                } else {
                    if (treeNode.right != null)
                        deque.addFirst(treeNode.right);
                    if (treeNode.left != null)
                        deque.addFirst(treeNode.left);
                }
            }
            result.add(list);
            left = !left;
        }
        return result;
    }

    public static void main(String[] args) {
        //        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode treeNode = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(new Solution103().zigzagLevelOrder(treeNode));
    }
}

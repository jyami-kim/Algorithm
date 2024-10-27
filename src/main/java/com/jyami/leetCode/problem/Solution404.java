package com.jyami.leetCode.problem;;

/**
 * Created by jyami on 2020/08/24
 */
public class Solution404 {

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null) {
            sumNode(root, false);
        }
        return sum;
    }

    private void sumNode(TreeNode node, boolean isLeft) {
        if (node.left == null && node.right == null && isLeft)
            sum += node.val;
        if (node.left != null)
            sumNode(node.left, true);
        if (node.right != null)
            sumNode(node.right, false);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        System.out.println(new Solution404().sumOfLeftLeaves(node));
    }
}

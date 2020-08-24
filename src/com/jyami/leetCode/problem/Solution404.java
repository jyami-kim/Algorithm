package com.jyami.leetCode.problem;

import com.sun.javafx.collections.ListListenerHelper;
import org.junit.jupiter.api.Test;

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

    @Test
    void sumOfLeftLeavesTest() {
        TreeNode node = new TreeNode(1);
        System.out.println(sumOfLeftLeaves(node));
    }
}

package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/08/08
 */
public class Solution437 {

    int sumNum = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        pathHelper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return sumNum;
    }

    private void pathHelper(TreeNode root, int sum) {
        if (root != null && root.val == sum) {
            sumNum++;
        }
        if (root != null) {
            sum -= root.val;
            pathHelper(root.left, sum);
            pathHelper(root.right, sum);
        }
    }

    @Test
    void pathSumTest() {
        TreeNode treeNode = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3, new TreeNode(3), new TreeNode(-2)),
                        new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));

        System.out.println(pathSum(treeNode, 8));
    }
}

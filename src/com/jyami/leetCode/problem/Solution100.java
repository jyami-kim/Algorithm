package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

/**
 * Created by jyami on 2020/07/14
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            } else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        } else if (p == null && q == null) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    void isSameTreeTest() {
        TreeNode p = new TreeNode(1, new TreeNode(2), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2));

        boolean sameTree = isSameTree(null, null);
        System.out.println(sameTree);
    }
}

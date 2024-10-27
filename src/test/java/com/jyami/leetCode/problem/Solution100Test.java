package com.jyami.leetCode.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution100Test {

    @Test
    void isSameTreeTest() {
        TreeNode p = new TreeNode(1, new TreeNode(2), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2));

        boolean sameTree = new Solution100().isSameTree(null, null);
        System.out.println(sameTree);
    }

}

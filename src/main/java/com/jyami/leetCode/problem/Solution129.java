package com.jyami.leetCode.problem;

/**
 * Created by jyami on 2020/06/26
 */
public class Solution129 {

    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return getSolution(root, 0);
    }

    public int getSolution(TreeNode root, int num) {
        int val = root.val;
        System.out.println(root.val);
        if (root.right == null && root.left == null) {
            return num * 10 + val;
        }
        int sum = 0;
        if (root.left != null) {
            sum += getSolution(root.left, num * 10 + val);
        }
        if (root.right != null) {
            sum += getSolution(root.right, num * 10 + val);
        }
        return sum;
    }



    public int getNowPow(int num) {
        int pow = 0;
        while (num != 0) {
            num = num / 10;
            pow++;
        }
        return pow;
    }

    class Result {
        int result;
        int pow;

        Result(int result, int pow) {
            this.result = result;
            this.pow = pow;
        }

    }
}

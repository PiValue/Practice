package com.twitter;

import lombok.AllArgsConstructor;

public class MaxPathSum {
    private static int MAX_VAL = 0;
    private static int SUM_VAL = 1;


    public int maxNodeSum(TreeNode root) {
        if (root == null) return 0;

        return maxNodeSumHelper(root)[MAX_VAL];
    }


    private int[] maxNodeSumHelper(TreeNode root) {
        if (root == null) {
            return new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};
        }

        if (root.left == null && root.right == null) {
            // Leaf
            return new int[] {root.val, root.val};
        }

        int[] left = maxNodeSumHelper(root.left);
        int[] right = maxNodeSumHelper(root.right);

        int max = Math.max(left[MAX_VAL], right[MAX_VAL]);
        int sum = root.val + Math.max(left[SUM_VAL], right[SUM_VAL]);
        return new int[] {Math.max(sum, max), sum};
    }


    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5,
//                                     new TreeNode(-4, new TreeNode(1, null, null), new TreeNode(7, null, null)),
//                                     new TreeNode(1, null ,new TreeNode(-1, null, null)));
        TreeNode root = new TreeNode(-1, new TreeNode(8, null, null), null);
        System.out.println(new MaxPathSum().maxNodeSum(root));
    }

    @AllArgsConstructor
    private static class TreeNode {
        private int val;
        private TreeNode left, right;
    }
}

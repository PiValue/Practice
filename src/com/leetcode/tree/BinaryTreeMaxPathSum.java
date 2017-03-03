package com.leetcode.tree;

public class BinaryTreeMaxPathSum {
    public int sum(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return (root == null) ? 0 : root.val;
        }
        SubSum sum = sumRecurr(root);
        return sum.max;
    }
    
    public SubSum sumRecurr(TreeNode root) {
        if (root == null) {
            return new SubSum(0, 0);
        }
        final SubSum left = sumRecurr(root.left);
        final SubSum right = sumRecurr(root.right);

        int myMax = root.val + left.maxPath + right.maxPath;
        myMax = Math.max(myMax, Math.max(left.max, right.max));
        int maxPath = Math.max(left.maxPath, right.maxPath) + root.val;
        return new SubSum(myMax, maxPath);
    }
    
    public static void main(String[] args) {
        BinaryTreeMaxPathSum obj = new BinaryTreeMaxPathSum();
        TreeNode root = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        System.out.println(obj.sum(root));
    }
    
    private class SubSum {
        public int max;
        public int maxPath; // Maximum path from this node either on left or right
        
        public SubSum(int max, int maxPath) {
            this.max = max;
            this.maxPath = maxPath;
        }
    }
}

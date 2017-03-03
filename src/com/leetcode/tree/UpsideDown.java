package com.leetcode.tree;

public class UpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        return upsideDownBinaryTree(null, root, null);
        
    }
    
    public TreeNode upsideDownBinaryTree(TreeNode parent, TreeNode cur, TreeNode sibling) {
        if(cur == null && sibling == null) {
            return null;
        }
        
        TreeNode temp = upsideDownBinaryTree(cur,cur.left,cur.right);
        
        cur.right = parent;
        cur.left = sibling;
        
        return(temp==null?cur:temp);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, null, null));
        UpsideDown obj = new UpsideDown();
        System.out.println(obj.upsideDownBinaryTree(root));
    }
}

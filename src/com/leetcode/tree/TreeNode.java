package com.leetcode.tree;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TreeNode {
    public int val;
    public TreeNode left, right;
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

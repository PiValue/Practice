package com.other;

import lombok.AllArgsConstructor;

public class TreeRotation {

    public void deleteTree(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                // candidate to delete.
                TreeNode temp = root;
                root = root.right;
                delete(temp);
            } else {
                // Has to complete rotation.
                TreeNode left = root.left;
                root.left = left.right;
                left.right = root;
                root = left;
            }
        }
    }

    public void deleteWithoutRotation(TreeNode root) {

    }

    private void delete(TreeNode node) {
        System.out.println(node.val);
    }

    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4,
                                        new TreeNode(8, null, null),
                                        null),
                                new TreeNode(5,
                                        null,
                                        new TreeNode(9, null, null))),
                        new TreeNode(3,
                                new TreeNode(6, null, null),
                                new TreeNode(7,
                                        new TreeNode(10, null, null),
                                        null)));
        new TreeRotation().deleteTree(root);
    }

    @AllArgsConstructor
    private static class TreeNode {
        private int val;
        private TreeNode left, right;
    }
}

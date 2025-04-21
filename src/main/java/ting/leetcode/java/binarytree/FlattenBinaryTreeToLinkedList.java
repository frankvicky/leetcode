package ting.leetcode.java.binarytree;


public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode r = root;
        while (r.right != null)
            r = r.right;

        r.right = right;
    }
}

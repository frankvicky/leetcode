package ting.leetcode.java.binarytree;

public class CountGoodNodesInBinaryTree {
    private int res = 0;
    public int goodNodes(TreeNode root) {
        traverse(root, Integer.MIN_VALUE);
        return res;
    }

    private void traverse(TreeNode root, int max) {
        if (root == null) {
            return;
        }

        if (max <= root.val) {
            res++;
            max = root.val;
        }

        traverse(root.left, max);
        traverse(root.right, max);
    }
}

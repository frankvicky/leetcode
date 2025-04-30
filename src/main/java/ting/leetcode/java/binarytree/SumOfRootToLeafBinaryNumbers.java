package ting.leetcode.java.binarytree;

public class SumOfRootToLeafBinaryNumbers {
    private int path = 0;
    private int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            res += path << 1 | root.val;
            return;
        }

        path = path << 1 | root.val;
        traverse(root.left);
        traverse(root.right);
        path = path >> 1;
    }
}

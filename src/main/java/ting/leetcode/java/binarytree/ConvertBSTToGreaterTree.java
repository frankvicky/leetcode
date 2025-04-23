package ting.leetcode.java.binarytree;

public class ConvertBSTToGreaterTree {
    private int accumulator = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = convertBST(root.right);
        accumulator += root.val;
        root.val = accumulator;
        TreeNode left = convertBST(root.left);

        return root;
    }

    int acc = 0;
    private int temp(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = temp(root.left);
        acc += root.val;
        int right = temp(root.right);
        return root.val + left + right;
    }
}

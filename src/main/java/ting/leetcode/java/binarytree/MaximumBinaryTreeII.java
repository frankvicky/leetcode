package ting.leetcode.java.binarytree;

public class MaximumBinaryTreeII {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val > root.val)
            return new TreeNode(val, root, null);
        else
            root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}

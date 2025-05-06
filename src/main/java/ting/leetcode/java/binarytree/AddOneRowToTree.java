package ting.leetcode.java.binarytree;

public class AddOneRowToTree {
    private int currentDepth = 0;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        traverse(root, val, depth);
        return root;
    }

    private void traverse(TreeNode root, int val, int depth) {
        if (root == null) {
            return;
        }

        currentDepth++;
        if (currentDepth == depth - 1) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);

        }

        traverse(root.left, val, depth);
        traverse(root.right, val, depth);
        currentDepth--;
    }
}

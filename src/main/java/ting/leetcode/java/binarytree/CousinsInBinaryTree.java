package ting.leetcode.java.binarytree;

public class CousinsInBinaryTree {
    private int depth = 0;
    private TreeNode parentX = null;
    private int xDepth = 0;
    private TreeNode parentY = null;
    private int yDepth = 0;

    public boolean isCousins(TreeNode root, int x, int y) {
        traverse(root, x, y, null);
        return xDepth == yDepth && parentX != parentY;
    }

    private void traverse(TreeNode root, int x, int y, TreeNode parent) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            parentX = parent;
            xDepth = depth;
        }

        if (root.val == y) {
            parentY = parent;
            yDepth = depth;
        }

        depth++;
        traverse(root.left, x, y, root);
        traverse(root.right, x, y, root);
        depth--;
    }
}

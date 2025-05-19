package ting.leetcode.java.binarytree;

public class SubtreeOfAnotherTree {
    private TreeNode target;
    private boolean isSame = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        target = subRoot;
        traverse(root);
        return isSame;
    }

    private void traverse(TreeNode root) {
        if (root == null || isSame) {
            return;
        }

        if (root.val == target.val)
            isSame = isSame(root, target);

        traverse(root.left);
        traverse(root.right);
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}

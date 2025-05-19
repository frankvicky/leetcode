package ting.leetcode.java.binarytree;

public class BinaryTreeColoringGame {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode node = find(root, x);
        int leftTotal = count(node.left);
        int rightTotal = count(node.right);
        int remainingTotal = n - 1 - leftTotal - rightTotal;
        return Math.max(remainingTotal, Math.max(leftTotal, rightTotal)) > (n >> 1);
    }

    private TreeNode find(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        if (root.val == target)
            return root;

        // search left first
        TreeNode left = find(root.left, target);
        if (left != null) {
            return left;
        }

        // if not in left, then search right
        return find(root.right, target);
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
}

package ting.leetcode.java.binarytree;


public class PathSum {
    boolean ans = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        traverse(root, 0, targetSum);
        return ans;
    }

    public Integer traverse(TreeNode node, int acc, int targetSum) {
        if (node == null) {
            return 0;
        }

        int sum = acc + node.val;

        traverse(node.left, sum, targetSum);
        traverse(node.right, sum, targetSum);

        if (sum == targetSum && node.left == null && node.right == null) {
            ans = true;
        }
        return sum;
    }

    public boolean hasPathSumRecursion(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSumRecursion(root.left, targetSum - root.val) || hasPathSumRecursion(root.right, targetSum - root.val);

    }
}

package ting.leetcode.java.binarytree;

public class PseudoPalindromicPathsInABinaryTree {
    private final int[] counter = new int[10];
    private int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        counter[root.val]++;

        if (root.left == null && root.right == null) {
            int odd = 0;
            for (int i = 1; i < counter.length; i++) {
                if ((counter[i] & 1) == 1) {
                    odd++;
                }
            }
            if (odd <= 1) res++;
            counter[root.val]--;
            return;
        }

        traverse(root.left);
        traverse(root.right);

        counter[root.val]--;
    }
}

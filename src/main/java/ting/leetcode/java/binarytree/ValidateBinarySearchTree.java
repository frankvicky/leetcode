package ting.leetcode.java.binarytree;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * @param root root of subtree
     * @param max the max node of current subtree
     * @param min the min node of current subtree
     * @return current subtree fit the definition of BST (max.val > root.val > min.val)
     */
    public boolean isValidBST(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null)
            return true;

        if (min != null && root.val <= min.val) {
            return false;
        }

        if (max != null && root.val >= max.val) {
            return false;
        }

        return isValidBST(root.left, root, min) && isValidBST(root.right, max, root);
    }
}

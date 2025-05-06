package ting.leetcode.java.binarytree;

import java.util.LinkedList;
import java.util.List;

public class FlipBinaryTreeToMatchPreorderTraversal {
    private final LinkedList<Integer> res = new LinkedList<>();
    private int i = 0;
    private boolean canFlip = true;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        traverse(root, voyage);
        return canFlip ? res : List.of(-1);
    }

    private void traverse(TreeNode root, int[] voyage) {
        if (root == null || !canFlip) {
            return;
        }

        if (root.val != voyage[i++]) {
            canFlip = false;
            return;
        }

        if (root.left != null && root.left.val != voyage[i]) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            res.add(root.val);
        }

        traverse(root.left, voyage);
        traverse(root.right, voyage);
    }
}

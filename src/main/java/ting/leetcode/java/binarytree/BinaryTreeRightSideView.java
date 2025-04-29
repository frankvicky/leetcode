package ting.leetcode.java.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    private final List<Integer> res = new ArrayList<>();
    private int depth = 0;
    public List<Integer> rightSideView(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        if (res.size() < depth) {
           res.add(root.val);
        }

        traverse(root.right);
        traverse(root.left);
        depth--;
    }
}

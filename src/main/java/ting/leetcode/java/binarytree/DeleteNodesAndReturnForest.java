package ting.leetcode.java.binarytree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    private final Set<Integer>  delSet = new HashSet<>();
    private final List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return List.of();
        }

        for (int d : to_delete) {
            delSet.add(d);
        }
        doDelete(root, false);
        return res;
    }

    private TreeNode doDelete(TreeNode root, boolean hasParent) {
        if (root == null) {
            return null;
        }

        boolean deleted = delSet.contains(root.val);
        if (!deleted && !hasParent) {
            res.add(root);
        }
        root.left = doDelete(root.left, !deleted);
        root.right = doDelete(root.right, !deleted);
        return deleted ? null : root;
    }
}

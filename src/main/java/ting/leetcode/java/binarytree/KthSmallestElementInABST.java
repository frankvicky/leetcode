package ting.leetcode.java.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> traverse = traverse(root);
        return traverse.get(k - 1);
    }

    private List<Integer> traverse(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }

        ArrayList<Integer> record = new ArrayList<>();
        record.addAll(traverse(node.left));
        record.add(node.val);
        record.addAll(traverse(node.right));
        return record;
    }
}

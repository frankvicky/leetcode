package ting.leetcode.java.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<Integer> record = new ArrayList<>();
        record.addAll(postorderTraversal(root.left));
        record.addAll(postorderTraversal(root.right));
        record.add(root.val);
        return record;
    }
}

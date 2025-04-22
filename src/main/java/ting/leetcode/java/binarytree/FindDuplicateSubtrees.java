package ting.leetcode.java.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {
    private final HashMap<String, Integer> serializedSubtreeToCount = new HashMap<>();
    private final List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }

    /**
     * @param root root of subtree
     * @return the result of subtree serialization
     */
    private String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);
        String serializedSubtree = left + "," + right + "," + root.val;
        int count = serializedSubtreeToCount.getOrDefault(serializedSubtree, 0);
        if (count == 1) {
            res.add(root);
        }
        serializedSubtreeToCount.put(serializedSubtree, count + 1);

        return serializedSubtree;
    }
}

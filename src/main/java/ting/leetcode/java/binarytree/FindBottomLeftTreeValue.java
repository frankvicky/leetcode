package ting.leetcode.java.binarytree;

public class FindBottomLeftTreeValue {
    TreeNode deepestLeftNode;
    int maxDepth = 0;
    public int findBottomLeftValue(TreeNode root) {
        traverse(root, 1);
        return deepestLeftNode == null ? 0 : deepestLeftNode.val;
    }

    void traverse(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (depth > maxDepth) {
            deepestLeftNode = node;
            maxDepth = depth;
        }

        traverse(node.left, depth + 1);
        traverse(node.right, depth + 1);
    }
}

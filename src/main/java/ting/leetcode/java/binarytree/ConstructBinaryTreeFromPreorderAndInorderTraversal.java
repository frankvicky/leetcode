package ting.leetcode.java.binarytree;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private final HashMap<Integer, Integer> valToIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    /**
     * @param preorder
     * @param leftBoundOfPreOder inclusive
     * @param rightBoundOfPreOrder exclusive
     * @param inorder
     * @param leftBoundOfInorder inclusive
     * @param rightBoundOfInorder exclusive
     * @return root of subtree
     */
    private TreeNode build(int[] preorder,
                           int leftBoundOfPreOder,
                           int rightBoundOfPreOrder,
                           int[] inorder,
                           int leftBoundOfInorder,
                           int rightBoundOfInorder) {
        if (rightBoundOfInorder - leftBoundOfInorder < 1)
            return null;

        int rootValue = preorder[leftBoundOfPreOder];
        int rootIndexOfInorder = valToIndex.get(rootValue);
        int leftTreeSize = rootIndexOfInorder - leftBoundOfInorder;

        TreeNode root = new TreeNode(rootValue);
        root.left = build(preorder, leftBoundOfPreOder + 1, leftTreeSize + 1, inorder, leftBoundOfInorder, rootIndexOfInorder);
        root.right = build(preorder, leftBoundOfPreOder + leftTreeSize + 1, rightBoundOfPreOrder, inorder, rootIndexOfInorder + 1, rightBoundOfInorder);
        return root;
    }
}

package ting.leetcode.java.binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private Map<Integer, Integer> valueToIndexOfInorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;
        valueToIndexOfInorder = HashMap.newHashMap(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            valueToIndexOfInorder.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode build(
      int[] inorder, int leftBoundOfInorder, int rightBoundOfInorder,
      int[] postorder, int leftBoundOfPostorder, int rightBoundOfPostorder
    ) {
        if (rightBoundOfPostorder - leftBoundOfPostorder < 1)
            return null;
        int rootValue = postorder[rightBoundOfPostorder - 1];
        int rootIndex = valueToIndexOfInorder.get(rootValue);
        int leftSize = rootIndex - leftBoundOfInorder;

        TreeNode left = build(inorder, leftBoundOfInorder, rootIndex,
            postorder, leftBoundOfPostorder, leftBoundOfPostorder + leftSize);
        TreeNode right = build(inorder, rootIndex + 1, rightBoundOfInorder,
            postorder, leftBoundOfPostorder + leftSize, rightBoundOfPostorder - 1);
        return new TreeNode(rootValue, left, right);
    }
}

package ting.leetcode.java.binarytree;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

//        如果左子樹或右子樹的深度為0，則說明該節點只有一個子節點（因為如果存在兩個子節點，深度肯定大於0）。
//        在這種情況下，返回非0那一邊的深度再加上1（自身的深度）。
        if (leftDepth == 0)
            return rightDepth + 1;

        if (rightDepth == 0)
            return leftDepth + 1;

        return Math.min(leftDepth, rightDepth) + 1;
    }
}

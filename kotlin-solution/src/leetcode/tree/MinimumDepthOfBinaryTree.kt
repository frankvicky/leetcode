package leetcode.tree

import kotlin.math.min

class MinimumDepthOfBinaryTree {
    fun minDepth(root: leetcode.tree.TreeNode?): Int {
        root ?: return 0

        val leftDepth = minDepth(root.left)
        val rightDepth = minDepth(root.right)

        if (leftDepth == 0)
            return rightDepth + 1

        if (rightDepth == 0)
            return leftDepth + 1

        return min(leftDepth, rightDepth) + 1
    }
}

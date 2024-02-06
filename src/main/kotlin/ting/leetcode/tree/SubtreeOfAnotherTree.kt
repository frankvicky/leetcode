package ting.leetcode.tree

class SubtreeOfAnotherTree {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean =
        when {
            root == null && subRoot == null -> true
            root == null && subRoot != null -> false
            root != null && subRoot == null -> false
            else -> isNodeEqual(root, subRoot) || isSubtree(root?.left, subRoot) || isSubtree(root?.right, subRoot)
        }

    fun isNodeEqual(node1: TreeNode?, node2: TreeNode?): Boolean =
        when {
            node1 == null && node2 == null -> true
            node1 == null && node2 != null -> false
            node1 != null && node2 == null -> false
            else -> node1?.`val` == node2?.`val` && isNodeEqual(node1?.left, node2?.left) && isNodeEqual(node1?.right, node2?.right)
        }
}